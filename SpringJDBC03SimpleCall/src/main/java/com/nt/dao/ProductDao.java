package com.nt.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import com.nt.bean.ProductBean;

@Repository("dao")
public class ProductDao {

	@Autowired
	private JdbcTemplate jt;
	@Autowired
	private SimpleJdbcInsert js;

	private static final String findById = "select *from product where p_id=?";

	public void insert(ProductBean bean) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("p_id", bean.getPid());
		map.put("p_name", bean.getPname());
		map.put("price", bean.getPrice());
		js.setTableName("product");
		int result = js.execute(map);
		System.out.println(result);
	}
	public void insertBPSPS(ProductBean bean) {
		BeanPropertySqlParameterSource bp=new BeanPropertySqlParameterSource(bean);
		js.setTableName("product");
		int result = js.execute(bp);
		System.out.println(result);
	}
	public void findByID(Integer id){
		List<Map<String, Object>> map=jt.queryForList(findById, id);
		System.out.println(map);
	}
}
