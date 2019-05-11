/**
 * 
 */
package it.perk.fenix.test.config;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit.jupiter.web.SpringJUnitWebConfig;
import org.springframework.web.context.WebApplicationContext;

import it.perk.fenix.config.SpringWebConfig;

/**
 * @author Perk
 *
 */
@SpringJUnitWebConfig(SpringWebConfig.class)
@Disabled
public class SpringWebConfigTest {

	@BeforeAll
	public static void initAppContext() {
		new HibernateJpaConfigTest(); 
		System.out.println("E' PASSATO DA QUI");
	}
	
	@Autowired
	private WebApplicationContext webAppContext;
	
	@Test
    void givenAppContext_WhenInjected_ThenItShouldNotBeNull() {
		Assertions.assertNotNull(webAppContext);
	}

}
