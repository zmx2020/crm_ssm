package net.wanho.service.impl;

import java.util.List;
import java.util.Map;

import net.wanho.consts.ConstVal;
import net.wanho.dao.EmployeeDaoI;
import net.wanho.dao.LoginDaoI;
import net.wanho.dto.EmployeeDto;
import net.wanho.exception.ServiceException;
import net.wanho.factory.ObjectFactory;
import net.wanho.service.EmployeeServiceI;
import net.wanho.util.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl implements EmployeeServiceI {

	//EmployeeDaoI employeeDaoI = (EmployeeDaoI) ObjectFactory.getObject("employeeDaoI");
	//LoginDaoI loginDaoI = (LoginDaoI) ObjectFactory.getObject("loginDaoI");
	@Autowired
	private  EmployeeDaoI employeeDaoI;
	@Autowired
	private  LoginDaoI loginDaoI;
	@Override
	public PageBean<EmployeeDto> pageFindEmployee(int currentPage, Map<String, Object> params,
			Map<String, String> operator) throws ServiceException {
		PageBean<EmployeeDto> pageBean = new PageBean<EmployeeDto>();

		List<EmployeeDto> list = employeeDaoI.selEmployeeByPage(currentPage, ConstVal.PAGE_SIZE, params, operator);// 获取每一页的内容

		// selTotalRecord()获取总条数
		int totalCount = employeeDaoI.selTotalRecord(params, operator);

		// 总页数
		int totalPage = (int) Math.ceil((double) totalCount / ConstVal.PAGE_SIZE);
		pageBean.setCurrentPage(currentPage);
		pageBean.setList(list);
		pageBean.setPageSize(ConstVal.PAGE_SIZE);
		pageBean.setTotalCount(totalCount);
		pageBean.setTotalPage(totalPage);

		System.out.println(pageBean);
		return pageBean;
	}

	@Override
	public EmployeeDto queryEmployeeById(Integer employee_id) throws ServiceException {

		List<EmployeeDto> list = employeeDaoI.selEmployeeById(employee_id);
		return list.size() > 0 ? list.get(0) : null;

	}

	@Override
	public void addEmployee(EmployeeDto employeeDto) throws ServiceException {
		Long employeeKey = employeeDaoI.insEmployee(employeeDto);
		loginDaoI.insLogin(employeeKey);

	}

	@Override
	public void deleteEmployee(Integer menu_id) throws ServiceException {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateEmployee(EmployeeDto employeeDto) throws ServiceException {
		employeeDaoI.updEmployee(employeeDto);
	}

	@Override
	public void updateEmployeeStatus(Integer employee_id, String status) throws ServiceException {
		employeeDaoI.updateEmployeeStatus(employee_id, status);

	}

	@Override
	public List<EmployeeDto> queryEmployeeByPositionId(Integer position_id) throws ServiceException {
		List<EmployeeDto> list = employeeDaoI.selEmployeeByPositionId(position_id);
		return list;
	}

}
