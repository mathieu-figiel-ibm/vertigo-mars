package io.vertigo.pandora.domain.persons;

import io.vertigo.dynamo.domain.model.Fragment;
import io.vertigo.dynamo.domain.model.UID;
import io.vertigo.dynamo.domain.stereotype.Field;
import io.vertigo.dynamo.domain.util.DtObjectUtil;
import io.vertigo.lang.Generated;

/**
 * This class is automatically generated.
 * DO NOT EDIT THIS FILE DIRECTLY.
 */
@Generated
@io.vertigo.dynamo.domain.stereotype.Fragment(fragmentOf = "DT_PERSON")
public final class PersonLink implements Fragment<Person> {
	private static final long serialVersionUID = 1L;

	private String fullName;
	private String photoHref;
	private Boolean existsInBdd;
	private Long perId;

	/** {@inheritDoc} */
	@Override
	public UID<Person> getEntityURI() {
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
	 * Récupère la valeur de la propriété 'Movie type'.
	 * @return Boolean existsInBdd
	 */
	@Field(domain = "DO_ACTIVE", persistent = false, label = "Movie type")
	public Boolean getExistsInBdd() {
		return existsInBdd;
	}

	/**
	 * Champ : DATA.
	 * Définit la valeur de la propriété 'Movie type'.
	 * @param existsInBdd Boolean
	 */
	public void setExistsInBdd(final Boolean existsInBdd) {
		this.existsInBdd = existsInBdd;
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
	
	/** {@inheritDoc} */
	@Override
	public String toString() {
		return DtObjectUtil.toString(this);
	}
}
