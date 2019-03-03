/**
 * 
 */
package it.perk.fenix.config;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

/**
 * @author Perk
 * 
 * Classe che dalla versione 5.0.0 di Spring sostituisce completamente il web.xml
 *
 */
public class WebAppInitializer implements WebApplicationInitializer {

	@Override
	public void onStartup(ServletContext container) throws ServletException {
		// Creazione dello Spring Context - Questo implica l'esclusivo utilizzo delle Configurazioni con @Annotazioni
		AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();
		// esegue lo scan per includere nello Spirng Context le componenti utilizzate nel proggetto
		context.scan("it.perk");
		container.addListener(new ContextLoaderListener(context));
		
		// Definizione dell'entry point per la web application - DispatcherServlet
		ServletRegistration.Dynamic dispatcher = container.addServlet("mvc", new DispatcherServlet(context));
		dispatcher.setLoadOnStartup(1);
		dispatcher.addMapping("/");
	}

}
