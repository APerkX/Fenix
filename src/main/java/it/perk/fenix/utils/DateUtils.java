/**
 * 
 */
package it.perk.fenix.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.TimeZone;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

import it.perk.fenix.exception.FenixException;
import it.perk.fenix.logger.FenixLogger;

/**
 * Utility per la gestione dei file.
 * 
 * @author Perk
 *
 */
public class DateUtils {
	
	/**
	 * Logger.
	 */
	private static final FenixLogger LOGGER = FenixLogger.getLogger(DateUtils.class.getName());
	
	/**
	 * Formato data semplice.
	 */
	public static final String DD_MM_YYYY = "dd/MM/yyyy";
	
	/**
	 * Formato data con ora, minuti e secondi
	 */
	public static final String DD_MM_YYYY_HH_MM_SS = "dd/MM/yyyy HH:mm:ss";
	
	public static final LocalDateTime NULL_DATE = LocalDateTime.parse("16/08/1906 21:26:41", DateTimeFormatter.ofPattern(DD_MM_YYYY_HH_MM_SS));
	
	public static final LocalDateTime NULL_DATE_IT = LocalDateTime.parse("16/08/1906 21:26:40", DateTimeFormatter.ofPattern(DD_MM_YYYY_HH_MM_SS));
	
	static final String ISO_DATETIME_COMPACT_PATTERN = "yyyyMMdd'T'HHmmss'Z'";
	
	
	/**
	 * Costruttore.
	 */
	private DateUtils() {
	}
	
