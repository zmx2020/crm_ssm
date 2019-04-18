package net.wanho.mapper;

import net.wanho.dto.LoginDto;
import net.wanho.exception.DaoException;

import java.util.List;

public interface LoginMapper {
	List<LoginDto> selectbyEmpidAndPwd(String employeeId, String password) throws DaoException;
	void updatePassword(String employeeId, String password)throws DaoException;
	void insLogin(Long employee_id)throws DaoException;
	
}
