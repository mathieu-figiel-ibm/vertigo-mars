package io.mars.catalog.domain;

import io.vertigo.core.lang.Generated;
import io.vertigo.datamodel.structure.model.Entity;
import io.vertigo.datamodel.structure.model.UID;
import io.vertigo.datamodel.structure.stereotype.Field;
import io.vertigo.datamodel.structure.util.DtObjectUtil;

/**
 * This class is automatically generated.
 * DO NOT EDIT THIS FILE DIRECTLY.
 */
@Generated
public final class EquipmentCategory implements Entity {
	private static final long serialVersionUID = 1L;

	private Long equipmentCategoryId;
	private String label;
	private Boolean active;

	/** {@inheritDoc} */
	@Override
	public UID<EquipmentCategory> getUID() {
		return UID.of(this);
	}
	
	/**
	 * Champ : ID.
	 * Récupère la valeur de la propriété 'Id'.
	 * @return Long equipmentCategoryId <b>Obligatoire</b>
	 */
	@Field(smartType = "STyId", type = "ID", cardinality = io.vertigo.core.lang.Cardinality.ONE, label = "Id")
	public Long getEquipmentCategoryId() {
		return equipmentCategoryId;
	}

	/**
	 * Champ : ID.
	 * Définit la valeur de la propriété 'Id'.
	 * @param equipmentCategoryId Long <b>Obligatoire</b>
	 */
	public void setEquipmentCategoryId(final Long equipmentCategoryId) {
		this.equipmentCategoryId = equipmentCategoryId;
	}
	
	/**
	 * Champ : DATA.
	 * Récupère la valeur de la propriété 'Equipment Category Label'.
	 * @return String label
	 */
	@Field(smartType = "STyLabel", label = "Equipment Category Label")
	public String getLabel() {
		return label;
	}

	/**
	 * Champ : DATA.
	 * Définit la valeur de la propriété 'Equipment Category Label'.
	 * @param label String
	 */
	public void setLabel(final String label) {
		this.label = label;
	}
	
	/**
	 * Champ : DATA.
	 * Récupère la valeur de la propriété 'Equipment category is active'.
	 * @return Boolean active
	 */
	@Field(smartType = "STyYesNo", label = "Equipment category is active")
	public Boolean getActive() {
		return active;
	}

	/**
	 * Champ : DATA.
	 * Définit la valeur de la propriété 'Equipment category is active'.
	 * @param active Boolean
	 */
	public void setActive(final Boolean active) {
		this.active = active;
	}
	
	/** {@inheritDoc} */
	@Override
	public String toString() {
		return DtObjectUtil.toString(this);
	}
}
