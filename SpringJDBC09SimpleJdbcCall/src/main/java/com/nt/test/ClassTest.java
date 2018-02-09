package com.nt.test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.nt.config.AppliConfig;
import com.nt.dao.ProductDao;

public class ClassTest {

	public static void main(String[] args) {
		ApplicationContext ct=new AnnotationConfigApplicationContext(AppliConfig.class);
		ProductDao dao=ct.getBean("dao",ProductDao.class);
		dao.findAll(105);
	}
}
