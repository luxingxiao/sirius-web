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

package org.eclipse.sirius.web.e2e.tests.services.api;

import java.util.List;

import org.eclipse.sirius.components.view.View;

/**
 * Used to provide e2e views.
 *
 * @author gcoutable
 */
public interface IE2EViewProvider {
    List<View> createViews();
}
