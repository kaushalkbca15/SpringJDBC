package com.nt.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.nt.bean.EmployeeBo;

@Repository("dao")
public class EmployeeDao {

	@Autowired
	private NamedParameterJdbcTemplate np;
	
	private static final String findById="select ename from emp where empno=:eno";
	private static final String findBySalary="select empno,sal,ename from emp where sal>=:sal";
	private static final String saveEmloyeedetails="insert into emp (empno,ename,job)values(:ae_id,:name,:job)";
	private static final String findByDeptno="select  empno,sal,ename from emp where deptno=:deptno";
	public void findById(Integer id){
		
		Map<String,Object> map=new HashMap<String, Object>();
		map.put("eno",id);
		String name=np.queryForObject(findById, map,String.class);
		System.out.println(name);
	}
	
	public void findBySalary(Double sal){
		Map<String,Object> map=new HashMap<String, Object>();
		map.put("sal", sal);
		List<EmployeeBo> list=np.query(findBySalary,map, new MyResultSetExtranter());
		System.out.println(list);
	}
	private class MyResultSetExtranter implements ResultSetExtractor<List<EmployeeBo>>{
		@Override
		public List<EmployeeBo> extractData(ResultSet rs) throws SQLException, DataAccessException {
			List<EmployeeBo> list=new ArrayList<EmployeeBo>();
			while(rs.next()){
				EmployeeBo bo=new EmployeeBo();
				bo.setE_id(rs.getInt(1));
				bo.setName(rs.getString(2));
				bo.setJob(rs.getString(3));
				list.add(bo);
			}
			return list;
		}
	}//method
	
	public void save(EmployeeBo bo){
		BeanPropertySqlParameterSource source=new BeanPropertySqlParameterSource(bo);
		int result=np.update(saveEmloyeedetails, source);
		System.out.println("Result ::"+result);
	}
	public void findByDeptno(Integer dept){
		MapSqlParameterSource source=new MapSqlParameterSource();
		source.addValue("deptno", dept);
		List<EmployeeBo> list=np.query(findByDeptno, source,new MyResultSetExtranter());
		System.out.println(list);
	}
}
