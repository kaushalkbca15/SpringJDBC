package com.nt.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.nt.bean.EmployeeBo;
import com.nt.config.AppliConfig;
import com.nt.dao.EmployeeDao;

public class ClassTest {

	public static void main(String[] args) {
		ApplicationContext ct=new AnnotationConfigApplicationContext(AppliConfig.class);
		EmployeeDao dao=ct.getBean("dao",EmployeeDao.class);
		//dao.findById(7369);
		//dao.findBySalary(100.00);
		
		EmployeeBo bo=new EmployeeBo();
		bo.setE_id(68);
		bo.setName("Mahesh");
		bo.setJob("sales Man");
		dao.save(bo);
		
		//dao.findByDeptno(10);
		
	}
}
