package com.nt.test;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.nt.bean.EmployeeBo;
import com.nt.confog.AppliConfig;
import com.nt.dao.EmployeeDao;

public class ClassTest {

	public static void main(String[] args) {
		ApplicationContext ctx=new AnnotationConfigApplicationContext(AppliConfig.class);
		EmployeeDao dao=ctx.getBean("dao",EmployeeDao.class);
		
		EmployeeBo bo=new EmployeeBo();
		bo.setE_id(301);
		bo.setName("Raja");
		bo.setJob("HR");
		
		EmployeeBo bo2=new EmployeeBo();
		bo2.setE_id(302);
		bo2.setName("Rani");
		bo2.setJob("manager");
		
		EmployeeBo b3=new EmployeeBo();
		b3.setE_id(303);
		b3.setName("Rajesh");
		b3.setJob("COO");
		
		List<EmployeeBo> listbo=new ArrayList<EmployeeBo>();
		listbo.add(bo);listbo.add(bo2);listbo.add(b3);
		System.out.println(listbo);
		dao.save(listbo);
	}
}
