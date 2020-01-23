package io.mars.maintenance.domain;

import io.vertigo.core.lang.Generated;
import io.vertigo.dynamo.domain.model.Entity;
import io.vertigo.datastore.impl.entitystore.EnumStoreVAccessor;
import io.vertigo.dynamo.domain.model.UID;
import io.vertigo.datastore.impl.entitystore.StoreVAccessor;
import io.vertigo.dynamo.domain.stereotype.Field;
import io.vertigo.dynamo.domain.util.DtObjectUtil;

/**
 * This class is automatically generated.
 * DO NOT EDIT THIS FILE DIRECTLY.
 */
@Generated
@io.vertigo.dynamo.ngdomain.annotations.Mapper(clazz = io.vertigo.dynamo.domain.util.JsonMapper.class, dataType = io.vertigo.dynamo.domain.metamodel.DataType.String)
public final class Ticket implements Entity {
	private static final long serialVersionUID = 1L;

	private Long ticketId;
	private String code;
	private String title;
	private String description;
	private java.time.LocalDate dateCreated;
	private java.time.LocalDate dateClosed;

	@io.vertigo.dynamo.domain.stereotype.Association(
			name = "ATicketTicketStatus",
			fkFieldName = "ticketStatusId",
			primaryDtDefinitionName = "DtTicketStatus",
			primaryIsNavigable = true,
			primaryRole = "TicketStatus",
			primaryLabel = "Ticket Status",
			primaryMultiplicity = "0..1",
			foreignDtDefinitionName = "DtTicket",
			foreignIsNavigable = false,
			foreignRole = "Ticket",
			foreignLabel = "Ticket",
			foreignMultiplicity = "0..*")
	private final EnumStoreVAccessor<io.mars.maintenance.domain.TicketStatus, io.mars.maintenance.domain.TicketStatusEnum> ticketStatusIdAccessor = new EnumStoreVAccessor<>(io.mars.maintenance.domain.TicketStatus.class, "TicketStatus", io.mars.maintenance.domain.TicketStatusEnum.class);

	@io.vertigo.dynamo.domain.stereotype.Association(
			name = "AEquipmentTicket",
			fkFieldName = "equipmentId",
			primaryDtDefinitionName = "DtEquipment",
			primaryIsNavigable = true,
			primaryRole = "Equipment",
			primaryLabel = "Equipment",
			primaryMultiplicity = "0..1",
			foreignDtDefinitionName = "DtTicket",
			foreignIsNavigable = false,
			foreignRole = "Ticket",
			foreignLabel = "Ticket",
			foreignMultiplicity = "0..*")
	private final StoreVAccessor<io.mars.basemanagement.domain.Equipment> equipmentIdAccessor = new StoreVAccessor<>(io.mars.basemanagement.domain.Equipment.class, "Equipment");

	/** {@inheritDoc} */
	@Override
	public UID<Ticket> getUID() {
		return UID.of(this);
	}
	
	/**
	 * Champ : ID.
	 * Récupère la valeur de la propriété 'Id'.
	 * @return Long ticketId <b>Obligatoire</b>
	 */
	@Field(domain = "STyId", type = "ID", cardinality = io.vertigo.core.lang.Cardinality.ONE, label = "Id")
	public Long getTicketId() {
		return ticketId;
	}

	/**
	 * Champ : ID.
	 * Définit la valeur de la propriété 'Id'.
	 * @param ticketId Long <b>Obligatoire</b>
	 */
	public void setTicketId(final Long ticketId) {
		this.ticketId = ticketId;
	}
	
	/**
	 * Champ : DATA.
	 * Récupère la valeur de la propriété 'Number'.
	 * @return String code
	 */
	@Field(domain = "STyLabel", label = "Number")
	public String getCode() {
		return code;
	}

	/**
	 * Champ : DATA.
	 * Définit la valeur de la propriété 'Number'.
	 * @param code String
	 */
	public void setCode(final String code) {
		this.code = code;
	}
	
