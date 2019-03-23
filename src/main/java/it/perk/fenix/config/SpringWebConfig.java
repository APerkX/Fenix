/**
 * 
 */
package it.perk.fenix.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import it.perk.fenix.provider.PropertiesProvider;

/**
 * @author Perk
 *
 */
@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "it.perk.fenix.controller")
@ComponentScan(basePackages = "it.perk.fenix.provider")
public class SpringWebConfig {

	/**
	 * In questo modo vengono caricate tutte le properties da DB allo Start dell'applicazione.
	 * (Valutare se farlo in questo momento o alla primo vero utilizzo all'interno dell'applicazione)
	 * Tempo medio di caricamento: 1.3 sec.
	 * 
	 * @return PropertiesProvider
	 */
	@Bean
	public PropertiesProvider loadProperties() {
		return PropertiesProvider.getIstance();
	}
}
