package com.example.Expenses;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityCon
{
	@Autowired
	UserDetailsService userDetailsService;
	
	//CustomLogoutSuccessHandler customLogoutSucessHandler;
	//BCryptPasswordEncoder passwordencoder =new BCryptPasswordEncoder(12);
	

    @Bean
    public SecurityFilterChain securityfilterchain (HttpSecurity http) throws Exception
	{
		http.csrf(customizer->customizer.disable());
		http.authorizeHttpRequests(authorize->authorize
				.requestMatchers("/public/**").permitAll().anyRequest().authenticated());
		http.formLogin().and(). logout(logout -> logout
                .logoutUrl("/logout") // Optional: specify a custom logout URL
                .logoutSuccessUrl("/public/register") // Redirect after successful logout
                .invalidateHttpSession(true) // Invalidate HTTP session
                .deleteCookies("JSESSIONID") // Delete specific cookies
            );
		
		/*http.httpBasic(Customizer.withDefaults());
		http.sessionManagement(session->session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));*/
		return http.build();
	}
   
	
    @Bean
    public AuthenticationProvider authenticationprovier()
    {	
    	DaoAuthenticationProvider provider=new DaoAuthenticationProvider();
    	provider.setPasswordEncoder(new BCryptPasswordEncoder(12));
    	provider.setUserDetailsService(userDetailsService);
    	return provider;
    }
    
   
}