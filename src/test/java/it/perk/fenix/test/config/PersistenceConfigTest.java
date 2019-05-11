/**
 * 
 */
package it.perk.fenix.test.config;

import javax.servlet.ServletException;
import javax.sql.DataSource;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.support.AnnotationConfigContextLoader;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;

import it.perk.fenix.config.HibernateJpaConfig;
import it.perk.fenix.logger.FenixLogger;
import it.perk.fenix.model.dao.impl.UtenteDAO;
import it.perk.fenix.test.model.dao.impl.UtenteDaoTest;

/**
 * @author Perk
 *
 */
@ExtendWith(SpringExtension.class)
//@WebAppConfiguration
@ContextConfiguration(classes = {/*SpringWebConfig.class,*/ HibernateJpaConfig.class }, loader = AnnotationConfigContextLoader.class)
@Disabled
public class PersistenceConfigTest {
	
	/**
	 * Logger.
	 */
	private static final FenixLogger LOGGER = FenixLogger.getLogger(PersistenceConfigTest.class.getName());
	

//	@Autowired
//	private WebAppInitializer webAppInit;
//
	@Autowired
	private ApplicationContext appContext;
	
//	@Autowired
//	private WebApplicationContext webAppContext;

	private MockMvc mockMvc;
	
//	@Autowired
//	private final UtenteDAO utenteDAO;
//	
//	@Autowired
//	public PersistenceConfigTest(UtenteDAO utenteDAO) {
//		this.utenteDAO = utenteDAO;
//	}
	
//	@BeforeEach
//	public void setup() {
//		this.mockMvc = MockMvcBuilders.webAppContextSetup(webAppContext).build();
//	}
	
//	@Test
//	public void givenWac_whenServletContext_thenItProvidesGreetController() {
//	    ServletContext servletContext = webAppContext.getServletContext();
//	     
//	    Assertions.assertNotNull(servletContext);
////	    Assertions.assertTrue(servletContext instanceof MockServletContext);
////	    Assertions.assertNotNull(webAppContext.getBean("greetController"));
//	}
	
	@BeforeEach
	public void init() throws ServletException {
//		webAppInit.onStartup(webAppContext.getServletContext());
		int i = appContext.getBeanDefinitionCount();
		String[] names = appContext.getBeanDefinitionNames();
		LOGGER.info("Sono presenti " + i + " Beans: ");
		int c = 1;
		for (String s : names) {
			LOGGER.info("Bean " + c +" --> " + s);
			c++;
		}
	}
	
//	@Autowired
//	PersistenceConfigTest(UtenteDAO utenteDAO){
//		this.utenteDAO = utenteDAO;
//	}

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
