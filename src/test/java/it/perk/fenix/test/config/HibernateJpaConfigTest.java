/**
 * 
 */
package it.perk.fenix.test.config;

import javax.sql.DataSource;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.core.ClassesKey;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import it.perk.fenix.config.HibernateJpaConfig;
import it.perk.fenix.config.WebAppInitializer;
import it.perk.fenix.model.dao.impl.UtenteDAO;

/**
 * @author Perk
 *
 */
@SpringJUnitConfig(classes = {WebAppInitializer.class, HibernateJpaConfig.class})
public class HibernateJpaConfigTest {
	
	@Autowired
	private ApplicationContext appContext;

//	@Autowired
//	private UtenteDAO utenteDAO;
	

	@Test
    void givenAppContext_WhenInjected_ThenItShouldNotBeNull() {
		Assertions.assertNotNull(appContext);
	}
	
	@Test
	void givenAppContext_CheckDataSource() {
		DataSource ds = (DataSource) appContext.getBean("dataSource");
		Assertions.assertNotNull(ds);
	}
}
