package edu.globant.finalproject.configuration;


import java.util.Properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	
	@Autowired
    CustomSuccessHandler customSuccessHandler;
	
	@Autowired
	protected void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth
			.inMemoryAuthentication()
			.withUser("seller").password("seller").roles("SELLER");
		auth
			.inMemoryAuthentication()
			.withUser("logistic").password("logistic").roles("LOGISTIC");
		auth
			.inMemoryAuthentication()
			.withUser("admin").password("admin").roles("ADMIN");
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
        .authorizeRequests()
            .antMatchers("/").hasRole("LOGISTIC")
            //.antMatchers("/sales/**").hasRole("SELLER")
            .antMatchers("/inventory/**").hasRole("LOGISTIC")
            .anyRequest().authenticated()
            .and()
        .formLogin()
            .loginPage("/login")
            .successHandler(customSuccessHandler)
            .usernameParameter("ssoId")
            .passwordParameter("password")
            .and().csrf().and()
        .logout().logoutSuccessUrl("/")
            .permitAll();
		//http.csrf().disable();
	}
}