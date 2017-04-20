package io.vertigo.demo.domain.referentiel;

import io.vertigo.dynamo.domain.model.Entity;
import io.vertigo.dynamo.domain.model.URI;
import io.vertigo.dynamo.domain.stereotype.Field;
import io.vertigo.dynamo.domain.util.DtObjectUtil;

/**
 * Attention cette classe est générée automatiquement !
 * Objet de données Region
 */
public final class Region implements Entity {

	/** SerialVersionUID. */
	private static final long serialVersionUID = 1L;

	private Long regId;
	private String libelle;
	private io.vertigo.dynamo.domain.model.DtList<io.vertigo.demo.domain.referentiel.Departement> departement;

	/** {@inheritDoc} */
	@Override
	public URI<Region> getURI() {
		return DtObjectUtil.createURI(this);
	}

	/**
	 * Champ : ID.
	 * Récupère la valeur de la propriété 'REG_ID'.
	 * @return Long regId <b>Obligatoire</b>
	 */
	@Field(domain = "DO_IDENTIFIANT", type = "ID", required = true, label = "REG_ID")
	public Long getRegId() {
		return regId;
	}

	/**
	 * Champ : ID.
	 * Définit la valeur de la propriété 'REG_ID'.
	 * @param regId Long <b>Obligatoire</b>
	 */
	public void setRegId(final Long regId) {
		this.regId = regId;
	}

	/**
	 * Champ : DATA.
	 * Récupère la valeur de la propriété 'LIBELLE'.
	 * @return String libelle <b>Obligatoire</b>
	 */
	@Field(domain = "DO_LIBELLE", required = true, label = "LIBELLE")
	public String getLibelle() {
		return libelle;
	}

	/**
	 * Champ : DATA.
	 * Définit la valeur de la propriété 'LIBELLE'.
	 * @param libelle String <b>Obligatoire</b>
	 */
	public void setLibelle(final String libelle) {
		this.libelle = libelle;
	}

	/**
	 * Association : Departement.
	 * @return io.vertigo.dynamo.domain.model.DtList<io.vertigo.demo.domain.referentiel.Departement>
	 */
	public io.vertigo.dynamo.domain.model.DtList<io.vertigo.demo.domain.referentiel.Departement> getDepartementList() {
//		return this.<io.vertigo.demo.domain.referentiel.Departement> getList(getDepartementListURI());
		// On doit avoir une clé primaire renseignée. Si ce n'est pas le cas, on renvoie une liste vide
		if (io.vertigo.dynamo.domain.util.DtObjectUtil.getId(this) == null) {
			return new io.vertigo.dynamo.domain.model.DtList<>(io.vertigo.demo.domain.referentiel.Departement.class);
		}
		final io.vertigo.dynamo.domain.model.DtListURI fkDtListURI = getDepartementDtListURI();
		io.vertigo.lang.Assertion.checkNotNull(fkDtListURI);
		//---------------------------------------------------------------------
		//On est toujours dans un mode lazy.
		if (departement == null) {
			departement = io.vertigo.app.Home.getApp().getComponentSpace().resolve(io.vertigo.dynamo.store.StoreManager.class).getDataStore().findAll(fkDtListURI);
		}
		return departement;
	}

	/**
	 * Association URI: Departement.
	 * @return URI de l'association
	 */
	@io.vertigo.dynamo.domain.stereotype.Association (
			name = "A_REG_DEP",
			fkFieldName = "REG_ID",
			primaryDtDefinitionName = "DT_REGION",
			primaryIsNavigable = true,
			primaryRole = "Region",
			primaryLabel = "Region",
			primaryMultiplicity = "1..1",
			foreignDtDefinitionName = "DT_DEPARTEMENT",
			foreignIsNavigable = true,
			foreignRole = "Departement",
			foreignLabel = "Departement",
			foreignMultiplicity = "0..*")
	public io.vertigo.dynamo.domain.metamodel.association.DtListURIForSimpleAssociation getDepartementDtListURI() {
		return io.vertigo.dynamo.domain.util.DtObjectUtil.createDtListURIForSimpleAssociation(this, "A_REG_DEP", "Departement");
	}

	// Association : Region non navigable

	/** {@inheritDoc} */
	@Override
	public String toString() {
		return DtObjectUtil.toString(this);
	}
}