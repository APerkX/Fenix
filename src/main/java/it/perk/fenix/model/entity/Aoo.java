/**
 * 
 */
package it.perk.fenix.model.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * Entità che mappa la tabella AOO.
 * 
 * @author Perk
 *
 */
@Entity
@Table(name = "AOO")
public class Aoo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2466352065584937096L;
	
	/**
	 * Identificativo.
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "IDAOO")
	private Long idAoo;

	/**
	 * Informazioni filenet.
	 */
	@OneToOne(mappedBy = "aoo")
	private AooFilenet aooFilenet;

	/**
	 * Codice.
	 */
	@Column(name = "CODICEAOO")
	private String codiceAoo;

	/**
	 * Descrizione.
	 */
	@Column(name = "DESCRIZIONE")
	private String descrizione;


	/**
	 * Identificativo ente.
	 */
	@Column(name = "IDENTE") // andrebbe prevista una relazione @OneToOne con l'entità ENTE.
	private BigDecimal idEnte;

	/**
	 * Ente.
	 */
//	private Ente ente;

	/**
	 * Tipo protocollo utilizzato.
	 */
//	private TipoProtocollo tipoProtocollo;
	
	/**
	 * Salva PIN.
	 */
	@Column(name = "SALVA_PIN")
	private boolean salvaPin;
	
	/**
	 * Salva ALTEZZAFOOTER.
	 */
//	private Integer altezzaFooter;
	
	/**
	 * Salva SPAZIATURAFIRMA.
	 */
	@Column(name = "SPAZIATURAFIRMA")
	private Integer spaziaturaFirma;
	
	/**
	 * Tipo ricevuta utilizzato.
	 */
//	private TipoRicevuta tipoRicevuta;
	
	/**
	 * Parametri Aoo.
	 */
	@Column(name = "PARAMETRIAOO")
	private Long parametriAOO;
	
	/**
	 * ID Nodo Padre della struttura Organigramma.
	 */
	@Column(name = "IDNODORADICE")
	private Long idNodoRadice;
	
	/**
	 * ID logo Aoo.
	 */
	@Column(name = "ID_LOGO")
	private Integer idLogo;
	
	/**
	 * Referenza Nodi.
	 */
	@OneToMany(mappedBy = "aoo")
    private Collection<Nodo> nodi;
	
	/**
	 * Costruttore.
	 */
	public Aoo() {
		super();
	}

	/**
	 * @return the idAoo
	 */
	public Long getIdAoo() {
		return idAoo;
	}

	/**
	 * @param idAoo the idAoo to set
	 */
	public void setIdAoo(Long idAoo) {
		this.idAoo = idAoo;
	}

	/**
	 * @return the codiceAoo
	 */
	public String getCodiceAoo() {
		return codiceAoo;
	}

	/**
	 * @param codiceAoo the codiceAoo to set
	 */
	public void setCodiceAoo(String codiceAoo) {
		this.codiceAoo = codiceAoo;
	}

	/**
	 * @return the descrizione
	 */
	public String getDescrizione() {
		return descrizione;
	}

	/**
	 * @param descrizione the descrizione to set
	 */
	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	/**
	 * @return the idEnte
	 */
	public BigDecimal getIdEnte() {
		return idEnte;
	}

	/**
	 * @param idEnte the idEnte to set
	 */
	public void setIdEnte(BigDecimal idEnte) {
		this.idEnte = idEnte;
	}

	/**
	 * @return the salvaPin
	 */
	public boolean isSalvaPin() {
		return salvaPin;
	}

	/**
	 * @param salvaPin the salvaPin to set
	 */
	public void setSalvaPin(boolean salvaPin) {
		this.salvaPin = salvaPin;
	}

	/**
	 * @return the spaziaturaFirma
	 */
	public Integer getSpaziaturaFirma() {
		return spaziaturaFirma;
	}

	/**
	 * @param spaziaturaFirma the spaziaturaFirma to set
	 */
	public void setSpaziaturaFirma(Integer spaziaturaFirma) {
		this.spaziaturaFirma = spaziaturaFirma;
	}

	/**
	 * @return the parametriAOO
	 */
	public Long getParametriAOO() {
		return parametriAOO;
	}

	/**
	 * @param parametriAOO the parametriAOO to set
	 */
	public void setParametriAOO(Long parametriAOO) {
		this.parametriAOO = parametriAOO;
	}

	/**
	 * @return the idNodoRadice
	 */
	public Long getIdNodoRadice() {
		return idNodoRadice;
	}

	/**
	 * @param idNodoRadice the idNodoRadice to set
	 */
	public void setIdNodoRadice(Long idNodoRadice) {
		this.idNodoRadice = idNodoRadice;
	}

	/**
	 * @return the idLogo
	 */
	public Integer getIdLogo() {
		return idLogo;
	}

	/**
	 * @param idLogo the idLogo to set
	 */
	public void setIdLogo(Integer idLogo) {
		this.idLogo = idLogo;
	}

	/**
	 * @return the nodi
	 */
	public Collection<Nodo> getNodi() {
		return nodi;
	}

	/**
	 * @param nodi the nodi to set
	 */
	public void setNodi(Collection<Nodo> nodi) {
		this.nodi = nodi;
	}

	/**
	 * @return the aooFilenet
	 */
	public AooFilenet getAooFilenet() {
		return aooFilenet;
	}

	/**
	 * @param aooFilenet the aooFilenet to set
	 */
	public void setAooFilenet(AooFilenet aooFilenet) {
		this.aooFilenet = aooFilenet;
	}
	
	

}
