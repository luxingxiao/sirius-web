/*******************************************************************************
 * Copyright (c) 2023 Obeo.
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
package org.eclipse.sirius.components.widgets.reference.provider;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.util.ResourceLocator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.command.CommandParameter;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.edit.provider.ChangeNotifier;
import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.provider.IChangeNotifier;
import org.eclipse.emf.edit.provider.IChildCreationExtender;
import org.eclipse.emf.edit.provider.IDisposable;
import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.INotifyChangedListener;
import org.eclipse.emf.edit.provider.IStructuredItemContentProvider;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;
import org.eclipse.sirius.components.view.form.FlexboxContainerDescription;
import org.eclipse.sirius.components.view.form.FormPackage;
import org.eclipse.sirius.components.view.form.GroupDescription;
import org.eclipse.sirius.components.view.form.util.FormSwitch;
import org.eclipse.sirius.components.widgets.reference.ReferenceFactory;
import org.eclipse.sirius.components.widgets.reference.util.ReferenceAdapterFactory;

/**
 * This is the factory that is used to provide the interfaces needed to support
 * Viewers. The adapters generated by this factory convert EMF adapter
 * notifications into calls to {@link #fireNotifyChanged fireNotifyChanged}. The
 * adapters also support Eclipse property sheets. Note that most of the adapters
 * are shared among multiple instances. <!-- begin-user-doc --> <!--
 * end-user-doc -->
 *
 * @generated
 */
