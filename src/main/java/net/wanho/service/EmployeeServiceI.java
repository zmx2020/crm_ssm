package net.wanho.service;

import java.util.List;
import java.util.Map;

import net.wanho.dto.EmployeeDto;
import net.wanho.exception.ServiceException;
import net.wanho.util.PageBean;

public interface EmployeeServiceI {

	PageBean<EmployeeDto> pageFindEmployee(int currentPage, Map<String, Object> params, Map<String, String> operator) throws ServiceException;

	/* List<EmployeeDto> queryParentMenu() throws ServiceException; */

	EmployeeDto queryEmployeeById(Integer employee_id) throws ServiceException;

	void addEmployee(EmployeeDto employeeDto) throws ServiceException;
	
	void deleteEmployee(Integer menu_id) throws ServiceException;

	void updateEmployee(EmployeeDto employeeDto) throws ServiceException;
	
	void updateEmployeeStatus(Integer employee_id, String status) throws ServiceException;
	/*
	 * public boolean isExistMenuUrl(String menuUrl) throws ServiceException;
	 * 
	 * public boolean isExistMenuName(String menuName) throws ServiceException;
	 */
	 List<EmployeeDto> queryEmployeeByPositionId(Integer position_id) throws ServiceException;
	

}
