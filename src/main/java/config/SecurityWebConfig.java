package config;

import java.util.concurrent.ExecutionException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationTrustResolver;
import org.springframework.security.authentication.AuthenticationTrustResolverImpl;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
@ComponentScan({ "config" })
@ComponentScan({"controller"})
@ComponentScan({"dao"})
@ComponentScan({"entity"})
@ComponentScan({"model"})
@ComponentScan({"service"})
@ComponentScan({"utils"})
public class SecurityWebConfig {
	@Autowired
	private UserDetailsService userDetailService;
	
	@Bean
	public AuthenticationTrustResolver getAuthenticationTrustResolver()
	{
		return new AuthenticationTrustResolverImpl();
	}
	
	public PasswordEncoder passwordEncoder()
	{
		return new BCryptPasswordEncoder();
	}
	
	
//	@Override
//	protected void configure(HttpSecurity http) throws Execution
//	{
//		http
//		.authorizeRequests()
//			.anyRequest().authenticated()
//			.antMatchers("resources/**").permitAll()
//			
//		.and()
//			.formLogin()
//			.loginPage("/login")
//			.loginProcessingUrl("/handleLogin")
//			.usernameParameter("username")
//			.passwordParameter("password")
//			.permitAll()
//		.and()
//			.logout().logoutUrl("/logout")
//		.and().csrf()
//		.and().exceptionHandling().accessDeniedPage("/denied")
//		.and().userDetailsService(userDetailService);
//	}
}
