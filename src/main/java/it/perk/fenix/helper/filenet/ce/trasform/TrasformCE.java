/**
 * 
 */
package it.perk.fenix.helper.filenet.ce.trasform;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Collection;

import javax.sql.DataSource;

import com.filenet.api.collection.DocumentSet;
import com.filenet.api.core.Document;

import it.perk.fenix.enums.TrasformerCEEnum;
import it.perk.fenix.exception.FenixException;
import it.perk.fenix.exception.FilenetException;
import it.perk.fenix.helper.filenet.ce.trasform.impl.TrasformerCE;
import it.perk.fenix.logger.FenixLogger;
import it.perk.fenix.provider.ApplicationContextProvider;

/**
 * Classe per la trasformazione degli oggetti CE.
 * 
 * @author Perk
 *
 */
@SuppressWarnings({"rawtypes", "unchecked"})
public abstract class TrasformCE {

	/**
	 * Logger.
	 */
	private static final FenixLogger LOGGER = FenixLogger.getLogger(TrasformCE.class.getName());
	
	/**
	 * Costruttore.
	 */
	private TrasformCE() {
	}
	
	/**
	 * Metodo per la chiusura della connessione.
	 * 
	 * @param connection - Connessione al DB
	 */
	private static void closeConnection(final Connection connection) {
		if (connection != null) {
			try {
				connection.close();
			} catch (SQLException e) {
				LOGGER.error("Errore durante la chiusura della connessione: ",  e);
			}
		}
	}
	
	/**
	 * Getter della connessione.
	 * 
	 * @return	connessione
	 */
	private static Connection getConnection() {
		Connection connection = null;
		try {
			connection = ((DataSource) ApplicationContextProvider.getApplicationContext().getBean("DataSource")).getConnection();
			connection.setTransactionIsolation(Connection.TRANSACTION_READ_COMMITTED);
			connection.setAutoCommit(false);
		} catch (Exception e) {
			closeConnection(connection);
			LOGGER.error("Errore nel recupero della connessione al DB:", e);
			throw new FenixException("Errore nel recupero della connessione al DB.", e);
		}
	    return connection;
	}

	/**
	 * Metodo per la trasformazione di un document set in un insieme di oggetti.
	 * 
	 * @param <T>			tipologia degli oggetti restituiti
	 * @param documentSet	insieme dei documenti
	 * @param te			tipologia di trasformazione
	 * @return				collezione degli oggetti trasformati
	 */
	public static <T> Collection<T> transform(final DocumentSet documentSet, final TrasformerCEEnum te) {
		Connection connection =  null;
		try {
			TrasformerCE trasformer = TrasformerCEFactory.getInstance().getTrasformer(te);
			connection = getConnection();
			return trasformer.trasform(documentSet, connection);
		} catch (Exception e) {
			LOGGER.error("Errore durante il trasform della lista di documenti: ", e);
			throw new FenixException("Errore durante il trasform della lista di documenti. ", e);
		} finally {
			closeConnection(connection);
		}
	}

	/**
	 * Metodo per la trasformazione di un documento in un oggetto.
	 * 
	 * @param <T>		tipologia degli oggetti restituiti
	 * @param document	documento da trasformare
	 * @param te		trasformazione
	 * @return			oggetto trasformato
	 */
	public static <T> T transform(final Document document, final TrasformerCEEnum te) {
		TrasformerCE trasformer = TrasformerCEFactory.getInstance().getTrasformer(te);
		Connection connection = null;
		try {
			connection = getConnection();
			return (T) trasformer.trasform(document, connection);
		} catch (Exception e) {
			LOGGER.error(e.getMessage());
			LOGGER.error("Errore durante il recupero delle informazioni del documento.", e);
			throw new FilenetException(e);
		} finally {
			closeConnection(connection);
		}
	}

	/**
	 * Fuziona esattamente come il metodo transform per documento singolo 
	 * ma gli viene passata la connessione
	 * 
	 * @param document
	 * @param te
	 * @param connection
	 * @return
	 */
	public static <T> T transform(final Document document, final TrasformerCEEnum te, final Connection connection) {
		TrasformerCE trasformer = TrasformerCEFactory.getInstance().getTrasformer(te);
		return (T) trasformer.trasform(document, connection);
	}
}
