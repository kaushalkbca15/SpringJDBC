package com.nt.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.nt.confog.AppliConfig;
import com.nt.dao.EmployeeDao;

public class ClassTest {

	public static void main(String[] args) {
		ApplicationContext ctx=new AnnotationConfigApplicationContext(AppliConfig.class);
		EmployeeDao dao=ctx.getBean("dao",EmployeeDao.class);
		System.out.println(dao.findById(7369));
		//dao.findAll();
	}
}
