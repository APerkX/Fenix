/**
 * 
 */
package it.perk.fenix.helper.filenet.pe;

import java.util.ArrayList;
import java.util.List;

import filenet.vw.api.VWException;
import filenet.vw.api.VWFetchType;
import filenet.vw.api.VWQueue;
import filenet.vw.api.VWQueueQuery;
import filenet.vw.api.VWRoster;
import filenet.vw.api.VWSession;
import it.perk.fenix.exception.FilenetException;
import it.perk.fenix.logger.FenixLogger;

/**
 * Classe per la gestione delle query Filenet.
 * 
 * @author Perk
 *
 */
public class FilenetPEQueryBuilder {

	/**
	 * Logger.
	 */
	private static final FenixLogger LOGGER = FenixLogger.getLogger(FilenetPEQueryBuilder.class.getName());
	
	/**
	 * Buffer size.
	 */
	private static final int DEFAULT_BUFFER_SIZE = 250;

	/**
	 * operatore " AND ".
	 */
	private static final String AND = " AND ";

	/**
	 * operatore " OR ".
	 */
	private static final String OR = " OR ";
	
	/**
	 * String builder.
	 */
	private StringBuilder sb;

	/**
	 * Variabili.
	 */
	private List<Object> subVarsList;

	/**
	 * Coda.
	 */
	private VWQueue queue;

	/**
	 * Contstore variabili.
	 */
	private Integer index;
	
	/**
	 * Classe per modellare una proposizione.
	 *
	 * @author Perk
	 *         
	 */
	public class Proposition {
		
		/**
		 * Sql.
		 */
		private String sql;

		/**
		 * Costruttore.
		 * 
		 * @param field	campo
		 * @param value	valore
		 */
		public Proposition(final String field, final Object value) {
			sql = field + " = :" + (index++);
			subVarsList.add(value);
		}

		/**
		 * Getter.
		 * 
		 * @return	sql
		 */
		private String getSql() {
			return sql;
		}
	}
	
	/**
	 * Costruttore.
	 * 
	 * @param session	sessione
	 * @param nomeQueue	nome coda
	 */
	public FilenetPEQueryBuilder(final VWSession session, final String nomeQueue) {
		this(session, nomeQueue, DEFAULT_BUFFER_SIZE);
	}

	/**
	 * Costruttore.
	 * 
	 * @param session		sessione
	 * @param nomeQueue		coda
	 * @param bufferSize	dimensione buffer
	 */
	public FilenetPEQueryBuilder(final VWSession session, final String nomeQueue, final Integer bufferSize) {
		try {
			queue = session.getQueue(nomeQueue);
			queue.setBufferSize(bufferSize);
			sb = new StringBuilder();
			subVarsList = new ArrayList<>();
			index = 1;
		} catch (VWException e) {
			LOGGER.error(e);
			throw new FilenetException(e);
		}
	}
	
	/**
	 * Creazione proposizione.
	 * 
	 * @param field	campo
	 * @param value	valore
	 * @return		proposizione
	 */
	public Proposition createProposition(final String field, final Object value) {
		return new Proposition(field, value);
	}
	
	/**
	 * Proposizione and.
	 * 
	 * @param field	campo
	 * @param value	valore
	 */
	public void and(final String field, final Object value) {
		if (sb.length() != 0) {
			sb.append(AND);
		}
		sb.append(field + " = :" + (index++));
		subVarsList.add(value);
	}

	/**
	 * Proposizione or.
	 * 
	 * @param propositions	proposizioni
	 */
	public void or(final Proposition[] propositions) {
		if (sb.length() != 0) {
			sb.append(AND);
		}
		sb.append("(");
		String orCondition = OR;
		for (Proposition p : propositions) {
			sb.append(p.getSql() + OR);
		}
		sb = new StringBuilder(sb.substring(0, sb.length() - (orCondition.length())));
		sb.append(")");
	}
	
	/**
	 * Operatore 'IN'.
	 * 
	 * @param field	campo
	 * @param value	valore
	 */
	public void in(final String field, final Long[] value) {
		StringBuilder list = new StringBuilder();
		if (sb.length() != 0) {
			sb.append(AND);
		}
		for (int i = 0; i < value.length; i++) {
			 list.append(value[i].toString() + ",");
		}
		list.deleteCharAt(list.length()-1);
		sb.append(field + " IN (" + list.toString() + " ) ");
	}
	
	/**
	 * Proposizione ge (GraterEqual).
	 * 
	 * @param field	campo
	 * @param value	valore
	 */
	public void ge(final String field, final Object value) {
		if (sb.length() != 0) {
			sb.append(AND);
		}
		sb.append(field + " >= :" + (index++));
		subVarsList.add(value);
	}
	
	/**
	 * Proposizione le (LessEqual).
	 * 
	 * @param field	campo
	 * @param value	valore
	 */
	public void le(final String field, final Object value) {
		if (sb.length() != 0) {
			sb.append(AND);
		}
		sb.append(field + " <= :" + (index++));
		subVarsList.add(value);
	}
	
	/**
	 * Creazione query.
	 * 	
	 * @param eager	modalità eager
	 * @return		query
	 */
	public VWQueueQuery createQuery(final Boolean eager) {
		return createQuery(eager, null);
	}
	
	/**
	 * Creazione query.
	 * 	
	 * @param eager	modalità eager
	 * @param indexName	- Index name
	 * @return		query
	 */
	public VWQueueQuery createQuery(final Boolean eager, final String indexName) {
		try {
			Object[] subVars = new Object[subVarsList.size()];
			subVarsList.toArray(subVars);
			Integer queryFlag = VWRoster.QUERY_GET_NO_TRANSLATED_SYSTEM_FIELDS;
			if (eager) {
				queryFlag = VWRoster.QUERY_NO_OPTIONS;
			}
			return queue.createQuery(indexName, null, null, queryFlag, sb.toString(), subVars, VWFetchType.FETCH_TYPE_WORKOBJECT);
		} catch (VWException e) {
			LOGGER.error(e);
			throw new FilenetException(e);
		}
	}
}
