/**
 * 
 */
package it.perk.fenix.test.config;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import it.perk.fenix.config.HibernateJpaConfig;

/**
 * @author Perk
 *
 */
@SpringJUnitConfig(classes = HibernateJpaConfig.class)
public class SpringConfigTest {
	
	@Autowired
	private ApplicationContext applicationContext;

	@Test
    void givenAppContext_WhenInjected_ThenItShouldNotBeNull() {
		Assertions.assertNotNull(applicationContext);
	}
}
