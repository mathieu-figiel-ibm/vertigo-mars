package io.mars.basemanagement.dao;

import javax.inject.Inject;

import java.util.Arrays;
import io.vertigo.app.Home;
import io.vertigo.core.component.di.injector.DIInjector;
import io.vertigo.dynamo.search.SearchManager;
import io.vertigo.dynamo.search.metamodel.SearchIndexDefinition;
import io.vertigo.dynamo.search.model.SearchQuery;
import io.vertigo.dynamo.search.model.SearchQueryBuilder;
import io.vertigo.dynamo.domain.model.DtListState;
import io.vertigo.dynamo.collections.ListFilter;
import io.vertigo.dynamo.collections.metamodel.FacetedQueryDefinition;
import io.vertigo.dynamo.collections.metamodel.ListFilterBuilder;
import io.vertigo.dynamo.collections.model.FacetedQueryResult;
import io.vertigo.dynamo.collections.model.SelectedFacetValues;
import io.vertigo.commons.transaction.VTransactionManager;
import io.mars.basemanagement.search.EquipmentIndex;
import io.vertigo.dynamo.task.metamodel.TaskDefinition;
import io.vertigo.dynamo.task.model.Task;
import io.vertigo.dynamo.task.model.TaskBuilder;
import io.vertigo.dynamo.domain.model.UID;
import io.vertigo.dynamo.impl.store.util.DAO;
import io.vertigo.dynamo.store.StoreManager;
import io.vertigo.dynamo.store.StoreServices;
import io.vertigo.dynamo.task.TaskManager;
import io.mars.basemanagement.domain.Equipment;
import io.vertigo.lang.Generated;

/**
 * This class is automatically generated.
 * DO NOT EDIT THIS FILE DIRECTLY.
 */
@Generated
public final class EquipmentDAO extends DAO<Equipment, java.lang.Long> implements StoreServices {
	private final SearchManager searchManager;
	private final VTransactionManager transactionManager;

	/**
	 * Contructeur.
	 * @param storeManager Manager de persistance
	 * @param taskManager Manager de Task
	 * @param searchManager Search Manager
	 * @param transactionManager Transaction Manager
	 */
	@Inject
	public EquipmentDAO(final StoreManager storeManager, final TaskManager taskManager, final SearchManager searchManager, final VTransactionManager transactionManager) {
		super(Equipment.class, storeManager, taskManager);
		this.searchManager = searchManager;
		this.transactionManager = transactionManager;
	}

	/**
	 * Indique que le keyConcept associé à cette UID va être modifié.
	 * Techniquement cela interdit les opérations d'ecriture en concurrence 
	 * et envoie un évenement de modification du keyConcept (à la fin de transaction eventuellement) 
	 * @param UID UID du keyConcept modifié
	 * @return KeyConcept à modifier
	 */
	 public Equipment readOneForUpdate(final UID<Equipment> uid) {
		return dataStore.readOneForUpdate(uid);
	}

	/**
	 * Indique que le keyConcept associé à cet id va être modifié.
	 * Techniquement cela interdit les opérations d'ecriture en concurrence 
	 * et envoie un évenement de modification du keyConcept (à la fin de transaction eventuellement) 
	 * @param id Clé du keyConcept modifié
	 * @return KeyConcept à modifier
	 */
	 public Equipment readOneForUpdate(final java.lang.Long id) {
		return readOneForUpdate(createDtObjectUID(id));
	}

	/**
	 * Création d'une SearchQuery de type : Equipment.
	 * @param criteria Critères de recherche
	 * @param selectedFacetValues Liste des facettes sélectionnées à appliquer
	 * @return SearchQueryBuilder pour ce type de recherche
	 */
	public SearchQueryBuilder createSearchQueryBuilderEquipment(final String criteria, final SelectedFacetValues selectedFacetValues) {
		final FacetedQueryDefinition facetedQueryDefinition = Home.getApp().getDefinitionSpace().resolve("QRY_EQUIPMENT", FacetedQueryDefinition.class);
		final ListFilterBuilder<String> listFilterBuilder = DIInjector.newInstance(facetedQueryDefinition.getListFilterBuilderClass(), Home.getApp().getComponentSpace());
		final ListFilter criteriaListFilter = listFilterBuilder.withBuildQuery(facetedQueryDefinition.getListFilterBuilderQuery()).withCriteria(criteria).build();
		return SearchQuery.builder(criteriaListFilter).withFacetStrategy(facetedQueryDefinition, selectedFacetValues);
	}

