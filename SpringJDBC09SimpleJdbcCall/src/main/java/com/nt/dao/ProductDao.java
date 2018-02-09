package com.nt.dao;

import java.math.BigDecimal;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;

import com.nt.bean.ProductBean;

@Repository("dao")
public class ProductDao {

	@Autowired
	private SimpleJdbcCall call;
	
	public void findAll(Integer id){
		call.setProcedureName("product_findById3");
		
		SqlParameterSource source=new MapSqlParameterSource().addValue("iid", id);
		Map<String, Object>  res=call.execute(source);
		
		ProductBean bean=new ProductBean();
		bean.setPid(id);
		bean.setPname((String)res.get("O_NAME"));
		BigDecimal bd=(BigDecimal) res.get("O_PRICE");
		bean.setPrice(bd.intValue());
		int a=bd.intValue();
		System.out.println(bean);
	}
}
