package edu.globant.finalProject.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

@Configuration
@ImportResource({ "classpath:webSecurityConfig.xml" })
@ComponentScan("main.ar.com.globant.springmvc.configuration.security")
public class SecurityConfig {
 
    public SecurityConfig() {
        super();
    }
 
}

