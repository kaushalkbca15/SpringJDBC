package com.nt.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Repository;

import com.nt.bean.EmployeeBO;
import com.nt.bean.ProductBean;

@Repository("dao")
public class ProductDao {

	@Autowired
	private JdbcTemplate jt;
	
	private static final String insert_priduct = "insert into product values(?,?,?)";
	private static final String findById = "select *from product where p_id=?";
	private static final String findAll = "select *from product";
	private static final String findByPrice = "select *from product where price>=?";
	private static final String deleteById="delete from product where p_id=?";
	private static final String update="update product set p_name=? ,price=? where p_id=?";
	private static final String selectAllEmp="select *from emp";
	
	public void save(ProductBean bean) {
		int a = jt.update(insert_priduct, bean.getPid(), bean.getPname(), bean.getPrice());
		System.out.println(a);
	}

	public void findById(ProductBean bean) {
		Map<String, Object> map = jt.queryForMap(findById, bean.getPid());
		System.out.println(map);
	}

	public void findAll() {
		List<Map<String, Object>> result = jt.queryForList(findAll);
		System.out.println(result);
	}

	public void findByPrice(Integer price) {
		List<Map<String, Object>> result = jt.queryForList(findByPrice, price);
		System.out.println(result);
	}
	
	public void delete(Integer id){
		int result =jt.update(deleteById,id);
		System.out.println(result);
	}
	public void update(ProductBean bean){
		int result=jt.update(update,bean.getPname(),bean.getPrice(),bean.getPid());
		System.out.println(result);
	}
	 public void findAllEmp(){
		List<EmployeeBO> list=jt.query(selectAllEmp, new RowMapper());
		System.out.println(list);
	 }
	 private class RowMapper implements org.springframework.jdbc.core.RowMapper<EmployeeBO>{

		@Override
		public EmployeeBO mapRow(ResultSet rs, int p) throws SQLException {
			EmployeeBO bo=new EmployeeBO();
			bo.setEmpno(rs.getInt(1));	bo.setEname(rs.getString(2));bo.setJob(rs.getString(3));
			bo.setMgr(rs.getInt(4)); bo.setHiredate(rs.getDate(5)); bo.setSal(rs.getDouble(6));
			bo.setComm(rs.getDouble(7)); bo.setDeptno(rs.getInt(8));
			return bo;
		}
	 }
	 public void findAllEmpByMap(){
		 List<Map<String, Object>> result=jt.queryForList(selectAllEmp);
		 System.out.println(result);
	 }
	public void batchInserting(List<ProductBean> listbo){
	
		int[] a=jt.batchUpdate(insert_priduct,new BatchInsertion(listbo));
		System.out.println(a[0]);
	}
	private static class BatchInsertion implements BatchPreparedStatementSetter{

		List<ProductBean> listbo=null;
		public BatchInsertion(List<ProductBean> listbo) {
			this.listbo=listbo;
		}
		@Override
		public int getBatchSize() {
			return listbo.size();
		}
		@Override
		public void setValues(PreparedStatement ps, int index) throws SQLException {
			ps.setInt(1, listbo.get(index).getPid());
			ps.setString(2, listbo.get(index).getPname());
			ps.setInt(3,listbo.get(index).getPrice());
		}
	}
}
