package io.mars.basemanagement.search;

import io.vertigo.core.lang.Generated;
import io.vertigo.datamodel.structure.model.DtObject;
import io.vertigo.datamodel.structure.stereotype.Field;
import io.vertigo.datamodel.structure.util.DtObjectUtil;

/**
 * This class is automatically generated.
 * DO NOT EDIT THIS FILE DIRECTLY.
 */
@Generated
public final class EquipmentIndex implements DtObject {
	private static final long serialVersionUID = 1L;

	private Long equipmentId;
	private String name;
	private String code;
	private java.time.LocalDate purchaseDate;
	private String description;
	private String tags;
	private String equipmentTypeName;
	private String equipmentCategoryName;
	
	/**
	 * Champ : DATA.
	 * Récupère la valeur de la propriété 'Id'.
	 * @return Long equipmentId <b>Obligatoire</b>
	 */
	@Field(smartType = "STyId", cardinality = io.vertigo.core.lang.Cardinality.ONE, label = "Id")
	public Long getEquipmentId() {
		return equipmentId;
	}

	/**
	 * Champ : DATA.
	 * Définit la valeur de la propriété 'Id'.
	 * @param equipmentId Long <b>Obligatoire</b>
	 */
	public void setEquipmentId(final Long equipmentId) {
		this.equipmentId = equipmentId;
	}
	
	/**
	 * Champ : DATA.
	 * Récupère la valeur de la propriété 'Name'.
	 * @return String name
	 */
	@Field(smartType = "STyLabel", label = "Name")
	public String getName() {
		return name;
	}

	/**
	 * Champ : DATA.
	 * Définit la valeur de la propriété 'Name'.
	 * @param name String
	 */
	public void setName(final String name) {
		this.name = name;
	}
	
	/**
	 * Champ : DATA.
	 * Récupère la valeur de la propriété 'Code'.
	 * @return String code
	 */
	@Field(smartType = "STyCode", label = "Code")
	public String getCode() {
		return code;
	}

	/**
	 * Champ : DATA.
	 * Définit la valeur de la propriété 'Code'.
	 * @param code String
	 */
	public void setCode(final String code) {
		this.code = code;
	}
	
	/**
	 * Champ : DATA.
	 * Récupère la valeur de la propriété 'Date of purchase'.
	 * @return LocalDate purchaseDate
	 */
	@Field(smartType = "STyLocaldate", label = "Date of purchase")
	public java.time.LocalDate getPurchaseDate() {
		return purchaseDate;
	}

	/**
	 * Champ : DATA.
	 * Définit la valeur de la propriété 'Date of purchase'.
	 * @param purchaseDate LocalDate
	 */
	public void setPurchaseDate(final java.time.LocalDate purchaseDate) {
		this.purchaseDate = purchaseDate;
	}
	
	/**
	 * Champ : DATA.
	 * Récupère la valeur de la propriété 'Description'.
	 * @return String description
	 */
	@Field(smartType = "STyDescription", label = "Description")
	public String getDescription() {
		return description;
	}

	/**
	 * Champ : DATA.
	 * Définit la valeur de la propriété 'Description'.
	 * @param description String
	 */
	public void setDescription(final String description) {
		this.description = description;
	}
	
	/**
	 * Champ : DATA.
	 * Récupère la valeur de la propriété 'Tags'.
	 * @return String tags
	 */
	@Field(smartType = "STyTags", label = "Tags")
	public String getTags() {
		return tags;
	}

	/**
	 * Champ : DATA.
	 * Définit la valeur de la propriété 'Tags'.
	 * @param tags String
	 */
	public void setTags(final String tags) {
		this.tags = tags;
	}
	
	/**
	 * Champ : DATA.
	 * Récupère la valeur de la propriété 'Type'.
	 * @return String equipmentTypeName
	 */
	@Field(smartType = "STyLabel", label = "Type")
	public String getEquipmentTypeName() {
		return equipmentTypeName;
	}

	/**
	 * Champ : DATA.
	 * Définit la valeur de la propriété 'Type'.
	 * @param equipmentTypeName String
	 */
	public void setEquipmentTypeName(final String equipmentTypeName) {
		this.equipmentTypeName = equipmentTypeName;
	}
	
	/**
	 * Champ : DATA.
	 * Récupère la valeur de la propriété 'Category'.
	 * @return String equipmentCategoryName
	 */
	@Field(smartType = "STyLabel", label = "Category")
	public String getEquipmentCategoryName() {
		return equipmentCategoryName;
	}

	/**
	 * Champ : DATA.
	 * Définit la valeur de la propriété 'Category'.
	 * @param equipmentCategoryName String
	 */
	public void setEquipmentCategoryName(final String equipmentCategoryName) {
		this.equipmentCategoryName = equipmentCategoryName;
	}
	
	/**
	 * Champ : COMPUTED.
	 * Récupère la valeur de la propriété calculée 'ALL_TEXT'.
	 * @return String allText
	 */
	@Field(smartType = "STyDescription", type = "COMPUTED", persistent = false, label = "ALL_TEXT")
	public String getAllText() {
		throw new io.vertigo.core.lang.VSystemException("Can't use index copyTo field");
	}
	
	/** {@inheritDoc} */
	@Override
	public String toString() {
		return DtObjectUtil.toString(this);
	}
}
