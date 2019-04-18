package net.wanho.service;

import java.util.List;
import java.util.Map;

import net.wanho.entity.Position;
import net.wanho.exception.DaoException;
import net.wanho.exception.ServiceException;
import net.wanho.util.PageBean;

public interface PositionServiceI {

	List<Position> queryAllPosition() throws DaoException;

	PageBean<Position> pageFindPosition(int currentPage, Map<String, Object> params, Map<String, String> operator) throws ServiceException;

	Position queryPositionById(Integer position_id) throws ServiceException;

	void addPosition(Position position) throws ServiceException;
	
	void updatePosition(Position position) throws ServiceException;
	
	void delPositionById(Integer position_id) throws ServiceException;
	
	boolean isExistPositionName(String position_name) throws ServiceException;
}
