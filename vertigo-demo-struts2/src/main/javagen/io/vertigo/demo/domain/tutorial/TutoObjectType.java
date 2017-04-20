package io.vertigo.demo.domain.tutorial;

import io.vertigo.dynamo.domain.model.Entity;
import io.vertigo.dynamo.domain.model.URI;
import io.vertigo.dynamo.domain.stereotype.Field;
import io.vertigo.dynamo.domain.util.DtObjectUtil;

/**
 * Attention cette classe est générée automatiquement !
 * Objet de données TutoObjectType
 */
@io.vertigo.dynamo.domain.stereotype.DataSpace("static")
public final class TutoObjectType implements Entity {

	/** SerialVersionUID. */
	private static final long serialVersionUID = 1L;

	private Long typId;
	private String code;
	private String libelle;

	/** {@inheritDoc} */
	@Override
	public URI<TutoObjectType> getURI() {
		return DtObjectUtil.createURI(this);
	}

	/**
	 * Champ : ID.
	 * Récupère la valeur de la propriété 'ID Type'.
	 * @return Long typId <b>Obligatoire</b>
	 */
	@Field(domain = "DO_IDENTIFIANT", type = "ID", required = true, label = "ID Type")
	public Long getTypId() {
		return typId;
	}

	/**
	 * Champ : ID.
	 * Définit la valeur de la propriété 'ID Type'.
	 * @param typId Long <b>Obligatoire</b>
	 */
	public void setTypId(final Long typId) {
		this.typId = typId;
	}

	/**
	 * Champ : DATA.
	 * Récupère la valeur de la propriété 'Code type'.
	 * @return String code <b>Obligatoire</b>
	 */
	@Field(domain = "DO_CODE", required = true, label = "Code type")
	public String getCode() {
		return code;
	}

	/**
	 * Champ : DATA.
	 * Définit la valeur de la propriété 'Code type'.
	 * @param code String <b>Obligatoire</b>
	 */
	public void setCode(final String code) {
		this.code = code;
	}

	/**
	 * Champ : DATA.
	 * Récupère la valeur de la propriété 'Libell�'.
	 * @return String libelle <b>Obligatoire</b>
	 */
	@Field(domain = "DO_LIBELLE", required = true, label = "Libell�")
	public String getLibelle() {
		return libelle;
	}

	/**
	 * Champ : DATA.
	 * Définit la valeur de la propriété 'Libell�'.
	 * @param libelle String <b>Obligatoire</b>
	 */
	public void setLibelle(final String libelle) {
		this.libelle = libelle;
	}


	// Association : objet non navigable

	/** {@inheritDoc} */
	@Override
	public String toString() {
		return DtObjectUtil.toString(this);
	}
}