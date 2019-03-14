/**
 * 
 */
package it.perk.fenix.dto;

import java.io.Serializable;

/**
 * @author Perk
 *
 */
public class UfficiRuoliDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8190720584098871997L;
	
	private UfficioDTO ufficio;

	private RuoloDTO ruolo;
	
	private Boolean predefinito;
	
	public UfficiRuoliDTO(UfficioDTO uff, RuoloDTO ruolo, Boolean isPredefinito) {
		this.ufficio = uff;
		this.ruolo = ruolo;
		this.predefinito = isPredefinito;
	}

	/**
	 * @return the ufficio
	 */
	public UfficioDTO getUfficio() {
		return ufficio;
	}

	/**
	 * @param ufficio the ufficio to set
	 */
	public void setUfficio(UfficioDTO ufficio) {
		this.ufficio = ufficio;
	}

	/**
	 * @return the ruolo
	 */
	public RuoloDTO getRuolo() {
		return ruolo;
	}

	/**
	 * @param ruolo the ruolo to set
	 */
	public void setRuolo(RuoloDTO ruolo) {
		this.ruolo = ruolo;
	}

	/**
	 * @return the predefinito
	 */
	public Boolean getPredefinito() {
		return predefinito;
	}

	/**
	 * @param predefinito the predefinito to set
	 */
	public void setPredefinito(Boolean predefinito) {
		this.predefinito = predefinito;
	}
	

}
