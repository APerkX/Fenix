/**
 * 
 */
package it.perk.fenix.test.config;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import it.perk.fenix.constants.BeanTestJunit;

/**
 * @author Perk
 *
 */
public class TestProva {
	
	private BeanTestJunit bean = new BeanTestJunit(); 
	
	@Test
	void givenEvenNumber_whenCheckingIsNumberEven_thenTrue() {
		boolean result = bean.isNumberEven(8);
		Assertions.assertTrue(result);
	}
	
	@Test
	void givenOddNumber_whenCheckingIsNumberEven_thenFalse() {
	    boolean result = bean.isNumberEven(3);
	 
	    Assertions.assertFalse(result);
	}

}
