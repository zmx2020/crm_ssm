package net.wanho.service;

import java.util.List;
import java.util.Map;

import net.wanho.dto.MenuDto;
import net.wanho.entity.Menu;
import net.wanho.exception.ServiceException;
import net.wanho.util.PageBean;

public interface MenuServiceI {

	PageBean<MenuDto> pageFindMenu(int currentPage, Map<String, Object> params, Map<String, String> operator) throws ServiceException;

	List<Menu> queryParentMenu() throws ServiceException;
	
	List<MenuDto> queryAllMenu() throws ServiceException;

	MenuDto queryMenuById(Integer menu_id) throws ServiceException;

	void deleteMenu(Integer menu_id) throws ServiceException;

	void updateMenu(Menu menu) throws ServiceException;

	boolean isExistMenuUrl(String menuUrl) throws ServiceException;

	boolean isExistMenuName(String menuName) throws ServiceException;

	void addMenu(Menu menu) throws ServiceException;

}
