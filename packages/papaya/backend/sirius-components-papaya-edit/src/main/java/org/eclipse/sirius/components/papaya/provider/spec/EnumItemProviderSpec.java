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
package org.eclipse.sirius.components.papaya.provider.spec;

import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.edit.provider.ComposedImage;
import org.eclipse.sirius.components.papaya.Enum;
import org.eclipse.sirius.components.papaya.provider.EnumItemProvider;
import org.eclipse.sirius.components.papaya.provider.spec.images.VisibilityOverlayImageProvider;

/**
 * Customization of the item provider implementation generated by EMF.
 *
 * @author sbegaudeau
 */
public class EnumItemProviderSpec extends EnumItemProvider {
    public EnumItemProviderSpec(AdapterFactory adapterFactory) {
        super(adapterFactory);
    }

    @Override
    public Object getImage(Object object) {
        if (object instanceof Enum anEnum) {
            var visibilityImage = new VisibilityOverlayImageProvider().overlayImage(this.getResourceLocator(), anEnum.getVisibility());

            return new ComposedImage(List.of(
                    this.getResourceLocator().getImage("full/obj16/Enum.svg"),
                    visibilityImage
            ));
        }
        return this.overlayImage(object, this.getResourceLocator().getImage("full/obj16/Enum.svg"));
    }
}