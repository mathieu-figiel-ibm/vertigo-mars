package io.vertigo.pandora.domain.persons;

import io.vertigo.dynamo.domain.model.Fragment;
import io.vertigo.dynamo.domain.model.URI;
import io.vertigo.dynamo.domain.stereotype.Field;
import io.vertigo.dynamo.domain.util.DtObjectUtil;

/**
 * Attention cette classe est générée automatiquement !
 * Objet de données PersonActorRoleLink
 */
@io.vertigo.dynamo.domain.stereotype.Fragment(fragmentOf = "DT_PERSON")
public final class PersonActorRoleLink implements Fragment<Person> {

	/** SerialVersionUID. */
	private static final long serialVersionUID = 1L;

	private String fullName;
	private String photoHref;
	private String role;
	private Long perId;

	/** {@inheritDoc} */
	@Override
	public URI<Person> getEntityURI() {
		return DtObjectUtil.createEntityURI(this); 
	}

	/**
	 * Champ : DATA.
	 * Récupère la valeur de la propriété 'FULL NAME'.
	 * @return String fullName
	 */
	@Field(domain = "DO_LABEL", label = "FULL NAME")
	public String getFullName() {
		return fullName;
	}

	/**
	 * Champ : DATA.
	 * Définit la valeur de la propriété 'FULL NAME'.
	 * @param fullName String
	 */
	public void setFullName(final String fullName) {
		this.fullName = fullName;
	}

	/**
	 * Champ : DATA.
	 * Récupère la valeur de la propriété 'PHOTO HREF'.
	 * @return String photoHref
	 */
	@Field(domain = "DO_HREF", label = "PHOTO HREF")
	public String getPhotoHref() {
		return photoHref;
	}

	/**
	 * Champ : DATA.
	 * Définit la valeur de la propriété 'PHOTO HREF'.
	 * @param photoHref String
	 */
	public void setPhotoHref(final String photoHref) {
		this.photoHref = photoHref;
	}

	/**
	 * Champ : DATA.
	 * Récupère la valeur de la propriété 'Role'.
	 * @return String role
	 */
	@Field(domain = "DO_LABEL", persistent = false, label = "Role")
	public String getRole() {
		return role;
	}

	/**
	 * Champ : DATA.
	 * Définit la valeur de la propriété 'Role'.
	 * @param role String
	 */
	public void setRole(final String role) {
		this.role = role;
	}

	/**
	 * Champ : FOREIGN_KEY.
	 * Récupère la valeur de la propriété 'PER ID'.
	 * @return Long perId <b>Obligatoire</b>
	 */
	@Field(domain = "DO_IDENTITY", type = "FOREIGN_KEY", required = true, label = "PER ID")
	public Long getPerId() {
		return perId;
	}

	/**
	 * Champ : FOREIGN_KEY.
	 * Définit la valeur de la propriété 'PER ID'.
	 * @param perId Long <b>Obligatoire</b>
	 */
	public void setPerId(final Long perId) {
		this.perId = perId;
	}

	//Aucune Association déclarée

	/** {@inheritDoc} */
	@Override
	public String toString() {
		return DtObjectUtil.toString(this);
	}
}