package net.wanho.mapper;

import net.wanho.entity.Department;
import net.wanho.exception.DaoException;

import java.util.List;

public interface DepartmentMapper {

	List<Department> selAllDepartment() throws DaoException;

}
