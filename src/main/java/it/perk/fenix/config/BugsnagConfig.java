/**
 * 
 */
package it.perk.fenix.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import com.bugsnag.Bugsnag;
import com.bugsnag.BugsnagSpringConfiguration;

/**
 * Classe di Configurazione di Bugsnag.
 * 
 * @author Perk
 *
 */
@Configuration
@Import(BugsnagSpringConfiguration.class)
public class BugsnagConfig {

	@Bean
    public Bugsnag bugsnag() {
        return new Bugsnag("7d85db376d36dad447361f155411272e");
    }
	
}
