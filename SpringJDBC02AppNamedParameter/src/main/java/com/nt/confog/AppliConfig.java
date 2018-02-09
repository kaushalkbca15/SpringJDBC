package com.nt.confog;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
@ComponentScan(basePackages = "com.nt.dao")
public class AppliConfig {

	public DataSource dataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("oracle.jdbc.driver.OracleDriver");
		dataSource.setUrl("jdbc:oracle:thin:@localhost:1521:xe");
		dataSource.setUsername("system");
		dataSource.setPassword("manager");
		return dataSource;
	}

	@Bean(name = "jt")
	public JdbcTemplate jdbcTemplate() {
		JdbcTemplate jdbcTemplate = new JdbcTemplate();
		jdbcTemplate.setDataSource(dataSource());
		return jdbcTemplate;
	}

	@Bean(name = "js")
	public SimpleJdbcInsert simpleJdbcInsert() {
		SimpleJdbcInsert insert = new SimpleJdbcInsert(dataSource());
		return insert;
	}
	@Bean(name="np")
	public NamedParameterJdbcTemplate parameterJdbcTemplate(){
	NamedParameterJdbcTemplate nm=
			new NamedParameterJdbcTemplate(dataSource());
		return nm;
	}

}
