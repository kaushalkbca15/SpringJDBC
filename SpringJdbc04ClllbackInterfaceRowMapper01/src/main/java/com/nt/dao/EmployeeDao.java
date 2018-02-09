package com.nt.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.nt.bean.EmployeeBo;

@Repository("dao")
public class EmployeeDao {

	@Autowired
	private JdbcTemplate jt;

	private static final String findById = "select empno,ename,job from emp where empno=?";

	private static final String findAll = "select empno,ename,job from emp";

	public EmployeeBo findById(Integer id) {

		EmployeeBo bo=jt.queryForObject(findById, new myRowMapper(), id);
		return bo;

	}

	private final class myRowMapper implements RowMapper<EmployeeBo> {

		@Override
		public EmployeeBo mapRow(ResultSet rs, int row) throws SQLException {
			EmployeeBo bo = new EmployeeBo();
			bo.setE_id(rs.getInt(1));
			bo.setName(rs.getString(2));
			bo.setJob(rs.getString(3));
			return bo;

		}

	}

}