	/**
	 * Champ : DATA.
	 * Récupère la valeur de la propriété 'Title'.
	 * @return String title
	 */
	@Field(domain = "STyLabel", label = "Title")
	public String getTitle() {
		return title;
	}

	/**
	 * Champ : DATA.
	 * Définit la valeur de la propriété 'Title'.
	 * @param title String
	 */
	public void setTitle(final String title) {
		this.title = title;
	}
	
	/**
	 * Champ : DATA.
	 * Récupère la valeur de la propriété 'Description'.
	 * @return String description
	 */
	@Field(domain = "STyDescription", label = "Description")
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
	 * Récupère la valeur de la propriété 'Creation Date'.
	 * @return LocalDate dateCreated
	 */
	@Field(domain = "STyLocaldate", label = "Creation Date")
	public java.time.LocalDate getDateCreated() {
		return dateCreated;
	}

	/**
	 * Champ : DATA.
	 * Définit la valeur de la propriété 'Creation Date'.
	 * @param dateCreated LocalDate
	 */
	public void setDateCreated(final java.time.LocalDate dateCreated) {
		this.dateCreated = dateCreated;
	}
	
	/**
	 * Champ : DATA.
	 * Récupère la valeur de la propriété 'Closing Date'.
	 * @return LocalDate dateClosed
	 */
	@Field(domain = "STyLocaldate", label = "Closing Date")
	public java.time.LocalDate getDateClosed() {
		return dateClosed;
	}

	/**
	 * Champ : DATA.
	 * Définit la valeur de la propriété 'Closing Date'.
	 * @param dateClosed LocalDate
	 */
	public void setDateClosed(final java.time.LocalDate dateClosed) {
		this.dateClosed = dateClosed;
	}
	
	/**
	 * Champ : FOREIGN_KEY.
	 * Récupère la valeur de la propriété 'Ticket Status'.
	 * @return String ticketStatusId
	 */
	@io.vertigo.dynamo.domain.stereotype.ForeignKey(domain = "STyCode", label = "Ticket Status", fkDefinition = "DtTicketStatus" )
	public String getTicketStatusId() {
		return (String) ticketStatusIdAccessor.getId();
	}

	/**
	 * Champ : FOREIGN_KEY.
	 * Définit la valeur de la propriété 'Ticket Status'.
	 * @param ticketStatusId String
	 */
	public void setTicketStatusId(final String ticketStatusId) {
		ticketStatusIdAccessor.setId(ticketStatusId);
	}
	
	/**
	 * Champ : FOREIGN_KEY.
	 * Récupère la valeur de la propriété 'Equipment'.
	 * @return Long equipmentId
	 */
	@io.vertigo.dynamo.domain.stereotype.ForeignKey(domain = "STyId", label = "Equipment", fkDefinition = "DtEquipment" )
	public Long getEquipmentId() {
		return (Long) equipmentIdAccessor.getId();
	}

	/**
	 * Champ : FOREIGN_KEY.
	 * Définit la valeur de la propriété 'Equipment'.
	 * @param equipmentId Long
	 */
	public void setEquipmentId(final Long equipmentId) {
		equipmentIdAccessor.setId(equipmentId);
	}

 	/**
	 * Association : Equipment.
	 * @return l'accesseur vers la propriété 'Equipment'
	 */
	public StoreVAccessor<io.mars.basemanagement.domain.Equipment> equipment() {
		return equipmentIdAccessor;
	}

 	/**
	 * Association : Ticket Status.
	 * @return l'accesseur vers la propriété 'Ticket Status'
	 */
	public EnumStoreVAccessor<io.mars.maintenance.domain.TicketStatus, io.mars.maintenance.domain.TicketStatusEnum> ticketStatus() {
		return ticketStatusIdAccessor;
	}
	
	/** {@inheritDoc} */
	@Override
	public String toString() {
		return DtObjectUtil.toString(this);
	}
}
