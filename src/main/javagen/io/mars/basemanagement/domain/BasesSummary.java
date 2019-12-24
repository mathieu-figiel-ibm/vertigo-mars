package io.mars.basemanagement.domain;

import io.vertigo.core.lang.Generated;
import io.vertigo.dynamo.domain.model.DtObject;
import io.vertigo.dynamo.domain.stereotype.Field;
import io.vertigo.dynamo.domain.util.DtObjectUtil;

/**
 * This class is automatically generated.
 * DO NOT EDIT THIS FILE DIRECTLY.
 */
@Generated
public final class BasesSummary implements DtObject {
	private static final long serialVersionUID = 1L;

	private Long baseCount;
	private Integer baseMeanHealth;
	private Long openedTickets;
	private Integer onlineEquipmentPercent;
	
	/**
	 * Champ : DATA.
	 * Récupère la valeur de la propriété 'Bases count'.
	 * @return Long baseCount <b>Obligatoire</b>
	 */
	@Field(domain = "DoCount", required = true, label = "Bases count")
	public Long getBaseCount() {
		return baseCount;
	}

	/**
	 * Champ : DATA.
	 * Définit la valeur de la propriété 'Bases count'.
	 * @param baseCount Long <b>Obligatoire</b>
	 */
	public void setBaseCount(final Long baseCount) {
		this.baseCount = baseCount;
	}
	
	/**
	 * Champ : DATA.
	 * Récupère la valeur de la propriété 'Name'.
	 * @return Integer baseMeanHealth <b>Obligatoire</b>
	 */
	@Field(domain = "DoHealth", required = true, label = "Name")
	public Integer getBaseMeanHealth() {
		return baseMeanHealth;
	}

	/**
	 * Champ : DATA.
	 * Définit la valeur de la propriété 'Name'.
	 * @param baseMeanHealth Integer <b>Obligatoire</b>
	 */
	public void setBaseMeanHealth(final Integer baseMeanHealth) {
		this.baseMeanHealth = baseMeanHealth;
	}
	
	/**
	 * Champ : DATA.
	 * Récupère la valeur de la propriété 'Health Level'.
	 * @return Long openedTickets <b>Obligatoire</b>
	 */
	@Field(domain = "DoCount", required = true, label = "Health Level")
	public Long getOpenedTickets() {
		return openedTickets;
	}

	/**
	 * Champ : DATA.
	 * Définit la valeur de la propriété 'Health Level'.
	 * @param openedTickets Long <b>Obligatoire</b>
	 */
	public void setOpenedTickets(final Long openedTickets) {
		this.openedTickets = openedTickets;
	}
	
	/**
	 * Champ : DATA.
	 * Récupère la valeur de la propriété 'Equipment Health'.
	 * @return Integer onlineEquipmentPercent <b>Obligatoire</b>
	 */
	@Field(domain = "DoHealth", required = true, label = "Equipment Health")
	public Integer getOnlineEquipmentPercent() {
		return onlineEquipmentPercent;
	}

	/**
	 * Champ : DATA.
	 * Définit la valeur de la propriété 'Equipment Health'.
	 * @param onlineEquipmentPercent Integer <b>Obligatoire</b>
	 */
	public void setOnlineEquipmentPercent(final Integer onlineEquipmentPercent) {
		this.onlineEquipmentPercent = onlineEquipmentPercent;
	}
	
	/** {@inheritDoc} */
	@Override
	public String toString() {
		return DtObjectUtil.toString(this);
	}
}