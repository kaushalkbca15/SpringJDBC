package com.nt.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.nt.bean.EmployeeBo;
@Repository("dao")
public class EmployeeDao {

	@Autowired
	private JdbcTemplate jt;
	
	private static final String batchinsert="insert into emp (empno,ename,job) values(?,?,?)";
	public void save(List<EmployeeBo> bo){
		int count[]=null;
		count=jt.batchUpdate(batchinsert,new BatchInsertion(bo)); 
		System.out.println(count);
	}
	private class BatchInsertion implements BatchPreparedStatementSetter{
		private List<EmployeeBo> bo=null;
		public BatchInsertion(List<EmployeeBo> bo) {
			this.bo=bo;
		}
		@Override
		public int getBatchSize() {
			System.out.println("getBatchSize()");
			return bo.size();
		}
		@Override
		public void setValues(PreparedStatement ps, int index) throws SQLException {
			
			ps.setInt(1, bo.get(index).getE_id());
			ps.setString(2,bo.get(index).getName());
			ps.setString(3, bo.get(index).getJob());
			System.out.println("setValues");
			System.out.println(index);
		}
		
	}
}
