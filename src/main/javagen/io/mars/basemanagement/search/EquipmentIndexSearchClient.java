package io.mars.basemanagement.search;

import java.util.Arrays;
import java.util.List;

import javax.inject.Inject;

import io.vertigo.commons.transaction.VTransactionManager;
import io.vertigo.core.lang.Generated;
import io.vertigo.core.node.component.Component;
import io.vertigo.core.node.definition.DefinitionProvider;
import io.vertigo.core.node.definition.DefinitionSpace;
import io.vertigo.core.node.definition.DefinitionSupplier;
import io.vertigo.core.util.ListBuilder;
import io.vertigo.datafactory.collections.definitions.FacetDefinition.FacetOrder;
import io.vertigo.datafactory.collections.definitions.FacetRangeDefinitionSupplier;
import io.vertigo.datafactory.collections.definitions.FacetTermDefinitionSupplier;
import io.vertigo.datafactory.collections.definitions.FacetCustomDefinitionSupplier;
import io.vertigo.datafactory.collections.definitions.FacetedQueryDefinitionSupplier;
import io.vertigo.datafactory.collections.model.FacetedQueryResult;
import io.vertigo.datafactory.collections.model.SelectedFacetValues;
import io.vertigo.datafactory.search.SearchManager;
import io.vertigo.datafactory.search.definitions.SearchIndexDefinition;
import io.vertigo.datafactory.search.definitions.SearchIndexDefinitionSupplier;
import io.vertigo.datafactory.search.model.SearchQuery;
import io.vertigo.datafactory.search.model.SearchQueryBuilder;
import io.vertigo.datamodel.structure.model.DtListState;
import io.vertigo.datamodel.structure.model.UID;
import io.mars.basemanagement.domain.EquipmentIndex;

/**
 * This class is automatically generated.
 * DO NOT EDIT THIS FILE DIRECTLY.
 */
@Generated
public final class EquipmentIndexSearchClient implements Component, DefinitionProvider {

	private final SearchManager searchManager;
	private final VTransactionManager transactionManager;

	/**
	 * Contructeur.
	 * @param searchManager Search Manager
	 * @param transactionManager Transaction Manager
	 */
	@Inject
	public EquipmentIndexSearchClient(final SearchManager searchManager, final VTransactionManager transactionManager) {
		this.searchManager = searchManager;
		this.transactionManager = transactionManager;
	}

	/**
	 * Création d'une SearchQuery de type : Equipment.
	 * @param criteria Critères de recherche
	 * @param selectedFacetValues Liste des facettes sélectionnées à appliquer
	 * @return SearchQueryBuilder pour ce type de recherche
	 */
	public SearchQueryBuilder createSearchQueryBuilderEquipment(final String criteria, final SelectedFacetValues selectedFacetValues) {
		return SearchQuery.builder("QryEquipment")
				.withCriteria(criteria)
				.withFacet(selectedFacetValues);
	}
	/**
	 * Création d'une SearchQuery de type : EquipmentGeo.
	 * @param criteria Critères de recherche
	 * @param selectedFacetValues Liste des facettes sélectionnées à appliquer
	 * @return SearchQueryBuilder pour ce type de recherche
	 */
	public SearchQueryBuilder createSearchQueryBuilderEquipmentGeo(final io.mars.basemanagement.domain.GeoSearchEquipmentCriteria criteria, final SelectedFacetValues selectedFacetValues) {
		return SearchQuery.builder("QryEquipmentGeo")
				.withCriteria(criteria)
				.withFacet(selectedFacetValues);
	}
	/**
	 * Création d'une SearchQuery de type : EquipmentGeoDistance.
	 * @param criteria Critères de recherche
	 * @param selectedFacetValues Liste des facettes sélectionnées à appliquer
	 * @return SearchQueryBuilder pour ce type de recherche
	 */
	public SearchQueryBuilder createSearchQueryBuilderEquipmentGeoDistance(final io.mars.basemanagement.domain.GeoSearchEquipmentCriteria criteria, final SelectedFacetValues selectedFacetValues) {
		return SearchQuery.builder("QryEquipmentGeoDistance")
				.withCriteria(criteria)
				.withFacet(selectedFacetValues);
	}

	/**
	 * Récupération du résultat issu d'une requête.
	 * @param searchQuery critères initiaux
	 * @param listState Etat de la liste (tri et pagination)
	 * @return Résultat correspondant à la requête (de type EquipmentIndex)
	 */
	public FacetedQueryResult<EquipmentIndex, SearchQuery> loadListIdxEquipment(final SearchQuery searchQuery, final DtListState listState) {
		final SearchIndexDefinition indexDefinition = io.vertigo.core.node.Node.getNode().getDefinitionSpace().resolve("IdxEquipment",SearchIndexDefinition.class);
		return searchManager.loadList(indexDefinition, searchQuery, listState);
	}
		
	/**
	 * Récupération du résultat issu d'une requête.
	 * @param searchQuery critères initiaux
	 * @param listState Etat de la liste (tri et pagination)
	 * @return Résultat correspondant à la requête (de type EquipmentIndex)
	 */
	public FacetedQueryResult<EquipmentIndex, SearchQuery> loadList(final SearchQuery searchQuery, final DtListState listState) {
		final List<SearchIndexDefinition> indexDefinitions = List.of( 
				io.vertigo.core.node.Node.getNode().getDefinitionSpace().resolve("IdxEquipment",SearchIndexDefinition.class));
		return searchManager.loadList(indexDefinitions, searchQuery, listState);
	}

