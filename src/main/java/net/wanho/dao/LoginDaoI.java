package net.wanho.dao;

import java.util.List;

import net.wanho.dto.LoginDto;
import net.wanho.exception.DaoException;

public interface LoginDaoI {
	List<LoginDto> selectbyEmpidAndPwd(String employeeId, String password) throws DaoException;
	void updatePassword(String employeeId, String password)throws DaoException;
	void insLogin(Long employee_id)throws DaoException;
	
}
