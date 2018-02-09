package com.nt.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

@Repository("dao")
public class ProductDao {
/*
	@Autowired
	private JdbcTemplate jt;
	@Autowired
	private SimpleJdbcInsert js;*/
	
	@Autowired
	private NamedParameterJdbcTemplate np;
	
	private static final String select_named_query="select p_name from product where p_id=:pid";
	
	public void findById(Integer id){
		System.out.println(id);
		Map<String,Object> map=new HashMap<String, Object>();
		map.put("pid", id);
		System.out.println(select_named_query);
		String g=np.queryForObject(select_named_query, map,String.class);
		System.out.println(map);
	}
}
     