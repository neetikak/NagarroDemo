package com.nagarro.demo.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
@Configuration
public class SpringsecurityConfi extends WebSecurityConfigurerAdapter{

	@Override
protected void configure(HttpSecurity h) throws Exception
{
	h.httpBasic().and().authorizeRequests().antMatchers("/view/admin/**").hasRole("admin").antMatchers("/view/user/**").hasRole("user")
	.and().formLogin();
	h.csrf().disable();
	h.authorizeRequests().antMatchers("/h2-console/**").permitAll()
    .and().csrf().ignoringAntMatchers("/h2-console/**")
    .and().headers().frameOptions().sameOrigin();
	h.sessionManagement().maximumSessions(1).maxSessionsPreventsLogin(true);
}
	protected void configure(AuthenticationManagerBuilder auth) throws Exception
	{
		auth.inMemoryAuthentication().withUser("admin").password("admin").roles("admin").and()
		.withUser("user").password("user").roles("user");
	}
	@Bean
	public PasswordEncoder passwordEncoder() {
	    return NoOpPasswordEncoder.getInstance();
	}
	}
