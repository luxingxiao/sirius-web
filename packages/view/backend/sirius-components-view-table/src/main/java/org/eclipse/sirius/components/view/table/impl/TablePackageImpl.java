/*******************************************************************************
 * Copyright (c) 2024 CEA LIST.
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
package org.eclipse.sirius.components.view.table.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.impl.EPackageImpl;
import org.eclipse.sirius.components.view.ViewPackage;
import org.eclipse.sirius.components.view.table.CellDescription;
import org.eclipse.sirius.components.view.table.CellLabelWidgetDescription;
import org.eclipse.sirius.components.view.table.CellTextfieldWidgetDescription;
import org.eclipse.sirius.components.view.table.CellWidgetDescription;
import org.eclipse.sirius.components.view.table.ColumnDescription;
import org.eclipse.sirius.components.view.table.RowDescription;
import org.eclipse.sirius.components.view.table.TableDescription;
import org.eclipse.sirius.components.view.table.TableElementDescription;
import org.eclipse.sirius.components.view.table.TableFactory;
import org.eclipse.sirius.components.view.table.TablePackage;

/**
 * <!-- begin-user-doc --> An implementation of the model <b>Package</b>. <!-- end-user-doc -->
 *
 * @generated
 */
public class TablePackageImpl extends EPackageImpl implements TablePackage {

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    private EClass tableDescriptionEClass = null;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    private EClass tableElementDescriptionEClass = null;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    private EClass columnDescriptionEClass = null;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    private EClass rowDescriptionEClass = null;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    private EClass cellDescriptionEClass = null;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    private EClass cellWidgetDescriptionEClass = null;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    private EClass cellTextfieldWidgetDescriptionEClass = null;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    private EClass cellLabelWidgetDescriptionEClass = null;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    private static boolean isInited = false;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    private boolean isCreated = false;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    private boolean isInitialized = false;

    /**
     * Creates an instance of the model <b>Package</b>, registered with {@link org.eclipse.emf.ecore.EPackage.Registry
     * EPackage.Registry} by the package package URI value.
     * <p>
     * Note: the correct way to create the package is via the static factory method {@link #init init()}, which also
     * performs initialization of the package, or returns the registered package, if one already exists. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @see org.eclipse.emf.ecore.EPackage.Registry
     * @see org.eclipse.sirius.components.view.table.TablePackage#eNS_URI
     * @see #init()
     */
    private TablePackageImpl() {
        super(eNS_URI, TableFactory.eINSTANCE);
    }

