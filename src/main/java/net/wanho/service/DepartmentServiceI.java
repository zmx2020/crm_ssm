package net.wanho.service;

import java.util.List;

import net.wanho.entity.Department;
import net.wanho.exception.DaoException;

public interface DepartmentServiceI {

	List<Department> queryAllDepartment() throws DaoException;

}
