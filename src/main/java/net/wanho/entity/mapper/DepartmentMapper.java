package net.wanho.entity.mapper;

import java.sql.ResultSet;

import net.wanho.entity.Department;


public class DepartmentMapper implements RowMapper<Department> {

	@Override
	public Department mapRow(ResultSet rs) throws Exception {
		return new Department(rs.getInt("DEPARTMENT_ID"),
				   rs.getString("DEPARTMENT_NAME"));
	}

}

