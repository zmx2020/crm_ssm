package net.wanho.service.impl;

import java.util.List;
import java.util.Map;

import net.wanho.consts.ConstVal;
import net.wanho.dao.MenuDaoI;
import net.wanho.dao.Position_Menu_RelationsDaoI;
import net.wanho.dto.MenuDto;
import net.wanho.entity.Menu;
import net.wanho.exception.ServiceException;
import net.wanho.factory.ObjectFactory;
import net.wanho.service.MenuServiceI;
import net.wanho.util.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MenuServiceImpl implements MenuServiceI {

	@Autowired
	private MenuDaoI menuDaoI;
	//MenuDaoI menuDaoI = (MenuDaoI) ObjectFactory.getObject("menuDaoI");

	@Override
	public PageBean<MenuDto> pageFindMenu(int currentPage, Map<String, Object> params, Map<String, String> operator)
			throws ServiceException {
		PageBean<MenuDto> pageBean = new PageBean<MenuDto>();

		List<MenuDto> list = menuDaoI.selMenuByPage(currentPage, ConstVal.PAGE_SIZE, params, operator);// 获取每一页的内容

		// selTotalRecord()获取总条数
		int totalCount = menuDaoI.selTotalRecord(params, operator);

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
	public MenuDto queryMenuById(Integer menu_id) throws ServiceException {
		List<MenuDto> list = menuDaoI.selMenuByMenuId(menu_id);
		return list.size() > 0 ? list.get(0) : null;
	}

	@Override
	public List<Menu> queryParentMenu() throws ServiceException {
		List<Menu> list = menuDaoI.selParentMenu();

		return list;
	}

	@Override
	public boolean isExistMenuUrl(String menuUrl) throws ServiceException {
		List<Menu> list = menuDaoI.selMenuByUrl(menuUrl);
		return list.size() > 0 ? true : false;
	}

	@Override
	public boolean isExistMenuName(String menuName) throws ServiceException {
		List<Menu> list = menuDaoI.selMenuByName(menuName);
		return list.size() > 0 ? true : false;
	}

	@Override
	public void addMenu(Menu menu) throws ServiceException {
		menuDaoI.insMenu(menu);
	}

	@Override
	public void deleteMenu(Integer menu_id) throws ServiceException {
		menuDaoI.delMenu(menu_id);
	}

	@Override
	public void updateMenu(Menu menu) throws ServiceException {
		// TODO Auto-generated method stub

	}

	@Override
	public List<MenuDto> queryAllMenu() throws ServiceException {
		List<MenuDto> list = menuDaoI.selAllMenu();
		return list;
	}

}