	/**
	 * Récupération du résultat issu d'une requête.
	 * @param searchQuery critères initiaux
	 * @param listState Etat de la liste (tri et pagination)
	 * @return Résultat correspondant à la requête (de type EquipmentIndex) 
	 */
	public FacetedQueryResult<EquipmentIndex, SearchQuery> loadList(final SearchQuery searchQuery, final DtListState listState) {
		final SearchIndexDefinition indexDefinition = searchManager.findFirstIndexDefinitionByKeyConcept(Equipment.class);
		return searchManager.loadList(indexDefinition, searchQuery, listState);
	}
	
/**
	 * Mark an entity as dirty. Index of these elements will be reindexed if Tx commited.
	 * Reindexation isn't synchrone, strategy is dependant of plugin's parameters.
	 *
	 * @param entityUID Key concept's UID
	 */
	public void markAsDirty(final UID<Equipment> entityUID) {
		transactionManager.getCurrentTransaction().addAfterCompletion((final boolean txCommitted) -> {
			if (txCommitted) {// reindex only is tx successful
				searchManager.markAsDirty(Arrays.asList(entityUID));
			}
		});
	}
	
	/**
	 * Mark an entity as dirty. Index of these elements will be reindexed if Tx commited.
	 * Reindexation isn't synchrone, strategy is dependant of plugin's parameters.
	 * 
	 * @param entity Key concept
	 */
	public void markAsDirty(final Equipment entity) {
		markAsDirty(UID.of(entity));
	}

	/**
	 * Creates a taskBuilder.
	 * @param name  the name of the task
	 * @return the builder 
	 */
	private static TaskBuilder createTaskBuilder(final String name) {
		final TaskDefinition taskDefinition = Home.getApp().getDefinitionSpace().resolve(name, TaskDefinition.class);
		return Task.builder(taskDefinition);
	}

	/**
	 * Execute la tache TK_GET_LAST_PURCHASED_EQUIPMENTS_BY_BASE_ID.
	 * @param baseId Long 
	 * @return io.vertigo.dynamo.domain.model.DtList<io.mars.basemanagement.domain.Equipment> equipments
	*/
	public io.vertigo.dynamo.domain.model.DtList<io.mars.basemanagement.domain.Equipment> getLastPurchasedEquipmentsByBaseId(final Long baseId) {
		final Task task = createTaskBuilder("TK_GET_LAST_PURCHASED_EQUIPMENTS_BY_BASE_ID")
				.addValue("BASE_ID", baseId)
				.build();
		return getTaskManager()
				.execute(task)
				.getResult();
	}

	/**
	 * Execute la tache TK_INSERT_EQUIPMENTS_BATCH.
	 * @param equipmentsList io.vertigo.dynamo.domain.model.DtList<io.mars.basemanagement.domain.Equipment> 
	*/
	public void insertEquipmentsBatch(final io.vertigo.dynamo.domain.model.DtList<io.mars.basemanagement.domain.Equipment> equipmentsList) {
		final Task task = createTaskBuilder("TK_INSERT_EQUIPMENTS_BATCH")
				.addValue("EQUIPMENTS_LIST", equipmentsList)
				.build();
		getTaskManager().execute(task);
	}

	/**
	 * Execute la tache TK_LOAD_EQUIPMENTS_BY_CHUNK.
	 * @param limit Long 
	 * @param offset Long 
	 * @param dateExist java.time.Instant 
	 * @return io.vertigo.dynamo.domain.model.DtList<io.mars.basemanagement.domain.Equipment> equipmentList
	*/
	public io.vertigo.dynamo.domain.model.DtList<io.mars.basemanagement.domain.Equipment> loadEquipmentsByChunk(final Long limit, final Long offset, final java.time.Instant dateExist) {
		final Task task = createTaskBuilder("TK_LOAD_EQUIPMENTS_BY_CHUNK")
				.addValue("LIMIT", limit)
				.addValue("OFFSET", offset)
				.addValue("DATE_EXIST", dateExist)
				.build();
		return getTaskManager()
				.execute(task)
				.getResult();
	}

}
