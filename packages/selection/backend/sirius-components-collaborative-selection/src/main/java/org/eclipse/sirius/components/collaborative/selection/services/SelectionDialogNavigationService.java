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
package org.eclipse.sirius.components.collaborative.selection.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.eclipse.sirius.components.collaborative.selection.services.api.ISelectionDialogNavigationService;
import org.eclipse.sirius.components.core.api.IEditingContext;
import org.eclipse.sirius.components.core.api.IObjectService;
import org.eclipse.sirius.components.core.api.IRepresentationDescriptionSearchService;
import org.eclipse.sirius.components.representations.VariableManager;
import org.eclipse.sirius.components.trees.Tree;
import org.eclipse.sirius.components.trees.description.TreeDescription;
import org.springframework.stereotype.Service;

/**
 * Services for the navigation through the Selection Dialog Tree.
 *
 * @author frouene
 * @author fbarbin
 */
@Service
public class SelectionDialogNavigationService implements ISelectionDialogNavigationService {

    private final IObjectService objectService;

    private final IRepresentationDescriptionSearchService representationDescriptionSearchService;

    public SelectionDialogNavigationService(IObjectService objectService, IRepresentationDescriptionSearchService representationDescriptionSearchService) {
        this.objectService = Objects.requireNonNull(objectService);
        this.representationDescriptionSearchService = Objects.requireNonNull(representationDescriptionSearchService);
    }

    @Override
    public List<String> getAncestors(IEditingContext editingContext, String treeItemId, Tree tree) {
        List<String> ancestorsIds = new ArrayList<>();

        Optional<Object> optionalObject = this.getParentSemanticObject(treeItemId, ancestorsIds, editingContext, tree);
        while (optionalObject.isPresent()) {
            String parentId = this.objectService.getId(optionalObject.get());
            ancestorsIds.add(parentId);
            optionalObject = this.getParentSemanticObject(parentId, ancestorsIds, editingContext, tree);
        }
        return ancestorsIds;
    }

    private Optional<Object> getParentSemanticObject(String elementId, List<String> ancestorsIds, IEditingContext editingContext, Tree tree) {
        Optional<Object> result = Optional.empty();

        var variableManager = new VariableManager();
        var optionalSemanticObject = this.getTreeItemObject(editingContext, elementId, tree);
        var optionalTreeDescription = this.representationDescriptionSearchService.findById(editingContext, tree.getDescriptionId())
                .filter(TreeDescription.class::isInstance)
                .map(TreeDescription.class::cast);

        if (optionalSemanticObject.isPresent() && optionalTreeDescription.isPresent()) {
            variableManager.put(VariableManager.SELF, optionalSemanticObject.get());
            variableManager.put(TreeDescription.ID, elementId);
            variableManager.put(IEditingContext.EDITING_CONTEXT, editingContext);
            result = Optional.ofNullable(optionalTreeDescription.get().getParentObjectProvider().apply(variableManager));
        }
        return result;
    }

    private Optional<Object> getTreeItemObject(IEditingContext editingContext, String id, Tree tree) {
        var optionalTreeDescription = this.representationDescriptionSearchService.findById(editingContext, tree.getDescriptionId())
                .filter(TreeDescription.class::isInstance)
                .map(TreeDescription.class::cast);

        if (optionalTreeDescription.isPresent()) {
            var variableManager = new VariableManager();
            variableManager.put(IEditingContext.EDITING_CONTEXT, editingContext);
            variableManager.put(TreeDescription.ID, id);
            return Optional.ofNullable(optionalTreeDescription.get().getTreeItemObjectProvider().apply(variableManager));
        }
        return Optional.empty();
    }
}