package com.nt.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.nt.bean.EmployeeBo;
import com.nt.bean.ProductBean;
import com.nt.config.AppliConfig;
import com.nt.dao.EmployeeDAO;

public class ClassTest {
	
	public static void main(String[] args) {
		ApplicationContext ct=new AnnotationConfigApplicationContext(AppliConfig.class);
		EmployeeDAO dao=ct.getBean("dao",EmployeeDAO.class);
		
		EmployeeBo bo=new EmployeeBo();
		bo.setE_id(401);
		bo.setName("Sohan");
		bo.setJob("COO");
		//dao.save(bo);
		ProductBean bean=new ProductBean();
		bean.setPid(658);
		bean.setPname("Hard Disk");
		bean.setPrice(5000);
		dao.save(bean);
		
	}

}
