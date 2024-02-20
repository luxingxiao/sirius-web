/*******************************************************************************
 * Copyright (c) 2024 Obeo.
 * This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.eclipse.sirius.web.application.editingcontext.services;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.sirius.components.core.api.IEditingContext;
import org.eclipse.sirius.components.core.api.IEditingContextProcessor;
import org.eclipse.sirius.components.core.api.IEditingContextRepresentationDescriptionProvider;
import org.eclipse.sirius.components.core.api.IEditingContextSearchService;
import org.eclipse.sirius.components.emf.ResourceMetadataAdapter;
import org.eclipse.sirius.components.emf.services.EditingContextCrossReferenceAdapter;
import org.eclipse.sirius.components.emf.services.JSONResourceFactory;
import org.eclipse.sirius.emfjson.resource.JsonResource;
import org.eclipse.sirius.web.application.UUIDParser;
import org.eclipse.sirius.web.application.editingcontext.EditingContext;
import org.eclipse.sirius.web.application.editingcontext.services.api.IEditingDomainFactory;
import org.eclipse.sirius.web.domain.boundedcontexts.project.Project;
import org.eclipse.sirius.web.domain.boundedcontexts.project.services.api.IProjectSearchService;
import org.eclipse.sirius.web.domain.boundedcontexts.semanticdata.SemanticData;
import org.eclipse.sirius.web.domain.boundedcontexts.semanticdata.services.api.ISemanticDataSearchService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.jdbc.core.mapping.AggregateReference;
import org.springframework.stereotype.Service;

import io.micrometer.core.instrument.MeterRegistry;
import io.micrometer.core.instrument.Timer;

/**
 * Service used to find and retrieve editing contexts.
 *
 * @author sbegaudeau
 */
@Service
public class EditingContextSearchService implements IEditingContextSearchService {

    private static final String TIMER_NAME = "siriusweb_editingcontext_load";

    private final Logger logger = LoggerFactory.getLogger(EditingContextSearchService.class);

    private final IProjectSearchService projectSearchService;

    private final ISemanticDataSearchService semanticDataSearchService;

    private final IEditingDomainFactory editingDomainFactory;

    private final List<IEditingContextRepresentationDescriptionProvider> representationDescriptionProviders;

    private final List<IEditingContextProcessor> editingContextProcessors;

    private final Timer timer;

    public EditingContextSearchService(IProjectSearchService projectSearchService, ISemanticDataSearchService semanticDataSearchService, IEditingDomainFactory editingDomainFactory,
                                       List<IEditingContextRepresentationDescriptionProvider> representationDescriptionProviders, List<IEditingContextProcessor> editingContextProcessors, MeterRegistry meterRegistry) {
        this.projectSearchService = Objects.requireNonNull(projectSearchService);
        this.semanticDataSearchService = Objects.requireNonNull(semanticDataSearchService);
        this.editingDomainFactory = Objects.requireNonNull(editingDomainFactory);
        this.representationDescriptionProviders = Objects.requireNonNull(representationDescriptionProviders);
        this.editingContextProcessors = Objects.requireNonNull(editingContextProcessors);
        this.timer = Timer.builder(TIMER_NAME).register(meterRegistry);
    }

    @Override
    public boolean existsById(String editingContextId) {
        return new UUIDParser().parse(editingContextId)
                .map(AggregateReference::<Project, UUID>to)
                .map(this.semanticDataSearchService::existsByProject)
                .orElse(false);
    }

    @Override
    public Optional<IEditingContext> findById(String editingContextId) {
        return new UUIDParser().parse(editingContextId)
                .flatMap(this.projectSearchService::findById)
                .map(this::toEditingContext);
    }

    private IEditingContext toEditingContext(Project project) {
        long start = System.currentTimeMillis();

        this.logger.debug("Loading the editing context {}", project.getId());

        AdapterFactoryEditingDomain editingDomain = this.editingDomainFactory.createEditingDomain(project);
        EditingContext editingContext = new EditingContext(project.getId().toString(), editingDomain, new HashMap<>(), new ArrayList<>());
        this.editingContextProcessors.forEach(processor -> processor.preProcess(editingContext));

        this.semanticDataSearchService.findByProject(AggregateReference.to(project.getId()))
                .ifPresent(semanticData -> this.loadSemanticData(editingContext, semanticData));

        this.representationDescriptionProviders.forEach(representationDescriptionProvider -> {
            var representationDescriptions = representationDescriptionProvider.getRepresentationDescriptions(editingContext);
            representationDescriptions.forEach(representationDescription -> editingContext.getRepresentationDescriptions().put(representationDescription.getId(), representationDescription));
        });

        this.editingContextProcessors.forEach(processor -> processor.postProcess(editingContext));

        long end = System.currentTimeMillis();
        this.timer.record(end - start, TimeUnit.MILLISECONDS);

        return editingContext;
    }

    private void loadSemanticData(EditingContext editingContext, SemanticData semanticData) {
        ResourceSet resourceSet = editingContext.getDomain().getResourceSet();
        resourceSet.getLoadOptions().put(JsonResource.OPTION_SCHEMA_LOCATION, true);

        var documents = semanticData.getDocuments();
        for (var document : documents) {
            var resource = new JSONResourceFactory().createResourceFromPath(document.getId().toString());

            try (var inputStream = new ByteArrayInputStream(document.getContent().getBytes())) {
                resourceSet.getResources().add(resource);
                resource.load(inputStream, null);

                resource.eAdapters().add(new ResourceMetadataAdapter(document.getName()));
            } catch (IOException | IllegalArgumentException exception) {
                this.logger.warn("An error occured while loading document {}: {}.", document.getId(), exception.getMessage());
                resourceSet.getResources().remove(resource);
            }
        }

        // The ECrossReferenceAdapter must be set after the resource loading because it needs to resolve proxies in case
        // of inter-resources references
        resourceSet.eAdapters().add(new EditingContextCrossReferenceAdapter());

        this.logger.debug("{} documents loaded for the editing context {}", resourceSet.getResources().size(), editingContext.getId());
    }
}