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
		/*ProductBean bean=new ProductBean();
		bean.setPid(102);
		bean.setPname("mouse");
		bean.setPrice(300);
		dao.save(bean);
		*/
		/*dao.findById(bean);
		*/
		
		//dao.findAll();
		//dao.findByPrice(100);
		//dao.delete(101);
		
		
		/*ProductBean bean=new ProductBean();
		bean.setPid(102);
		bean.setPname("LCD");
		bean.setPrice(5000);
		dao.update(bean);*/
		
		//dao.findAllEmp();
		//dao.findAllEmpByMap();
		
		ProductBean p1=new ProductBean();
		p1.setPid(105);
		p1.setPname("keyboard");
		p1.setPrice(500);
		
		ProductBean p2=new ProductBean();
		p2.setPid(106);
		p2.setPname("Mouse");
		p2.setPrice(400);
		
		ProductBean p3=new ProductBean();
		p3.setPid(107);
		p3.setPname("project");
		p3.setPrice(10000);
		List<ProductBean> list=new ArrayList<ProductBean>();
		list.add(p1);list.add(p2);list.add(p3);
		dao.batchInserting(list);
		
		
	}
}
