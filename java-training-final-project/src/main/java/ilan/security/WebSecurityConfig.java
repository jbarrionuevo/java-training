package ilan.security;

import java.util.Properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	
//	@Autowired
//	private UserDetailsService userDetailsService;
	
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .authorizeRequests()
                .antMatchers("/").permitAll()
                .antMatchers("/sellersView").hasRole("DELIVERY_SELLER")
                .antMatchers("/sellersView/**").hasAnyRole("STORE_SELLER","DELIVERY_SELLER","COMPLETE_SELLER")
                .antMatchers("/logisticView/**").hasRole("LOGISTIC")
                .antMatchers("/inventoryView/wrappers").hasRole("LOGISTIC")
                .antMatchers("/inventoryView/**").hasAnyRole("STORE_SELLER","DELIVERY_SELLER","COMPLETE_SELLER", "ADMIN")
                .antMatchers("/providersView/").hasRole("ADMIN")
                .antMatchers("/providersView/{providerId}").hasRole("PROVIDER")
                .anyRequest().authenticated()
                .and()
            .formLogin()
                .loginPage("/login")
                .permitAll()
                .and()
            .logout().logoutSuccessUrl("/")
                .permitAll();
        http.csrf().disable();
    }
    
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(inMemoryUserDetailsManager());
    }
    
    @Bean
    public InMemoryUserDetailsManager inMemoryUserDetailsManager() {
        final Properties users = new Properties();
        users.put("logistic","logistic,ROLE_LOGISTIC,enabled");
        users.put("provider","provider,ROLE_PROVIDER,enabled"); 
        users.put("store_seller","store_seller,ROLE_STORE_SELLER,enabled"); 
        users.put("delivery_seller","delivery_seller,ROLE_DELIVERY_SELLER,enabled");
        users.put("super","super,ROLE_ADMIN,enabled"); 
        users.put("ilan","ilan,ROLE_DELIVERY_SELLER,enabled");
        
        return new InMemoryUserDetailsManager(users);
    }
    
//  @Override
// 	public void configure(AuthenticationManagerBuilder auth) throws Exception {
// 	        auth
// 	                .userDetailsService(userDetailsService)
// 	                .passwordEncoder(new BCryptPasswordEncoder());
// 	}
}
