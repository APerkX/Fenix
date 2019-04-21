/**
 * 
 */
package it.perk.fenix.dto;

import java.io.Serializable;

/**
 * @author Perk
 *
 */
public class TandemDTO implements Serializable{

	/**
	 * Serialize.
	 */
	private static final long serialVersionUID = 5904137448138100098L;
	
	private PEDocumentoDTO datiPE;
	
	private MasterDocumentRedDTO datiCE;

	/**
	 * 
	 */
	public TandemDTO() {
		super();
	}
	
	public TandemDTO(PEDocumentoDTO tpe) {
		setDatiPE(tpe);
	}
	
	public TandemDTO(MasterDocumentRedDTO tce) {
		setDatiCE(tce);
	}

	/**
	 * @return the datiPE
	 */
	public PEDocumentoDTO getDatiPE() {
		return datiPE;
	}

	/**
	 * @return the datiCE
	 */
	public MasterDocumentRedDTO getDatiCE() {
		return datiCE;
	}

	/**
	 * @param datiPE the datiPE to set
	 */
	public void setDatiPE(PEDocumentoDTO datiPE) {
		this.datiPE = datiPE;
	}

	/**
	 * @param datiCE the datiCE to set
	 */
	public void setDatiCE(MasterDocumentRedDTO datiCE) {
		this.datiCE = datiCE;
	}
	
	
}