	/**
	 * Mark an entity as dirty. Index of these elements will be reindexed if Tx commited.
	 * Reindexation isn't synchrone, strategy is dependant of plugin's parameters.
	 *
	 * @param entityUID Key concept's UID
	 */
	public void markAsDirty(final UID entityUID) {
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
	public void markAsDirty(final io.mars.basemanagement.domain.Equipment entity) {
		markAsDirty(UID.of(entity));
	}
	

	/** {@inheritDoc} */
	@Override
	public List<DefinitionSupplier> get(final DefinitionSpace definitionSpace) {
		return new ListBuilder<DefinitionSupplier>()
				//---
				// SearchIndexDefinition
				//-----
				.add(new SearchIndexDefinitionSupplier("IdxEquipment")
						.withIndexDtDefinition("DtEquipmentIndex")
						.withKeyConcept("DtEquipment")
						.withCopyToFields("allText", "name", "code", "description", "tags", "equipmentTypeName", "equipmentCategoryName", "baseName")
						.withLoaderId("EquipmentSearchLoader"))
				
				//---
				// FacetTermDefinition
				//-----
				.add(new FacetTermDefinitionSupplier("FctEquipmentEquipmentCategoryName")
						.withDtDefinition("DtEquipmentIndex")
						.withFieldName("equipmentCategoryName")
						.withLabel("Equipment Category")
						.withOrder(FacetOrder.count))
				.add(new FacetTermDefinitionSupplier("FctEquipmentEquipmentTypeName")
						.withDtDefinition("DtEquipmentIndex")
						.withFieldName("equipmentTypeName")
						.withLabel("Equipment Type")
						.withMultiSelectable()
						.withOrder(FacetOrder.count))
				.add(new FacetRangeDefinitionSupplier("FctEquipmentGeoDistance")
						.withDtDefinition("DtEquipmentIndex")
						.withFieldName("geoLocation")
						.withLabel("Location")
						.withRange("r1", "geoLocation:#geoLocation#~5km", "< 5km")
						.withRange("r2", "geoLocation:#geoLocation#~10km", "< 10km")
						.withRange("r3", "geoLocation:#geoLocation#~20km", "< 20km")
						.withRange("r4", "geoLocation:#geoLocation#~50km", "< 50km")
						.withRange("r5", "geoLocation:#geoLocation#~100km", "< 100km")
						.withRange("r6", "geoLocation:#geoLocation#~200km", "< 200km")
						.withRange("r7", "geoLocation:#geoLocation#~500km", "< 500km")
						.withRange("r8", "geoLocation:[#geoLocation#~500km to #geoLocation#~0km]", "> 500km")
						.withOrder(FacetOrder.definition))
				.add(new FacetCustomDefinitionSupplier("FctEquipmentGeoHash")
						.withDtDefinition("DtEquipmentIndex")
						.withFieldName("geoLocation")
						.withLabel("Location")
						.withParams("geohash_grid", "{\"field\" : \"geoLocation\", \"precision\" : #geoPrecision#}")
						.withParams("innerWriteTo", "writeVInt(#geoPrecision#);writeVInt(1000);writeVInt(-1)")
						.withOrder(FacetOrder.definition))
				.add(new FacetRangeDefinitionSupplier("FctEquipmentPurchaseDate")
						.withDtDefinition("DtEquipmentIndex")
						.withFieldName("purchaseDate")
						.withLabel("Purchase Date")
						.withRange("r1", "purchaseDate:[01/01/2008 TO 01/01/2012]", "2008-2012")
						.withRange("r2", "purchaseDate:[01/01/2012 TO 01/01/2016]", "2012-2016")
						.withRange("r3", "purchaseDate:[01/01/2016 TO *]", "after 2016")
						.withOrder(FacetOrder.definition))

				//---
				// FacetedQueryDefinition
				//-----
				.add(new FacetedQueryDefinitionSupplier("QryEquipment")
						.withFacet("FctEquipmentEquipmentTypeName")
						.withFacet("FctEquipmentPurchaseDate")
						.withFacet("FctEquipmentEquipmentCategoryName")
						.withListFilterBuilderClass(io.vertigo.datafactory.impl.search.dsl.DslListFilterBuilder.class)
						.withListFilterBuilderQuery("allText:#+query*#")
						.withCriteriaSmartType("STyLabel"))
				.add(new FacetedQueryDefinitionSupplier("QryEquipmentGeo")
						.withFacet("FctEquipmentEquipmentTypeName")
						.withFacet("FctEquipmentPurchaseDate")
						.withFacet("FctEquipmentEquipmentCategoryName")
						.withFacet("FctEquipmentGeoHash")
						.withListFilterBuilderClass(io.vertigo.datafactory.impl.search.dsl.DslListFilterBuilder.class)
						.withListFilterBuilderQuery("allText:#+criteria*#")
						.withGeoSearchQuery("geoLocation: [#geoUpperLeft# to #geoLowerRight#]")
						.withCriteriaSmartType("STyDtGeoSearchEquipmentCriteria"))
				.add(new FacetedQueryDefinitionSupplier("QryEquipmentGeoDistance")
						.withFacet("FctEquipmentEquipmentTypeName")
						.withFacet("FctEquipmentPurchaseDate")
						.withFacet("FctEquipmentEquipmentCategoryName")
						.withFacet("FctEquipmentGeoDistance")
						.withFacet("FctEquipmentGeoHash")
						.withListFilterBuilderClass(io.vertigo.datafactory.impl.search.dsl.DslListFilterBuilder.class)
						.withListFilterBuilderQuery("allText:#+criteria*#")
						.withGeoSearchQuery("geoLocation: [#geoUpperLeft# to #geoLowerRight#]")
						.withCriteriaSmartType("STyDtGeoSearchEquipmentCriteria"))
				.build();
	}
}
