/**
 * 
 */
package it.perk.fenix.logger;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Perk
 *
 */
public class FenixLogger {

	private Logger logger;
	
	private FenixLogger(String inClsName) {
		logger = LoggerFactory.getLogger(inClsName);
	}
	
	public static FenixLogger getLogger(Class inCls) {
		return new FenixLogger(inCls.getName());
	}

	public static FenixLogger getLogger(String inClsName) {
		return new FenixLogger(inClsName);
	}
	
	
	public void info(String msg) {
		logger.info(msg);
	}
	
	public void error(String msg) {
		logger.error(msg);
	}
	
	public void error(String msg, Exception e) {
		logger.error(msg, e);
	}
	
	public void error(Exception e) {
		logger.error(e.getMessage(), e);
	}

	public void warn(String msg) {
		logger.warn(msg);
	}

	public void warn(String msg, Exception e) {
		logger.warn(msg, e);
	}

}