    /**
     * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
     *
     * <p>
     * This method is used to initialize {@link TablePackage#eINSTANCE} when that field is accessed. Clients should not
     * invoke it directly. Instead, they should simply access that field to obtain the package. <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     * @see #eNS_URI
     * @see #createPackageContents()
     * @see #initializePackageContents()
     */
    public static TablePackage init() {
        if (isInited)
            return (TablePackage) EPackage.Registry.INSTANCE.getEPackage(TablePackage.eNS_URI);

        // Obtain or create and register package
        Object registeredTablePackage = EPackage.Registry.INSTANCE.get(eNS_URI);
        TablePackageImpl theTablePackage = registeredTablePackage instanceof TablePackageImpl ? (TablePackageImpl) registeredTablePackage : new TablePackageImpl();

        isInited = true;

        // Initialize simple dependencies
        ViewPackage.eINSTANCE.eClass();

        // Create package meta-data objects
        theTablePackage.createPackageContents();

        // Initialize created meta-data
        theTablePackage.initializePackageContents();

        // Mark meta-data to indicate it can't be changed
        theTablePackage.freeze();

        // Update the registry and return the package
        EPackage.Registry.INSTANCE.put(TablePackage.eNS_URI, theTablePackage);
        return theTablePackage;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EClass getTableDescription() {
        return this.tableDescriptionEClass;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EAttribute getTableDescription_UseStripedRowsExpression() {
        return (EAttribute) this.tableDescriptionEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EReference getTableDescription_ColumnDescriptions() {
        return (EReference) this.tableDescriptionEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EReference getTableDescription_RowDescription() {
        return (EReference) this.tableDescriptionEClass.getEStructuralFeatures().get(2);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EReference getTableDescription_CellDescriptions() {
        return (EReference) this.tableDescriptionEClass.getEStructuralFeatures().get(3);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EClass getTableElementDescription() {
        return this.tableElementDescriptionEClass;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EAttribute getTableElementDescription_Name() {
        return (EAttribute) this.tableElementDescriptionEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EAttribute getTableElementDescription_DomainType() {
        return (EAttribute) this.tableElementDescriptionEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EAttribute getTableElementDescription_SemanticCandidatesExpression() {
        return (EAttribute) this.tableElementDescriptionEClass.getEStructuralFeatures().get(2);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EAttribute getTableElementDescription_PreconditionExpression() {
        return (EAttribute) this.tableElementDescriptionEClass.getEStructuralFeatures().get(3);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EClass getColumnDescription() {
        return this.columnDescriptionEClass;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EAttribute getColumnDescription_HeaderIndexLabelExpression() {
        return (EAttribute) this.columnDescriptionEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EAttribute getColumnDescription_HeaderLabelExpression() {
        return (EAttribute) this.columnDescriptionEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EAttribute getColumnDescription_HeaderIconExpression() {
        return (EAttribute) this.columnDescriptionEClass.getEStructuralFeatures().get(2);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EAttribute getColumnDescription_InitialWidthExpression() {
        return (EAttribute) this.columnDescriptionEClass.getEStructuralFeatures().get(3);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EAttribute getColumnDescription_IsResizableExpression() {
        return (EAttribute) this.columnDescriptionEClass.getEStructuralFeatures().get(4);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EAttribute getColumnDescription_FilterWidgetExpression() {
        return (EAttribute) this.columnDescriptionEClass.getEStructuralFeatures().get(5);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EClass getRowDescription() {
        return this.rowDescriptionEClass;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EAttribute getRowDescription_HeaderLabelExpression() {
        return (EAttribute) this.rowDescriptionEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EAttribute getRowDescription_HeaderIconExpression() {
        return (EAttribute) this.rowDescriptionEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EAttribute getRowDescription_HeaderIndexLabelExpression() {
        return (EAttribute) this.rowDescriptionEClass.getEStructuralFeatures().get(2);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EAttribute getRowDescription_InitialHeightExpression() {
        return (EAttribute) this.rowDescriptionEClass.getEStructuralFeatures().get(3);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EAttribute getRowDescription_IsResizableExpression() {
        return (EAttribute) this.rowDescriptionEClass.getEStructuralFeatures().get(4);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EClass getCellDescription() {
        return this.cellDescriptionEClass;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EAttribute getCellDescription_ValueExpression() {
        return (EAttribute) this.cellDescriptionEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EAttribute getCellDescription_TooltipExpression() {
        return (EAttribute) this.cellDescriptionEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EReference getCellDescription_CellWidgetDescription() {
        return (EReference) this.cellDescriptionEClass.getEStructuralFeatures().get(2);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EClass getCellWidgetDescription() {
        return this.cellWidgetDescriptionEClass;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EClass getCellTextfieldWidgetDescription() {
        return this.cellTextfieldWidgetDescriptionEClass;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EReference getCellTextfieldWidgetDescription_Body() {
        return (EReference) this.cellTextfieldWidgetDescriptionEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EClass getCellLabelWidgetDescription() {
        return this.cellLabelWidgetDescriptionEClass;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EAttribute getCellLabelWidgetDescription_IconExpression() {
        return (EAttribute) this.cellLabelWidgetDescriptionEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public TableFactory getTableFactory() {
        return (TableFactory) this.getEFactoryInstance();
    }

    /**
     * Creates the meta-model objects for the package. This method is guarded to have no affect on any invocation but
     * its first. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    public void createPackageContents() {
        if (this.isCreated)
            return;
        this.isCreated = true;

        // Create classes and their features
        this.tableDescriptionEClass = this.createEClass(TABLE_DESCRIPTION);
        this.createEAttribute(this.tableDescriptionEClass, TABLE_DESCRIPTION__USE_STRIPED_ROWS_EXPRESSION);
        this.createEReference(this.tableDescriptionEClass, TABLE_DESCRIPTION__COLUMN_DESCRIPTIONS);
        this.createEReference(this.tableDescriptionEClass, TABLE_DESCRIPTION__ROW_DESCRIPTION);
        this.createEReference(this.tableDescriptionEClass, TABLE_DESCRIPTION__CELL_DESCRIPTIONS);

        this.tableElementDescriptionEClass = this.createEClass(TABLE_ELEMENT_DESCRIPTION);
        this.createEAttribute(this.tableElementDescriptionEClass, TABLE_ELEMENT_DESCRIPTION__NAME);
        this.createEAttribute(this.tableElementDescriptionEClass, TABLE_ELEMENT_DESCRIPTION__DOMAIN_TYPE);
        this.createEAttribute(this.tableElementDescriptionEClass, TABLE_ELEMENT_DESCRIPTION__SEMANTIC_CANDIDATES_EXPRESSION);
        this.createEAttribute(this.tableElementDescriptionEClass, TABLE_ELEMENT_DESCRIPTION__PRECONDITION_EXPRESSION);

        this.columnDescriptionEClass = this.createEClass(COLUMN_DESCRIPTION);
        this.createEAttribute(this.columnDescriptionEClass, COLUMN_DESCRIPTION__HEADER_INDEX_LABEL_EXPRESSION);
        this.createEAttribute(this.columnDescriptionEClass, COLUMN_DESCRIPTION__HEADER_LABEL_EXPRESSION);
        this.createEAttribute(this.columnDescriptionEClass, COLUMN_DESCRIPTION__HEADER_ICON_EXPRESSION);
        this.createEAttribute(this.columnDescriptionEClass, COLUMN_DESCRIPTION__INITIAL_WIDTH_EXPRESSION);
        this.createEAttribute(this.columnDescriptionEClass, COLUMN_DESCRIPTION__IS_RESIZABLE_EXPRESSION);
        this.createEAttribute(this.columnDescriptionEClass, COLUMN_DESCRIPTION__FILTER_WIDGET_EXPRESSION);

        this.rowDescriptionEClass = this.createEClass(ROW_DESCRIPTION);
        this.createEAttribute(this.rowDescriptionEClass, ROW_DESCRIPTION__HEADER_LABEL_EXPRESSION);
        this.createEAttribute(this.rowDescriptionEClass, ROW_DESCRIPTION__HEADER_ICON_EXPRESSION);
        this.createEAttribute(this.rowDescriptionEClass, ROW_DESCRIPTION__HEADER_INDEX_LABEL_EXPRESSION);
        this.createEAttribute(this.rowDescriptionEClass, ROW_DESCRIPTION__INITIAL_HEIGHT_EXPRESSION);
        this.createEAttribute(this.rowDescriptionEClass, ROW_DESCRIPTION__IS_RESIZABLE_EXPRESSION);

        this.cellDescriptionEClass = this.createEClass(CELL_DESCRIPTION);
        this.createEAttribute(this.cellDescriptionEClass, CELL_DESCRIPTION__VALUE_EXPRESSION);
        this.createEAttribute(this.cellDescriptionEClass, CELL_DESCRIPTION__TOOLTIP_EXPRESSION);
        this.createEReference(this.cellDescriptionEClass, CELL_DESCRIPTION__CELL_WIDGET_DESCRIPTION);

        this.cellWidgetDescriptionEClass = this.createEClass(CELL_WIDGET_DESCRIPTION);

        this.cellTextfieldWidgetDescriptionEClass = this.createEClass(CELL_TEXTFIELD_WIDGET_DESCRIPTION);
        this.createEReference(this.cellTextfieldWidgetDescriptionEClass, CELL_TEXTFIELD_WIDGET_DESCRIPTION__BODY);

        this.cellLabelWidgetDescriptionEClass = this.createEClass(CELL_LABEL_WIDGET_DESCRIPTION);
        this.createEAttribute(this.cellLabelWidgetDescriptionEClass, CELL_LABEL_WIDGET_DESCRIPTION__ICON_EXPRESSION);
    }

    /**
     * Complete the initialization of the package and its meta-model. This method is guarded to have no affect on any
     * invocation but its first. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    public void initializePackageContents() {
        if (this.isInitialized)
            return;
        this.isInitialized = true;

        // Initialize package
        this.setName(eNAME);
        this.setNsPrefix(eNS_PREFIX);
        this.setNsURI(eNS_URI);

        // Obtain other dependent packages
        ViewPackage theViewPackage = (ViewPackage) EPackage.Registry.INSTANCE.getEPackage(ViewPackage.eNS_URI);

        // Create type parameters

        // Set bounds for type parameters

        // Add supertypes to classes
        this.tableDescriptionEClass.getESuperTypes().add(theViewPackage.getRepresentationDescription());
        this.columnDescriptionEClass.getESuperTypes().add(this.getTableElementDescription());
        this.rowDescriptionEClass.getESuperTypes().add(this.getTableElementDescription());
        this.cellDescriptionEClass.getESuperTypes().add(this.getTableElementDescription());
        this.cellTextfieldWidgetDescriptionEClass.getESuperTypes().add(this.getCellWidgetDescription());
        this.cellLabelWidgetDescriptionEClass.getESuperTypes().add(this.getCellWidgetDescription());

        // Initialize classes, features, and operations; add parameters
        this.initEClass(this.tableDescriptionEClass, TableDescription.class, "TableDescription", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        this.initEAttribute(this.getTableDescription_UseStripedRowsExpression(), theViewPackage.getInterpretedExpression(), "useStripedRowsExpression", null, 0, 1, TableDescription.class,
                !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        this.initEReference(this.getTableDescription_ColumnDescriptions(), this.getColumnDescription(), null, "columnDescriptions", null, 0, -1, TableDescription.class, !IS_TRANSIENT, !IS_VOLATILE,
                IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        this.getTableDescription_ColumnDescriptions().getEKeys().add(this.getTableElementDescription_Name());
        this.initEReference(this.getTableDescription_RowDescription(), this.getRowDescription(), null, "rowDescription", null, 0, 1, TableDescription.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE,
                IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        this.getTableDescription_RowDescription().getEKeys().add(this.getTableElementDescription_Name());
        this.initEReference(this.getTableDescription_CellDescriptions(), this.getCellDescription(), null, "cellDescriptions", null, 0, -1, TableDescription.class, !IS_TRANSIENT, !IS_VOLATILE,
                IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        this.getTableDescription_CellDescriptions().getEKeys().add(this.getTableElementDescription_Name());

        this.initEClass(this.tableElementDescriptionEClass, TableElementDescription.class, "TableElementDescription", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        this.initEAttribute(this.getTableElementDescription_Name(), theViewPackage.getIdentifier(), "name", null, 0, 1, TableElementDescription.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE,
                !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        this.initEAttribute(this.getTableElementDescription_DomainType(), theViewPackage.getDomainType(), "domainType", "", 0, 1, TableElementDescription.class, !IS_TRANSIENT, !IS_VOLATILE,
                IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        this.initEAttribute(this.getTableElementDescription_SemanticCandidatesExpression(), theViewPackage.getInterpretedExpression(), "semanticCandidatesExpression", null, 0, 1,
                TableElementDescription.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        this.initEAttribute(this.getTableElementDescription_PreconditionExpression(), theViewPackage.getInterpretedExpression(), "preconditionExpression", "", 0, 1, TableElementDescription.class,
                !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        this.initEClass(this.columnDescriptionEClass, ColumnDescription.class, "ColumnDescription", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        this.initEAttribute(this.getColumnDescription_HeaderIndexLabelExpression(), theViewPackage.getInterpretedExpression(), "headerIndexLabelExpression", "", 0, 1, ColumnDescription.class,
                !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        this.initEAttribute(this.getColumnDescription_HeaderLabelExpression(), theViewPackage.getInterpretedExpression(), "headerLabelExpression", "", 0, 1, ColumnDescription.class, !IS_TRANSIENT,
                !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        this.initEAttribute(this.getColumnDescription_HeaderIconExpression(), theViewPackage.getInterpretedExpression(), "headerIconExpression", "", 0, 1, ColumnDescription.class, !IS_TRANSIENT,
                !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        this.initEAttribute(this.getColumnDescription_InitialWidthExpression(), theViewPackage.getInterpretedExpression(), "initialWidthExpression", "", 0, 1, ColumnDescription.class, !IS_TRANSIENT,
                !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        this.initEAttribute(this.getColumnDescription_IsResizableExpression(), theViewPackage.getInterpretedExpression(), "isResizableExpression", "", 0, 1, ColumnDescription.class, !IS_TRANSIENT,
                !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        this.initEAttribute(this.getColumnDescription_FilterWidgetExpression(), theViewPackage.getInterpretedExpression(), "filterWidgetExpression", "", 0, 1, ColumnDescription.class, !IS_TRANSIENT,
                !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        this.initEClass(this.rowDescriptionEClass, RowDescription.class, "RowDescription", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        this.initEAttribute(this.getRowDescription_HeaderLabelExpression(), theViewPackage.getInterpretedExpression(), "headerLabelExpression", "", 0, 1, RowDescription.class, !IS_TRANSIENT,
                !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        this.initEAttribute(this.getRowDescription_HeaderIconExpression(), theViewPackage.getInterpretedExpression(), "headerIconExpression", "", 0, 1, RowDescription.class, !IS_TRANSIENT,
                !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        this.initEAttribute(this.getRowDescription_HeaderIndexLabelExpression(), theViewPackage.getInterpretedExpression(), "headerIndexLabelExpression", null, 0, 1, RowDescription.class,
                !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        this.initEAttribute(this.getRowDescription_InitialHeightExpression(), theViewPackage.getInterpretedExpression(), "initialHeightExpression", "", 0, 1, RowDescription.class, !IS_TRANSIENT,
                !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        this.initEAttribute(this.getRowDescription_IsResizableExpression(), theViewPackage.getInterpretedExpression(), "isResizableExpression", "", 0, 1, RowDescription.class, !IS_TRANSIENT,
                !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        this.initEClass(this.cellDescriptionEClass, CellDescription.class, "CellDescription", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        this.initEAttribute(this.getCellDescription_ValueExpression(), theViewPackage.getInterpretedExpression(), "valueExpression", "", 0, 1, CellDescription.class, !IS_TRANSIENT, !IS_VOLATILE,
                IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        this.initEAttribute(this.getCellDescription_TooltipExpression(), theViewPackage.getInterpretedExpression(), "tooltipExpression", "", 0, 1, CellDescription.class, !IS_TRANSIENT, !IS_VOLATILE,
                IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        this.initEReference(this.getCellDescription_CellWidgetDescription(), this.getCellWidgetDescription(), null, "cellWidgetDescription", null, 0, 1, CellDescription.class, !IS_TRANSIENT,
                !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        this.initEClass(this.cellWidgetDescriptionEClass, CellWidgetDescription.class, "CellWidgetDescription", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

        this.initEClass(this.cellTextfieldWidgetDescriptionEClass, CellTextfieldWidgetDescription.class, "CellTextfieldWidgetDescription", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        this.initEReference(this.getCellTextfieldWidgetDescription_Body(), theViewPackage.getOperation(), null, "body", null, 0, -1, CellTextfieldWidgetDescription.class, !IS_TRANSIENT, !IS_VOLATILE,
                IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        this.initEClass(this.cellLabelWidgetDescriptionEClass, CellLabelWidgetDescription.class, "CellLabelWidgetDescription", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        this.initEAttribute(this.getCellLabelWidgetDescription_IconExpression(), theViewPackage.getInterpretedExpression(), "iconExpression", "", 0, 1, CellLabelWidgetDescription.class, !IS_TRANSIENT,
                !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        // Create resource
        this.createResource(eNS_URI);
    }

} // TablePackageImpl