package com.logger.Group1RoomServiceSys.security;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import com.logger.Group1RoomServiceSys.security.handlers.AccessDeniedHandlerImpl;
import com.logger.Group1RoomServiceSys.security.handlers.AuthenticationEntryPointImpl;
import com.logger.Group1RoomServiceSys.security.handlers.AuthenticationFailureHandlerImpl;
import com.logger.Group1RoomServiceSys.security.handlers.AuthenticationSuccessHandlerImpl;
import com.logger.Group1RoomServiceSys.security.handlers.LogoutSuccessHandlerImpl;

@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private AuthenticationEntryPointImpl authenticationEntryPointImpl;
	
	@Autowired
	private AccessDeniedHandlerImpl accessDeniedHandlerImpl;
	
	@Autowired
	private AuthenticationSuccessHandlerImpl authenticationSuccessHandlerImpl;
	
	@Autowired
	private AuthenticationFailureHandlerImpl authenticationFailureHandlerImpl;
	
	@Autowired
	private LogoutSuccessHandlerImpl logoutSuccessHandlerImpl;
	
	@Autowired
	private UserDetailsService userDetailsService;
	
	@Override
	public void configure(HttpSecurity http) throws Exception {
		http
			.csrf()			
				.disable()		// enabled by default
//				.csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse())
//				.and()
			.cors()				// enable cors, disabled by default
				.and()
			.authorizeRequests()
				.antMatchers("/index.html",
						"/users/*", 
						"/RoomService",
						"/users",
						"/RoomService/*",
						"/food",
						"/food/*").permitAll()
				//.antMatchers("/users").hasAnyRole("ADMIN")		//hasRole / hasAnyRole ("xxxx"), ROLE_xxxx
				//.antMatchers("/users").hasAnyRole("ADMIN")
				.anyRequest().authenticated()
				.and()
			.exceptionHandling()
				//.authenticationEntryPoint(authenticationEntryPointImpl)
				.and()
			.exceptionHandling()
				.accessDeniedHandler(accessDeniedHandlerImpl)
				.and()
			.formLogin()
				.permitAll()
				.loginProcessingUrl("/login")
				.usernameParameter("username")
				.passwordParameter("password")
				.failureHandler(authenticationFailureHandlerImpl)
				.successHandler(authenticationSuccessHandlerImpl)
				.and()
			.logout()
				.permitAll()	
				.logoutUrl("/logout")
				.logoutSuccessHandler(logoutSuccessHandlerImpl)
				.and()
			.rememberMe();	// 14 days by default
	}
	
	// @Bean : put the return object into spring container.
	@Bean
	public PasswordEncoder passwordEncoder(){
		//PasswordEncoder encoder = new BCryptPasswordEncoder(11);
		PasswordEncoder encoder = NoOpPasswordEncoder.getInstance();//new BCryptPasswordEncoder(11);
		return encoder;
	}
	
	// Autowire the parameter for this function
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
	    auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
	}
	
	@Bean
    public CorsConfigurationSource corsConfigurationSource() {
		CorsConfiguration configuration = new CorsConfiguration();
        configuration.addAllowedOrigin("*"); // You should only set trusted site here. e.g. http://localhost:4200 means only this site can access.
        configuration.setAllowedMethods(Arrays.asList("GET","POST","PUT","DELETE","HEAD","OPTIONS"));
        configuration.addAllowedHeader("*");
        configuration.setAllowCredentials(true);
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }
}
