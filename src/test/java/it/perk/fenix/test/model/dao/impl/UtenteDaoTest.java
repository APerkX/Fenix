/**
 * 
 */
package it.perk.fenix.test.model.dao.impl;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import it.perk.fenix.config.HibernateJpaConfig;
import it.perk.fenix.logger.FenixLogger;
import it.perk.fenix.model.dao.IUtenteDAO;
import it.perk.fenix.model.dao.impl.UtenteDAO;

/**
 * @author Perk
 *
 */
@SpringJUnitConfig(HibernateJpaConfig.class)
//@ExtendWith(SpringExtension.class)
//@ContextConfiguration(classes = HibernateJpaConfig.class, loader = AnnotationConfigContextLoader.class)
@Disabled
public class UtenteDaoTest {
	
	/**
	 * Logger.
	 */
	private static final FenixLogger LOGGER = FenixLogger.getLogger(UtenteDaoTest.class.getName());
	
	@Autowired
	public ApplicationContext appContext;

//	@Autowired
//	public IUtenteDAO utenteDao;
	
	@Test
    void givenAppContext_WhenInjected_ThenItShouldNotBeNull() {
		Assertions.assertNotNull(appContext);
	}
	
	
//	@Test
////	@Rollback
//	@Transactional
//	public void getUtenteFromUsername() {
//		String username = "biagio.mazzotta";
//		UtenteDTO u = utenteDao.getByUsername(username);
//		
//		Assertions.assertNotNull(u);
//	}

}
