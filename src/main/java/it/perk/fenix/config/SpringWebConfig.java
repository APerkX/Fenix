/**
 * 
 */
package it.perk.fenix.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * @author Perk
 *
 */
@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "it.perk.fenix.controller")
public class SpringWebConfig {

}
