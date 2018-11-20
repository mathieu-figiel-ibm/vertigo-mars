package io.mars.maintenance.domain;

import io.vertigo.dynamo.domain.model.Entity;
import io.vertigo.dynamo.domain.model.EnumVAccessor;
import io.vertigo.dynamo.domain.model.UID;
import io.vertigo.dynamo.domain.model.VAccessor;
import io.vertigo.dynamo.domain.stereotype.Field;
import io.vertigo.dynamo.domain.util.DtObjectUtil;
import io.vertigo.lang.Generated;

/**
 * This class is automatically generated.
 * DO NOT EDIT THIS FILE DIRECTLY.
 */
@Generated
public final class WorkOrder implements Entity {
	private static final long serialVersionUID = 1L;

	private Long moId;
	private String ticketCode;
	private String name;
	private String description;
	private java.time.LocalDate dueDate;

	@io.vertigo.dynamo.domain.stereotype.Association(
			name = "A_TICKET_WORK_ORDER",
			fkFieldName = "TICKET_ID",
			primaryDtDefinitionName = "DT_TICKET",
			primaryIsNavigable = true,
			primaryRole = "Ticket",
			primaryLabel = "Ticket",
			primaryMultiplicity = "0..1",
			foreignDtDefinitionName = "DT_WORK_ORDER",
			foreignIsNavigable = false,
			foreignRole = "TicketWorkOrders",
			foreignLabel = "Ticket Work Orders",
			foreignMultiplicity = "0..*")
	private final VAccessor<io.mars.maintenance.domain.Ticket> ticketIdAccessor = new VAccessor<>(io.mars.maintenance.domain.Ticket.class, "Ticket");

	@io.vertigo.dynamo.domain.stereotype.Association(
			name = "A_WORK_ORDER_WORK_ORDER_STATUS",
			fkFieldName = "WORK_ORDER_STATUS_ID",
			primaryDtDefinitionName = "DT_WORK_ORDER_STATUS",
			primaryIsNavigable = true,
			primaryRole = "WorkOrderStatus",
			primaryLabel = "Work Order Status",
			primaryMultiplicity = "0..1",
			foreignDtDefinitionName = "DT_WORK_ORDER",
			foreignIsNavigable = false,
			foreignRole = "WorkOrder",
			foreignLabel = "Work Order",
			foreignMultiplicity = "0..*")
	private final EnumVAccessor<io.mars.maintenance.domain.WorkOrderStatus, io.mars.maintenance.domain.WorkOrderStatusEnum> workOrderStatusIdAccessor = new EnumVAccessor<>(io.mars.maintenance.domain.WorkOrderStatus.class, "WorkOrderStatus", io.mars.maintenance.domain.WorkOrderStatusEnum.class);

	/** {@inheritDoc} */
	@Override
	public UID<WorkOrder> getUID() {
		return UID.of(this);
	}

	/**
	 * Champ : ID.
	 * Récupère la valeur de la propriété 'Id'.
	 * @return Long moId <b>Obligatoire</b>
	 */
	@Field(domain = "DO_ID", type = "ID", required = true, label = "Id")
	public Long getMoId() {
		return moId;
	}

	/**
	 * Champ : ID.
	 * Définit la valeur de la propriété 'Id'.
	 * @param moId Long <b>Obligatoire</b>
	 */
	public void setMoId(final Long moId) {
		this.moId = moId;
	}

	/**
	 * Champ : DATA.
	 * Récupère la valeur de la propriété 'Ticket Number'.
	 * @return String ticketCode
	 */
	@Field(domain = "DO_LABEL", label = "Ticket Number")
	public String getTicketCode() {
		return ticketCode;
	}

	/**
	 * Champ : DATA.
	 * Définit la valeur de la propriété 'Ticket Number'.
	 * @param ticketCode String
	 */
	public void setTicketCode(final String ticketCode) {
		this.ticketCode = ticketCode;
	}

	/**
	 * Champ : DATA.
	 * Récupère la valeur de la propriété 'Mainenance Operation'.
	 * @return String name
	 */
	@Field(domain = "DO_LABEL", label = "Mainenance Operation")
	public String getName() {
		return name;
	}

	/**
	 * Champ : DATA.
	 * Définit la valeur de la propriété 'Mainenance Operation'.
	 * @param name String
	 */
	public void setName(final String name) {
		this.name = name;
	}

