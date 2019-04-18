package net.wanho.dao;

import java.util.List;
import java.util.Map;

import net.wanho.dto.EmployeeDto;
import net.wanho.exception.DaoException;

public interface EmployeeDaoI {

	List<EmployeeDto> selEmployeeByPage(int currentPage, int pageSize, Map<String, Object> params, Map<String, String> operator) throws DaoException;

	List<EmployeeDto> selEmployeeById(Integer employee_id) throws DaoException;

	int selTotalRecord(Map<String, Object> params, Map<String, String> operator) throws DaoException;

	List<EmployeeDto> selEmployeeByEmail(String email) throws DaoException;

	List<EmployeeDto> selEmployeeByPhone(String phone) throws DaoException;

	Long insEmployee(EmployeeDto employeeDto) throws DaoException;

	void updEmployee(EmployeeDto employeeDto) throws DaoException;

	void updateEmployeeStatus(Integer employee_id, String status)throws DaoException;

	List<EmployeeDto> selEmployeeByPositionId(Integer position_id) throws DaoException;
	

}
