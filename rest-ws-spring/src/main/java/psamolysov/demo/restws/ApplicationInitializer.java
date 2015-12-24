package psamolysov.demo.restws;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class ApplicationInitializer implements WebApplicationInitializer {

	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
		AnnotationConfigWebApplicationContext applicationContext = 
				new AnnotationConfigWebApplicationContext();
		applicationContext.register(ApplicationConfig.class);		
		
		servletContext.addListener(new ContextLoaderListener(applicationContext));
		
		ServletRegistration.Dynamic dispatcher = 
				servletContext.addServlet("spring-mvc-dispatcher", 
						new DispatcherServlet(applicationContext));
		dispatcher.setLoadOnStartup(1);
		dispatcher.addMapping("/api/*");		
	}
}