public class ReferenceItemProviderAdapterFactory extends ReferenceAdapterFactory
        implements ComposeableAdapterFactory, IChangeNotifier, IDisposable {

    /**
     * This keeps track of the root adapter factory that delegates to this adapter
     * factory. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    protected ComposedAdapterFactory parentAdapterFactory;

    /**
     * This is used to implement
     * {@link org.eclipse.emf.edit.provider.IChangeNotifier}. <!-- begin-user-doc
     * --> <!-- end-user-doc -->
     *
     * @generated
     */
    protected IChangeNotifier changeNotifier = new ChangeNotifier();

    /**
     * This keeps track of all the supported types checked by
     * {@link #isFactoryForType isFactoryForType}. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     *
     * @generated
     */
    protected Collection<Object> supportedTypes = new ArrayList<>();
    /**
     * This keeps track of the one adapter used for all
     * {@link org.eclipse.sirius.components.widgets.reference.ReferenceWidgetDescription}
     * instances. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    protected ReferenceWidgetDescriptionItemProvider referenceWidgetDescriptionItemProvider;
    /**
     * This keeps track of the one adapter used for all
     * {@link org.eclipse.sirius.components.widgets.reference.ReferenceWidgetDescriptionStyle}
     * instances. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    protected ReferenceWidgetDescriptionStyleItemProvider referenceWidgetDescriptionStyleItemProvider;
    /**
     * This keeps track of the one adapter used for all
     * {@link org.eclipse.sirius.components.widgets.reference.ConditionalReferenceWidgetDescriptionStyle}
     * instances. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    protected ConditionalReferenceWidgetDescriptionStyleItemProvider conditionalReferenceWidgetDescriptionStyleItemProvider;

    /**
     * This constructs an instance. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    public ReferenceItemProviderAdapterFactory() {
        this.supportedTypes.add(IEditingDomainItemProvider.class);
        this.supportedTypes.add(IStructuredItemContentProvider.class);
        this.supportedTypes.add(ITreeItemContentProvider.class);
        this.supportedTypes.add(IItemLabelProvider.class);
        this.supportedTypes.add(IItemPropertySource.class);
    }

    /**
     * This creates an adapter for a
     * {@link org.eclipse.sirius.components.widgets.reference.ReferenceWidgetDescription}.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public Adapter createReferenceWidgetDescriptionAdapter() {
        if (this.referenceWidgetDescriptionItemProvider == null) {
            this.referenceWidgetDescriptionItemProvider = new ReferenceWidgetDescriptionItemProvider(this);
        }

        return this.referenceWidgetDescriptionItemProvider;
    }

    /**
     * This creates an adapter for a
     * {@link org.eclipse.sirius.components.widgets.reference.ReferenceWidgetDescriptionStyle}.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public Adapter createReferenceWidgetDescriptionStyleAdapter() {
        if (this.referenceWidgetDescriptionStyleItemProvider == null) {
            this.referenceWidgetDescriptionStyleItemProvider = new ReferenceWidgetDescriptionStyleItemProvider(this);
        }

        return this.referenceWidgetDescriptionStyleItemProvider;
    }

    /**
     * This creates an adapter for a
     * {@link org.eclipse.sirius.components.widgets.reference.ConditionalReferenceWidgetDescriptionStyle}.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public Adapter createConditionalReferenceWidgetDescriptionStyleAdapter() {
        if (this.conditionalReferenceWidgetDescriptionStyleItemProvider == null) {
            this.conditionalReferenceWidgetDescriptionStyleItemProvider = new ConditionalReferenceWidgetDescriptionStyleItemProvider(
                    this);
        }

        return this.conditionalReferenceWidgetDescriptionStyleItemProvider;
    }

    /**
     * This returns the root adapter factory that contains this factory. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public ComposeableAdapterFactory getRootAdapterFactory() {
        return this.parentAdapterFactory == null ? this : this.parentAdapterFactory.getRootAdapterFactory();
    }

    /**
     * This sets the composed adapter factory that contains this factory. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public void setParentAdapterFactory(ComposedAdapterFactory parentAdapterFactory) {
        this.parentAdapterFactory = parentAdapterFactory;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public boolean isFactoryForType(Object type) {
        return this.supportedTypes.contains(type) || super.isFactoryForType(type);
    }

    /**
     * This implementation substitutes the factory itself as the key for the
     * adapter. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public Adapter adapt(Notifier notifier, Object type) {
        return super.adapt(notifier, this);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public Object adapt(Object object, Object type) {
        if (this.isFactoryForType(type)) {
            Object adapter = super.adapt(object, type);
            if (!(type instanceof Class<?>) || (((Class<?>) type).isInstance(adapter))) {
                return adapter;
            }
        }

        return null;
    }

    /**
     * This adds a listener. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public void addListener(INotifyChangedListener notifyChangedListener) {
        this.changeNotifier.addListener(notifyChangedListener);
    }

    /**
     * This removes a listener. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public void removeListener(INotifyChangedListener notifyChangedListener) {
        this.changeNotifier.removeListener(notifyChangedListener);
    }

    /**
     * This delegates to {@link #changeNotifier} and to
     * {@link #parentAdapterFactory}. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public void fireNotifyChanged(Notification notification) {
        this.changeNotifier.fireNotifyChanged(notification);

        if (this.parentAdapterFactory != null) {
            this.parentAdapterFactory.fireNotifyChanged(notification);
        }
    }

    /**
     * This disposes all of the item providers created by this factory. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public void dispose() {
        if (this.referenceWidgetDescriptionItemProvider != null)
            this.referenceWidgetDescriptionItemProvider.dispose();
        if (this.referenceWidgetDescriptionStyleItemProvider != null)
            this.referenceWidgetDescriptionStyleItemProvider.dispose();
        if (this.conditionalReferenceWidgetDescriptionStyleItemProvider != null)
            this.conditionalReferenceWidgetDescriptionStyleItemProvider.dispose();
    }

    /**
     * A child creation extender for the {@link FormPackage}. <!-- begin-user-doc
     * --> <!-- end-user-doc -->
     *
     * @generated
     */
    public static class FormChildCreationExtender implements IChildCreationExtender {

        /**
         * <!-- begin-user-doc --> <!-- end-user-doc -->
         *
         * @generated
         */
        @Override
        public Collection<Object> getNewChildDescriptors(Object object, EditingDomain editingDomain) {
            ArrayList<Object> result = new ArrayList<>();
            new CreationSwitch(result, editingDomain).doSwitch((EObject) object);
            return result;
        }

        /**
         * <!-- begin-user-doc --> <!-- end-user-doc -->
         *
         * @generated
         */
        @Override
        public ResourceLocator getResourceLocator() {
            return ReferenceEditPlugin.INSTANCE;
        }

        /**
         * The switch for creating child descriptors specific to each extended class.
         * <!-- begin-user-doc --> <!-- end-user-doc -->
         *
         * @generated
         */
        protected static class CreationSwitch extends FormSwitch<Object> {

            /**
             * The child descriptors being populated. <!-- begin-user-doc --> <!--
             * end-user-doc -->
             *
             * @generated
             */
            protected List<Object> newChildDescriptors;

            /**
             * The domain in which to create the children. <!-- begin-user-doc --> <!--
             * end-user-doc -->
             *
             * @generated
             */
            protected EditingDomain editingDomain;

            /**
             * Creates the a switch for populating child descriptors in the given domain.
             * <!-- begin-user-doc --> <!-- end-user-doc -->
             *
             * @generated
             */
            CreationSwitch(List<Object> newChildDescriptors, EditingDomain editingDomain) {
                this.newChildDescriptors = newChildDescriptors;
                this.editingDomain = editingDomain;
            }

            /**
             * <!-- begin-user-doc --> <!-- end-user-doc -->
             *
             * @generated
             */
            @Override
            public Object caseGroupDescription(GroupDescription object) {
                this.newChildDescriptors.add(this.createChildParameter(FormPackage.Literals.GROUP_DESCRIPTION__WIDGETS,
                        ReferenceFactory.eINSTANCE.createReferenceWidgetDescription()));

                return null;
            }

            /**
             * <!-- begin-user-doc --> <!-- end-user-doc -->
             *
             * @generated
             */
            @Override
            public Object caseFlexboxContainerDescription(FlexboxContainerDescription object) {
                this.newChildDescriptors
                        .add(this.createChildParameter(FormPackage.Literals.FLEXBOX_CONTAINER_DESCRIPTION__CHILDREN,
                                ReferenceFactory.eINSTANCE.createReferenceWidgetDescription()));

                return null;
            }

            /**
             * <!-- begin-user-doc --> <!-- end-user-doc -->
             *
             * @generated
             */
            protected CommandParameter createChildParameter(Object feature, Object child) {
                return new CommandParameter(null, feature, child);
            }

        }
    }

}