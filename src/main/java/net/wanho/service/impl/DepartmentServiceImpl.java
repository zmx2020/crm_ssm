package net.wanho.service.impl;

import java.util.List;

import net.wanho.dao.DepartmentDaoI;
import net.wanho.entity.Department;
import net.wanho.exception.DaoException;
import net.wanho.factory.ObjectFactory;
import net.wanho.service.DepartmentServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DepartmentServiceImpl implements DepartmentServiceI {

	//private DepartmentDaoI departmentDaoI = (DepartmentDaoI) ObjectFactory.getObject("departmentDaoI");
	@Autowired
	private DepartmentDaoI departmentDaoI;
	@Override
	public List<Department> queryAllDepartment() throws DaoException {
		List<Department> list = departmentDaoI.selAllDepartment();
		return list;
	}

	

}
