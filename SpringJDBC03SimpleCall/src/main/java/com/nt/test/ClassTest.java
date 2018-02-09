package com.nt.test;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.nt.bean.ProductBean;
import com.nt.confog.AppliConfig;
import com.nt.dao.ProductDao;

public class ClassTest {

	public static void main(String[] args) {
		ApplicationContext ct=new AnnotationConfigApplicationContext(AppliConfig.class);
		ProductDao dao=ct.getBean("dao",ProductDao.class);
		
		ProductBean bean=new  ProductBean();
		
		bean.setPid(127);
		bean.setPname("DVD-1");
		bean.setPrice(200);
		
		dao.insertBPSPS(bean);
		
		
		
	}
}
