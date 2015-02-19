// ***********************************************************************
// Copyright (c) 2015. ASA(ALT) SoSE Directorate
// All Rights Reserved.
// Permission to use, copy, modify, and distribute this software and
// its documentation for any purpose, without fee and without a signed
// licensing agreement, is hereby prohibited. Any unauthorized
// reproduction or distribution of this software, or any portion of it,
// may result in severe civil and criminal penalties, and will be
// prosecuted to the maximum extent possible under the law.
// ***********************************************************************

package sample.security;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.servlet.configuration.EnableWebMvcSecurity;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import sample.Global;

@Configuration
@EnableAutoConfiguration
@EnableWebSecurity
@EnableWebMvcSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
@Qualifier(Global.AUTHENTICATION_DATA_QUALIFIER)
@Lazy
public abstract class SecurityConfiguration extends WebSecurityConfigurerAdapter
{
	@Bean(name = Global.AUTHENTICATION_DATA_QUALIFIER + "DataSource")
	@Qualifier(Global.AUTHENTICATION_DATA_QUALIFIER)
	abstract DataSource dataSource();
	
	@Override
	protected void configure(HttpSecurity http) throws Exception
	{
		http.authorizeRequests().antMatchers("/application.properties", "/css/**", "/fonts/**","/fragments/**", "/js/**", "/less/**", "/webjars/**").permitAll().anyRequest().authenticated();
		
		http.formLogin().failureUrl("/login?error").defaultSuccessUrl("/").loginPage("/login").permitAll().and().logout()
				.logoutRequestMatcher(new AntPathRequestMatcher("/logout")).logoutSuccessUrl("/login").permitAll();
		
	}
	
	@Override
	public AuthenticationManager authenticationManagerBean() throws Exception
	{
		// TODO Auto-generated method stub
		return super.authenticationManagerBean();
	}
}