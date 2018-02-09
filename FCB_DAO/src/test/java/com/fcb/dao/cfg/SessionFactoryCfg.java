package com.fcb.dao.cfg;

import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;

@Configuration
public class SessionFactoryCfg {

	@Autowired
	private DataSource dataSource;

	@Bean
	public LocalSessionFactoryBean localSessionFactoryBean() {
		LocalSessionFactoryBean bean = new LocalSessionFactoryBean();
		bean.setDataSource(dataSource);
		//bean.setAnnotatedClasses(EmployeeEntity.class);
		//bean.setAnnotatedPackages("com.nt.entity");
		return bean;
	}
}
