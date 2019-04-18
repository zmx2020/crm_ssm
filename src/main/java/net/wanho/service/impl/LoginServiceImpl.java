package net.wanho.service.impl;

import java.util.List;

import net.wanho.dao.LoginDaoI;
import net.wanho.dto.LoginDto;
import net.wanho.exception.DaoException;
import net.wanho.exception.ServiceException;
import net.wanho.factory.ObjectFactory;
import net.wanho.service.LoginServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements LoginServiceI {


	//LoginDaoI loginDaoI = (LoginDaoI) ObjectFactory.getObject("loginDaoI");
	@Autowired
	private LoginDaoI loginDaoI;
	@Override
	public List<LoginDto> getUser(String employeeId, String password)
			throws ServiceException {
		List<LoginDto> lists = null;
		try {
			lists = loginDaoI.selectbyEmpidAndPwd(employeeId, password);
		} catch (DaoException e) {
			
			throw new DaoException("LoginServiceImpl调用Dao层selectbyEmpidAndPwd方法出现异常");
		}
		return lists;
	}

	@Override
	public void updatePassword(String employeeId, String newpassword)
			throws ServiceException {
		try {
			loginDaoI.updatePassword(employeeId, newpassword);
		} catch (DaoException e) {
			throw new DaoException("LoginServiceImpl调用Dao层updatePassword方法出现异常");
		}
		
	}

}
