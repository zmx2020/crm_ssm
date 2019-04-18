package net.wanho.dao;

import java.util.List;

import net.wanho.entity.Department;
import net.wanho.exception.DaoException;

public interface DepartmentDaoI {

	List<Department> selAllDepartment() throws DaoException;

}
