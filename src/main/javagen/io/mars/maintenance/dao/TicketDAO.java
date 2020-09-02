package io.mars.maintenance.dao;

import javax.inject.Inject;

import io.vertigo.core.lang.Generated;
import io.vertigo.core.node.Node;
import io.vertigo.datamodel.task.definitions.TaskDefinition;
import io.vertigo.datamodel.task.model.Task;
import io.vertigo.datamodel.task.model.TaskBuilder;
import io.vertigo.datastore.entitystore.EntityStoreManager;
import io.vertigo.datastore.impl.dao.DAO;
import io.vertigo.datastore.impl.dao.StoreServices;
import io.vertigo.datamodel.smarttype.SmartTypeManager;
import io.vertigo.datamodel.task.TaskManager;
import io.mars.maintenance.domain.Ticket;

/**
 * This class is automatically generated.
 * DO NOT EDIT THIS FILE DIRECTLY.
 */
@Generated
public final class TicketDAO extends DAO<Ticket, java.lang.Long> implements StoreServices {

	/**
	 * Contructeur.
	 * @param entityStoreManager Manager de persistance
	 * @param taskManager Manager de Task
	 * @param smartTypeManager SmartTypeManager
	 */
	@Inject
	public TicketDAO(final EntityStoreManager entityStoreManager, final TaskManager taskManager, final SmartTypeManager smartTypeManager) {
		super(Ticket.class, entityStoreManager, taskManager, smartTypeManager);
	}


	/**
	 * Creates a taskBuilder.
	 * @param name  the name of the task
	 * @return the builder 
	 */
	private static TaskBuilder createTaskBuilder(final String name) {
		final TaskDefinition taskDefinition = Node.getNode().getDefinitionSpace().resolve(name, TaskDefinition.class);
		return Task.builder(taskDefinition);
	}

	/**
	 * Execute la tache TkGetLastTickets.
	 * @return DtList de Ticket tickets
	*/
	@io.vertigo.datamodel.task.proxy.TaskAnnotation(
			name = "TkGetLastTickets",
			request = "select " + 
 "            	tic.*" + 
 "			from ticket tic" + 
 "			order by tic.date_created desc" + 
 "			limit 50",
			taskEngineClass = io.vertigo.basics.task.TaskEngineSelect.class)
	@io.vertigo.datamodel.task.proxy.TaskOutput(smartType = "STyDtTicket")
	public io.vertigo.datamodel.structure.model.DtList<io.mars.maintenance.domain.Ticket> getLastTickets() {
		final Task task = createTaskBuilder("TkGetLastTickets")
				.build();
		return getTaskManager()
				.execute(task)
				.getResult();
	}

	/**
	 * Execute la tache TkGetLastTicketsByBaseId.
	 * @param baseId Long
	 * @return DtList de Ticket tickets
	*/
	@io.vertigo.datamodel.task.proxy.TaskAnnotation(
			name = "TkGetLastTicketsByBaseId",
			request = "select " + 
 "            	tic.*" + 
 "			from ticket tic" + 
 "			join equipment equ on equ.equipment_id = tic.equipment_id" + 
 "			where equ.base_id = #baseId#" + 
 "			order by tic.date_created desc" + 
 "			limit 50",
			taskEngineClass = io.vertigo.basics.task.TaskEngineSelect.class)
	@io.vertigo.datamodel.task.proxy.TaskOutput(smartType = "STyDtTicket")
	public io.vertigo.datamodel.structure.model.DtList<io.mars.maintenance.domain.Ticket> getLastTicketsByBaseId(@io.vertigo.datamodel.task.proxy.TaskInput(name = "baseId", smartType = "STyId") final Long baseId) {
		final Task task = createTaskBuilder("TkGetLastTicketsByBaseId")
				.addValue("baseId", baseId)
				.build();
		return getTaskManager()
				.execute(task)
				.getResult();
	}

}
