/**
 * 
 */
package it.perk.fenix.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import it.perk.fenix.exception.FenixException;

/**
 * Classe utilizzata per i Test del DateUtils.
 * 
 * @author Perk
 *
 */
@DisplayName("DateUtils Tests")
public class DateUtilsTest {
	
	public static final String EMPTY_STRING = "";
	
	@BeforeAll
	static void setup() {
		System.out.println("PASSA SEMPRE DA QUI PRIMA DI ESEGUIRE TUTTI I TEST");
	}
	
	@Test
	@DisplayName("dropTimeInfo Test")
	void dropTimeInfoTest() {

		Calendar cal = Calendar.getInstance(); 
		cal.setTime(new Date());
		cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MILLISECOND, 0);
		Date dateManualDropTime = cal.getTime();
		
		Date dateAutomaticDropTime = DateUtils.dropTimeInfo(new Date());
		
		Assertions.assertEquals(dateManualDropTime, dateAutomaticDropTime);
	}
	
	@Test
	@DisplayName("addHour Test")
	void addHourTest() {
		Date dateToBeTested = new Date();
		
		Calendar cal = Calendar.getInstance(); 
		cal.setTime(dateToBeTested);
		cal.add(Calendar.HOUR_OF_DAY, 1);
		Date dateManualAddHour = cal.getTime();
		
		Date dateAutomaticAddHour = DateUtils.addHour(dateToBeTested, 1);
		
		Assertions.assertEquals(dateManualAddHour, dateAutomaticAddHour);
	}
	
	@Test
	@DisplayName("getIsoDatetimeFormat Test")
	void isoDatetimeFormatTest() {
		Date dateToBeTested = new Date();
		
		SimpleDateFormat isodateformatter = new SimpleDateFormat(DateUtils.ISO_DATETIME_COMPACT_PATTERN);
		String isoDateFormattedManual = isodateformatter.format(dateToBeTested);
		
		String isoDateFormattedAutomatic = DateUtils.getIsoDatetimeFormat(dateToBeTested);
		
		Assertions.assertEquals(isoDateFormattedManual, isoDateFormattedAutomatic);
	}
	
	@Test
	@DisplayName("formatDataByUSLocale se la 'data' è null")
	void formatDataByUSLocale_IfDateIsNullOrEmpty() {
		String dateFormatted = DateUtils.formatDataByUSLocale(null, null);
		Assertions.assertEquals(EMPTY_STRING, dateFormatted);
	}
	
	@Test
	@DisplayName("formatDataByUSLocale se il 'formato' è null")
	void formatDataByUSLocale_IfFormatIsNullOrEmpty() {
		Date dateToBeTested = new Date();
		
		SimpleDateFormat dateFormatter = new SimpleDateFormat(DateUtils.DD_MM_YYYY);
		dateFormatter.setTimeZone(TimeZone.getDefault());
		String dateFormattedManually = dateFormatter.format(dateToBeTested);
		
		String dateFormattedAutomatic = DateUtils.formatDataByUSLocale(dateToBeTested.toString(), null);
		
		Assertions.assertEquals(dateFormattedManually, dateFormattedAutomatic);
	}
	
	@Test
	@DisplayName("formatDataByUSLocale con il 'formato' DD_MM_YYYY_HH_MM_SS")
	void formatDataByUSLocale_IfFormatIsDD_MM_YYYY_HH_MM_SS() {
		Date dateToBeTested = new Date();
		
		SimpleDateFormat dateFormatter = new SimpleDateFormat(DateUtils.DD_MM_YYYY_HH_MM_SS);
		dateFormatter.setTimeZone(TimeZone.getDefault());
		String dateFormattedManually = dateFormatter.format(dateToBeTested);
		
		String dateFormattedAutomatic = DateUtils.formatDataByUSLocale(dateToBeTested.toString(), DateUtils.DD_MM_YYYY_HH_MM_SS);
		
		Assertions.assertEquals(dateFormattedManually, dateFormattedAutomatic);
	}
	
	@Test
	@DisplayName("formatDataByUSLocale che lancia FenixException")
	void formatDataByUSLocale_AssertThrowsException() {
		Assertions.assertThrows(FenixException.class, () -> {
			DateUtils.formatDataByUSLocale("12/12/12", DateUtils.DD_MM_YYYY_HH_MM_SS);
	    });
	}
	
}
