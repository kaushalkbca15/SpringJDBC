package com.nit.cnfgs;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

public class Mybeans {
	@Bean
	public DataSource datasource(@Value("${db.driverClassName}")
	String driverClassName,
    @Value("${db.url}")String url,
    @Value("${db.username}") String username,
    @Value("${db.password}") String password){
		DriverManagerDataSource datasource=new DriverManagerDataSource();
		datasource.setDriverClassName(driverClassName);
		datasource.setUrl(url);
		datasource.setUsername(username);
		datasource.setPassword(password);
	return datasource;
	}
	@Bean
public JdbcTemplate jdbctemplate()
    {
    	return new JdbcTemplate();
    }
	@Bean
	public static PropertyPlaceholderConfigurer placeholder()
	{
PropertyPlaceholderConfigurer phc=new PropertyPlaceholderConfigurer();
phc.setLocation(new ClassPathResource("com/nit/resources/database.properties"));
		PropertyPlaceholderConfigurer placeholder = null;
		return placeholder;
		
	}
	}
	

