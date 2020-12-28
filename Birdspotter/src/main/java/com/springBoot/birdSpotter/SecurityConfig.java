package com.springBoot.birdSpotter;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {

		auth.inMemoryAuthentication().withUser("spotter").password("{noop}RedDuck007").roles("SPOTTER").and()
				.withUser("admin").password("{noop}eagle").roles("SPOTTER", "ADMIN");
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.formLogin().defaultSuccessUrl("/birdspotting", true).loginPage("/login").usernameParameter("username")
				.passwordParameter("password").and().exceptionHandling().accessDeniedPage("/403").and().csrf();

		http.authorizeRequests().antMatchers("/login").permitAll().antMatchers("/birds-spotted/**").permitAll()
		.antMatchers("/**/newbirdspotting").hasRole("ADMIN").antMatchers("/**").hasRole("SPOTTER");
	}

}
