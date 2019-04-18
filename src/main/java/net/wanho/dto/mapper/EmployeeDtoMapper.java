package net.wanho.dto.mapper;

import java.sql.ResultSet;


import net.wanho.dto.EmployeeDto;

import net.wanho.entity.mapper.RowMapper;


public class EmployeeDtoMapper implements RowMapper<EmployeeDto> {

	
	@Override
	public EmployeeDto mapRow(ResultSet rs) throws Exception {
		return new EmployeeDto(
				   
				   rs.getInt("EMPLOYEE_ID"),
				   rs.getString("EMPLOYEE_NAME"),
				   rs.getInt("DEPARTMENT_ID"),
				   rs.getString("DEPARTMENT_NAME"),
				   rs.getInt("POSITION_ID"),
				   rs.getString("POSITION_NAME"),
				   rs.getString("PHONE"),
				   rs.getString("EMAIL"),
				   rs.getString("STATUS"),
				   rs.getInt("PARENT_EMPLOYEE_ID"),
				   rs.getString("PARENT_EMPLOYEE_NAME"),
				   rs.getTimestamp("CREATE_TIME"),
				   rs.getTimestamp("UPDATE_TIME")
				   
				);
		
		
	}

}

