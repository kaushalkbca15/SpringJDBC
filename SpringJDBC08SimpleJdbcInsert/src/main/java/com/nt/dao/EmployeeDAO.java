package com.nt.dao;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import com.nt.bean.EmployeeBo;
import com.nt.bean.ProductBean;

@Repository("dao")
public class EmployeeDAO {

	@Autowired
	private SimpleJdbcInsert insert;
	
	public void save(EmployeeBo bo){
		Map<String,Object> map= new HashMap<String,Object>();
		map.put("empno",bo.getE_id());
		map.put("ename", bo.getName());
		map.put("job", bo.getJob());
		
		insert.setTableName("emp");
		int result=insert.execute(map);
		System.out.println("Result:"+result);
	}
	
	public void save(ProductBean pro){
		BeanPropertySqlParameterSource source=new BeanPropertySqlParameterSource(pro);
		insert.setTableName("product");
		int result=insert.execute(source);
		System.out.println("Result:"+result);
	}
}

