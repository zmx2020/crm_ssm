package net.wanho.service;

import java.util.List;

import net.wanho.dto.LoginDto;
import net.wanho.exception.ServiceException;

public interface LoginServiceI {

	List<LoginDto> getUser(String employeeId, String password)throws ServiceException;
	void updatePassword(String employeeId, String newpassword) throws ServiceException;
}