	/**
	 * Champ : DATA.
	 * Récupère la valeur de la propriété 'Maintenance Operation Descrption'.
	 * @return String description
	 */
	@Field(domain = "DO_DESCRIPTION", label = "Maintenance Operation Descrption")
	public String getDescription() {
		return description;
	}

	/**
	 * Champ : DATA.
	 * Définit la valeur de la propriété 'Maintenance Operation Descrption'.
	 * @param description String
	 */
	public void setDescription(final String description) {
		this.description = description;
	}

	/**
	 * Champ : DATA.
	 * Récupère la valeur de la propriété 'Due Date'.
	 * @return LocalDate dueDate
	 */
	@Field(domain = "DO_LOCALDATE", label = "Due Date")
	public java.time.LocalDate getDueDate() {
		return dueDate;
	}

	/**
	 * Champ : DATA.
	 * Définit la valeur de la propriété 'Due Date'.
	 * @param dueDate LocalDate
	 */
	public void setDueDate(final java.time.LocalDate dueDate) {
		this.dueDate = dueDate;
	}

	/**
	 * Champ : FOREIGN_KEY.
	 * Récupère la valeur de la propriété 'Ticket'.
	 * @return Long ticketId
	 */
	@Field(domain = "DO_ID", type = "FOREIGN_KEY", label = "Ticket")
	public Long getTicketId() {
		return (Long) ticketIdAccessor.getId();
	}

	/**
	 * Champ : FOREIGN_KEY.
	 * Définit la valeur de la propriété 'Ticket'.
	 * @param ticketId Long
	 */
	public void setTicketId(final Long ticketId) {
		ticketIdAccessor.setId(ticketId);
	}

	/**
	 * Champ : FOREIGN_KEY.
	 * Récupère la valeur de la propriété 'Work Order Status'.
	 * @return String workOrderStatusId
	 */
	@Field(domain = "DO_CODE", type = "FOREIGN_KEY", label = "Work Order Status")
	public String getWorkOrderStatusId() {
		return (String) workOrderStatusIdAccessor.getId();
	}

	/**
	 * Champ : FOREIGN_KEY.
	 * Définit la valeur de la propriété 'Work Order Status'.
	 * @param workOrderStatusId String
	 */
	public void setWorkOrderStatusId(final String workOrderStatusId) {
		workOrderStatusIdAccessor.setId(workOrderStatusId);
	}

	/**
	 * Association : Ticket.
	 * @return l'accesseur vers la propriété 'Ticket'
	 */
	public VAccessor<io.mars.maintenance.domain.Ticket> ticket() {
		return ticketIdAccessor;
	}

	@Deprecated
	public io.mars.maintenance.domain.Ticket getTicket() {
		// we keep the lazyness
		if (!ticketIdAccessor.isLoaded()) {
			ticketIdAccessor.load();
		}
		return ticketIdAccessor.get();
	}

	/**
	 * Retourne l'URI: Ticket.
	 * @return URI de l'association
	 */
	@Deprecated
	public io.vertigo.dynamo.domain.model.UID<io.mars.maintenance.domain.Ticket> getTicketURI() {
		return ticketIdAccessor.getURI();
	}

	/**
	 * Association : Work Order Status.
	 * @return l'accesseur vers la propriété 'Work Order Status'
	 */
	public EnumVAccessor<io.mars.maintenance.domain.WorkOrderStatus, io.mars.maintenance.domain.WorkOrderStatusEnum> workOrderStatus() {
		return workOrderStatusIdAccessor;
	}

	@Deprecated
	public io.mars.maintenance.domain.WorkOrderStatus getWorkOrderStatus() {
		// we keep the lazyness
		if (!workOrderStatusIdAccessor.isLoaded()) {
			workOrderStatusIdAccessor.load();
		}
		return workOrderStatusIdAccessor.get();
	}

	/**
	 * Retourne l'URI: Work Order Status.
	 * @return URI de l'association
	 */
	@Deprecated
	public io.vertigo.dynamo.domain.model.UID<io.mars.maintenance.domain.WorkOrderStatus> getWorkOrderStatusURI() {
		return workOrderStatusIdAccessor.getURI();
	}

	/** {@inheritDoc} */
	@Override
	public String toString() {
		return DtObjectUtil.toString(this);
	}
}
