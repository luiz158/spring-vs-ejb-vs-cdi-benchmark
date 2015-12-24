package psamolysov.demo.restws;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@ComponentScan(basePackageClasses = ApplicationConfig.class)
@EnableWebMvc
public class ApplicationConfig {
}
