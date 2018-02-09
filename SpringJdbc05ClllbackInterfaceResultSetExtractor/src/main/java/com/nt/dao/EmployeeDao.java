package com.nt.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.nt.bean.EmployeeBo;

@Repository("dao")
public class EmployeeDao {

	@Autowired
	private JdbcTemplate jt;

	private static final String findById = "select empno,ename,job from emp where empno=?";
	private static final String findAll = "select empno,ename,job from emp";
	

	public void findById(Integer id) {

		List<EmployeeBo> bo = jt.query(findById, new ResultSetExtractor(), id);
		System.out.println(bo);
	}

	private class ResultSetExtractor implements org.springframework.jdbc.core.ResultSetExtractor<List<EmployeeBo>> {

		public List<EmployeeBo> extractData(ResultSet rs) throws SQLException, DataAccessException {
			List<EmployeeBo> list = new ArrayList<EmployeeBo>();
			while (rs.next()) {
				EmployeeBo bo = new EmployeeBo();
				bo.setE_id(rs.getInt(1));
				bo.setName(rs.getString(2));
				bo.setJob(rs.getString(3));
				list.add(bo);
			}
			return list;
		}
	}
	
	public  void findAll(){
		List<EmployeeBo> list =jt.query(findAll, new ResultSetExtractor());
		System.out.println(list);
	}
	
}