	/**
	 * Metodo per eliminare i dati relativi al tempo dalla data.
	 * 
	 * @param date	data iniziale
	 * @return		data epurata dalle informazioni temporali
	 */
	public static Date dropTimeInfo(final Date date) {
		Calendar cal = Calendar.getInstance(); 
		cal.setTime(date);
		cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MILLISECOND, 0);
		return cal.getTime();
	}
	
	/**
	 * Metodo per aggiungere ore ad una data.
	 * 
	 * @param date	data di partenza
	 * @param nHour	ore da aggiungere
	 * @return		nuova data
	 */
	public static Date addHour(final Date date, final Integer nHour) {
		Calendar cal = Calendar.getInstance(); 
		cal.setTime(date);
		cal.add(Calendar.HOUR_OF_DAY, nHour);
		return cal.getTime();
	}
	
	public static String getIsoDatetimeFormat(Date d) {
		SimpleDateFormat isodateformatter = new SimpleDateFormat(ISO_DATETIME_COMPACT_PATTERN);
		return isodateformatter.format(d);
	}
	
	/**
	 * Converti una data standard in USLocale.
	 * 
	 * @param data		data originaria
	 * @param inFormat	formato
	 * @return			data formattata
	 * @throws RedException	restituita in caso di errore di formattazione
	 */
	public static String formatDataByUSLocale(final String data, final String inFormat) {

		String dateFormatted = "";
		if (!StringUtils.isNullOrEmpty(data)) {

			String format = inFormat;
			if (inFormat == null) {
				format = DD_MM_YYYY;
			}
			
			SimpleDateFormat dateStandard = null;
			Date d = null;
			try {
				dateStandard = new SimpleDateFormat("EEE MMM dd HH:mm:ss Z yyyy", Locale.ENGLISH);
				d = dateStandard.parse(data);
			} catch (ParseException e) {
				throw new FenixException("Errore nella formattazione della data. " + e.getMessage());
			}

			SimpleDateFormat dateFormatter = new SimpleDateFormat(format);
			dateFormatter.setTimeZone(TimeZone.getDefault());

			dateFormatted = dateFormatter.format(d);
		}

		return dateFormatted;
	}
	
	/**
	 * Metodo per la conversione di una data in stringa.
	 * 
	 * @param date		data da convertire
	 * @param inFormat	formato
	 * @return			stringa convertita
	 */
	public static String dateToString(final Date date, final String inFormat) {
		String output = null;
		if (date != null) {
			String format = inFormat;
			if (inFormat == null) {
				format = DD_MM_YYYY;
			}
			SimpleDateFormat dateFormatter = new SimpleDateFormat(format);
			dateFormatter.setTimeZone(TimeZone.getDefault());
			output = dateFormatter.format(date);
		}
		return output;
	}
	
	/**
	 * Metodo per convertire una data in una stringa.
	 * 
	 * @param d			data da convertire
	 * @param noTime	se false indica di recuperare anche l'orario
	 * @return			la stringa risultante dalla conversione
	 */
	public static String dateToString(final Date d, final boolean noTime) {
		String dateFormat;
		String s = "";
		if (noTime) {
			dateFormat = DD_MM_YYYY;
		} else {
			dateFormat = "dd/MM/yyyy HH:mm";
		}
		SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
		if (d != null) {
			s = sdf.format(d);
		}
		return s;
	}
	
	
	/**
	 * Ottieni un oggetto data da una stringa.
	 * 
	 * @param s
	 * @return
	 */
	public static Date parseDate(String s) {
		Date d = null;
		if (s == null) {
			return d;
		}

		String pattern = "";

		if (s.indexOf(':') >= 0) {
			if (s.length() > 20) {
				pattern = "yyyy-MM-dd HH:mm:ss.SSS";
			} else {
				if (s.lastIndexOf(':') != s.indexOf(':'))
					pattern = DD_MM_YYYY_HH_MM_SS;
				else
					pattern = "dd/MM/yyyy HH:mm";
			}
		} else {
			pattern = DD_MM_YYYY;
		}

		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		sdf.setTimeZone(TimeZone.getDefault());
		if (s.length() > 0) {
			try {
				d = sdf.parse(s);
			} catch (ParseException e) {
				throw new FenixException("Errore nella conversione della data. " + e.getMessage());
			}
		}
		return d;
	}
	
	/**
	 * Parser di una data contenuta in una stringa
	 * 
	 * @param s
	 * @param myPattern
	 * @return
	 */
	public static String parseStringDate(String s, String myPattern) {

		String pattern = "";
		Locale locale = null;
		if (s.indexOf(':') >= 0) {
			if (s.length() > 23) {

				pattern = "EEE MMM dd HH:mm:ss Z yyyy";
				locale = Locale.ENGLISH;

			} else if (s.length() > 20) {

				pattern = "yyyy-MM-dd HH:mm:ss.SSS";

			} else {
				pattern = DD_MM_YYYY_HH_MM_SS;

			}
		} else {
			pattern = DD_MM_YYYY;
		}

		SimpleDateFormat sdfSource = null;
		if (pattern.length() > 23) {
			sdfSource = new SimpleDateFormat(pattern, locale);
		} else {
			sdfSource = new SimpleDateFormat(pattern);
		}

		Date date = null;
		try {
			date = sdfSource.parse(s);
		} catch (ParseException e) {
			LOGGER.error(e);
		}

		SimpleDateFormat sdfDestination = new SimpleDateFormat(myPattern);

		return sdfDestination.format(date);
	}
	
	
	/**
	 * Se dataInizio o dataFine sono null, il metodo è in grado di non prenderle in considerazione.
	 * 
	 * @param data
	 * @param dataInizio
	 * @param dataFine
	 * @param inclusive
	 * @return
	 */
	public static Boolean inRange(Date data, Date dataInizio, Date dataFine, Boolean inclusive) {
	    boolean i = false;
	    boolean f = false;
	    if(inclusive){
	    	i = (dataInizio == null || !dataInizio.after(data));
	    	f = (dataFine == null || !dataFine.before(data));
	    } else {
	    	i = (dataInizio == null || dataInizio.before(data));
	    	f = (dataFine == null || dataFine.after(data));
	    }
	    return i && f;
	}
	
	
	/**
	 * Setta il time della data di riferimento alle 23:59:59:999
	 * 
	 * @param date
	 * @return
	 */
	public static Date setDateTo2359(Date date) {
		if (date == null)
			return null;
		Date result = (Date) date.clone();
		Calendar cal = Calendar.getInstance();
		cal.setTime(result);
		cal.set(Calendar.HOUR_OF_DAY, 23);
		cal.set(Calendar.MINUTE, 59);
		cal.set(Calendar.SECOND, 59);
		cal.set(Calendar.MILLISECOND, 999);
		result.setTime(cal.getTime().getTime());
		return result;
	}
	
	
	/**
	 * Setta il time della data di riferimento alle 00:00:00:000
	 * 
	 * @param date
	 * @return
	 */
	public static Date setDateTo0000(Date date) {
		if (date == null)
			return null;
		Date result = (Date) date.clone();
		Calendar cal = Calendar.getInstance();
		cal.setTime(result);
		cal.set(Calendar.HOUR_OF_DAY, 00);
		cal.set(Calendar.MINUTE, 00);
		cal.set(Calendar.SECOND, 00);
		cal.set(Calendar.MILLISECOND, 000);
		result.setTime(cal.getTime().getTime());
		return result;
	}
	
	
	public static String formatTwoDigitsFieldWithLeadingZero(int field, Calendar calendar) {
		if (calendar == null) {
			calendar = Calendar.getInstance();
		}
		
		int numberToFormat = calendar.get(field);
		if (field == Calendar.MONTH) { 
			// I mesi del Calendar partono da 0, quindi si deve incrementare il numero
			numberToFormat++;
		}
		
		// Formato "%02d" per ottenere un intero decimale ("d") a due cifre, eventualmente preceduto da uno zero.
		return String.format("%02d", numberToFormat);
	}
	
	public static XMLGregorianCalendar buildXmlGregorianCalendarFromDate(Date date) throws DatatypeConfigurationException {
		if (date != null) {
			GregorianCalendar calendar = new GregorianCalendar();
			calendar.setTime(date);
			return DatatypeFactory.newInstance().newXMLGregorianCalendar(calendar);
		}
		return null;
	}
}
