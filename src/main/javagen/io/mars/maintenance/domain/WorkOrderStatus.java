package io.mars.maintenance.domain;

import io.vertigo.core.lang.Generated;
import io.vertigo.datamodel.structure.model.DtStaticMasterData;
import io.vertigo.datamodel.structure.model.UID;
import io.vertigo.datamodel.structure.stereotype.Field;
import io.vertigo.datamodel.structure.util.DtObjectUtil;

/**
 * This class is automatically generated.
 * DO NOT EDIT THIS FILE DIRECTLY.
 */
@Generated
@io.vertigo.datamodel.smarttype.annotations.Mapper(clazz = io.vertigo.datamodel.structure.util.JsonMapper.class, dataType = io.vertigo.core.lang.DataType.String)
public final class WorkOrderStatus implements DtStaticMasterData {
	private static final long serialVersionUID = 1L;

	private String workOrderStatusId;
	private String label;

	/** {@inheritDoc} */
	@Override
	public UID<WorkOrderStatus> getUID() {
		return UID.of(this);
	}
	
	/**
	 * Champ : ID.
	 * Récupère la valeur de la propriété 'Id'.
	 * @return String workOrderStatusId <b>Obligatoire</b>
	 */
	@Field(smartType = "STyCode", type = "ID", cardinality = io.vertigo.core.lang.Cardinality.ONE, label = "Id")
	public String getWorkOrderStatusId() {
		return workOrderStatusId;
	}

	/**
	 * Champ : ID.
	 * Définit la valeur de la propriété 'Id'.
	 * @param workOrderStatusId String <b>Obligatoire</b>
	 */
	public void setWorkOrderStatusId(final String workOrderStatusId) {
		this.workOrderStatusId = workOrderStatusId;
	}
	
	/**
	 * Champ : DATA.
	 * Récupère la valeur de la propriété 'Status Label'.
	 * @return String label
	 */
	@Field(smartType = "STyLabel", label = "Status Label")
	@io.vertigo.datamodel.structure.stereotype.SortField
	@io.vertigo.datamodel.structure.stereotype.DisplayField
	public String getLabel() {
		return label;
	}

	/**
	 * Champ : DATA.
	 * Définit la valeur de la propriété 'Status Label'.
	 * @param label String
	 */
	public void setLabel(final String label) {
		this.label = label;
	}
	
	/** {@inheritDoc} */
	@Override
	public String toString() {
		return DtObjectUtil.toString(this);
	}
}
