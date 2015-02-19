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

package sample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.rest.webmvc.config.RepositoryRestMvcConfiguration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@SpringBootApplication
@EnableJpaRepositories
@Import(RepositoryRestMvcConfiguration.class)
//@EnableAutoConfiguration(exclude = HibernateJpaAutoConfiguration.class)
public class App extends WebMvcConfigurerAdapter
{
//	private static final String[] SERVLET_RESOURCE_LOCATIONS = { "/" };
//	
//	private static final String[] CLASSPATH_RESOURCE_LOCATIONS = { "classpath:/templates/", "classpath:/fragments/", "classpath:/css/" };
//	private static final String[] RESOURCE_LOCATIONS;
//	
//	static
//	{
//		RESOURCE_LOCATIONS = new String[CLASSPATH_RESOURCE_LOCATIONS.length + SERVLET_RESOURCE_LOCATIONS.length];
//		System.arraycopy(SERVLET_RESOURCE_LOCATIONS, 0, RESOURCE_LOCATIONS, 0, SERVLET_RESOURCE_LOCATIONS.length);
//		System.arraycopy(CLASSPATH_RESOURCE_LOCATIONS, 0, RESOURCE_LOCATIONS, SERVLET_RESOURCE_LOCATIONS.length, CLASSPATH_RESOURCE_LOCATIONS.length);
//	}
	
	public static void main(String[] args)
	{
		SpringApplication.run(App.class, args);
	}
	
	@Override
	public void addViewControllers(ViewControllerRegistry registry)
	{
		registry.addViewController("/login").setViewName("login");
		registry.addViewController("/").setViewName("index");
	}
	
//	@Override
//	public void addResourceHandlers(ResourceHandlerRegistry registry)
//	{
//		if (!registry.hasMappingForPattern("/webjars/**"))
//		{
//			registry.addResourceHandler("/webjars/**").addResourceLocations("classpath:/META-INF/resources/webjars/");
//		}
//		if (!registry.hasMappingForPattern("/**"))
//		{
//			registry.addResourceHandler("/**").addResourceLocations(RESOURCE_LOCATIONS);
//		}
//	}
}
