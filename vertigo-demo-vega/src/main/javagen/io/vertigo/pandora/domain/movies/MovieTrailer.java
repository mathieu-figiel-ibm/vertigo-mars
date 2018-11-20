package io.vertigo.pandora.domain.movies;

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
@io.vertigo.dynamo.domain.stereotype.Fragment(fragmentOf = "DT_MOVIE")
public final class MovieTrailer implements Fragment<Movie> {
	private static final long serialVersionUID = 1L;

	private String trailerName;
	private String trailerHref;
	private Long movId;

	/** {@inheritDoc} */
	@Override
	public UID<Movie> getEntityURI() {
		return DtObjectUtil.createEntityURI(this); 
	}
	
	/**
	 * Champ : DATA.
	 * Récupère la valeur de la propriété 'TRAILER NAME'.
	 * @return String trailerName
	 */
	@Field(domain = "DO_LABEL", label = "TRAILER NAME")
	public String getTrailerName() {
		return trailerName;
	}

	/**
	 * Champ : DATA.
	 * Définit la valeur de la propriété 'TRAILER NAME'.
	 * @param trailerName String
	 */
	public void setTrailerName(final String trailerName) {
		this.trailerName = trailerName;
	}
	
	/**
	 * Champ : DATA.
	 * Récupère la valeur de la propriété 'TRAILER HREF'.
	 * @return String trailerHref
	 */
	@Field(domain = "DO_HREF", label = "TRAILER HREF")
	public String getTrailerHref() {
		return trailerHref;
	}

	/**
	 * Champ : DATA.
	 * Définit la valeur de la propriété 'TRAILER HREF'.
	 * @param trailerHref String
	 */
	public void setTrailerHref(final String trailerHref) {
		this.trailerHref = trailerHref;
	}
	
	/**
	 * Champ : FOREIGN_KEY.
	 * Récupère la valeur de la propriété 'MOV ID'.
	 * @return Long movId <b>Obligatoire</b>
	 */
	@Field(domain = "DO_IDENTITY", type = "FOREIGN_KEY", required = true, label = "MOV ID")
	public Long getMovId() {
		return movId;
	}

	/**
	 * Champ : FOREIGN_KEY.
	 * Définit la valeur de la propriété 'MOV ID'.
	 * @param movId Long <b>Obligatoire</b>
	 */
	public void setMovId(final Long movId) {
		this.movId = movId;
	}
	
	/** {@inheritDoc} */
	@Override
	public String toString() {
		return DtObjectUtil.toString(this);
	}
}
