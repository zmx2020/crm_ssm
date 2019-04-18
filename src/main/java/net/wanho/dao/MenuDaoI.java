package net.wanho.dao;

import java.util.List;
import java.util.Map;

import net.wanho.dto.MenuDto;
import net.wanho.entity.Menu;
import net.wanho.exception.DaoException;

public interface MenuDaoI {

	List<MenuDto> selMenuByPage(int currentPage, int pageSize, Map<String, Object> params, Map<String, String> operator) throws DaoException;

	List<MenuDto> selMenuByMenuId(Integer menu_id) throws DaoException;
	
	List<Menu> selParentMenu() throws DaoException;
	
	
	List<MenuDto> selAllMenu() throws DaoException;
	
	int selTotalRecord(Map<String, Object> params, Map<String, String> operator) throws DaoException;
	
	List<Menu>  selMenuByUrl(String menuUrl) throws DaoException;

	List<Menu> selMenuByName(String menuName) throws DaoException;
	
	void insMenu(Menu menu) throws DaoException;

	void updMenu(Menu menu) throws DaoException;
	
	void delMenu(Integer menu_id) throws DaoException;


}
