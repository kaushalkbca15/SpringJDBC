package com.fcb.FCB;

import org.hibernate.SessionFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.fcb.dao.cfg.ApplicationConfig;
import com.fcb.dao.cfg.SessionFactoryCfg;

public class AppTest{
	public static void main(String[] args) {
		System.out.println("hello");
		ApplicationContext ct=new AnnotationConfigApplicationContext(ApplicationConfig.class);
	}
}
