package net.wanho.dao.impl;


import net.wanho.dao.MenuDaoI;
import net.wanho.dto.MenuDto;
import net.wanho.entity.Menu;
import net.wanho.exception.DaoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/*import net.wanho.entity.mapper.RowMapper;*/
/*import net.wanho.util.JDBCTemplate;*/

@Repository
public class MenuDaoImpl implements MenuDaoI {
	// 通过工厂产生对象
	//JDBCTemplate jt = (JDBCTemplate) ObjectFactory.getObject("jdbcTemplate");
	//MenuDtoMapper nemuDtoRM = new MenuDtoMapper();
	//MenuMapper menuRM = new MenuMapper();

	@Autowired
	private JdbcTemplate jt;

	private RowMapper<MenuDto> nemuDtoRM= BeanPropertyRowMapper.newInstance(MenuDto.class);
	private RowMapper<Menu> menuRM= BeanPropertyRowMapper.newInstance(Menu.class);

	@Override
	public List<MenuDto> selMenuByPage(int currentPage, int pageSize, Map<String, Object> params,Map<String, String> operator) throws DaoException {
		List<MenuDto> list = null;
		ArrayList<Object> arrayParam = new ArrayList<>();
		StringBuilder sql = new StringBuilder();
		sql.append(" select * from (").append(
				" select  menu.*,parentMenu.MENU_NAME as PARENT_MENU_NAME from menu  LEFT JOIN menu as parentMenu on menu.PARENT_MENU_ID=parentMenu.MENU_ID ")
				.append(" ) AS menu ");
		// 获取所有的?的值
		if (params != null && !params.isEmpty()) {
			sql.append(" where ");
			for (String key : params.keySet()) {
				sql.append(" " + key +" " + operator.get(key)+" ?  and");
				arrayParam.add(params.get(key));
			}

			sql.delete(sql.length() - 3, sql.length());
		}

		arrayParam.add((currentPage - 1) * pageSize);

		arrayParam.add(pageSize);

		sql.append(" order by PARENT_MENU_ID limit ?,?  ");

		Object[] param = (Object[]) arrayParam.toArray(new Object[arrayParam.size()]);

		list = jt.query(sql.toString(), nemuDtoRM, param);

		return list;
	}

	@Override
	public List<MenuDto> selMenuByMenuId(Integer menu_id) throws DaoException {
		List<MenuDto> list = null;
		StringBuilder sql = new StringBuilder();
		sql.append(" select * from (").append(
				" select  menu.*,parentMenu.MENU_NAME as PARENT_MENU_NAME from menu  LEFT JOIN menu as parentMenu on menu.PARENT_MENU_ID=parentMenu.MENU_ID ")
				.append(" ) AS menu  where  menu_id=? ");
		list = jt.query(sql.toString(), nemuDtoRM, menu_id);
		return list;
	}

	@Override
	public void insMenu(Menu menu) throws DaoException {
		StringBuilder sql = new StringBuilder();
		sql.append(
				" insert into menu (MENU_NAME,MENU_URL,PICTURES,STATUS,CREATE_TIME,UPDATE_TIME,PARENT_MENU_ID)  values (?,?,?,?,NOW(),NOW(),?) ");
		Object[] params = { menu.getMenu_name(), menu.getMenu_url(), menu.getPictures(), menu.getStatus(),
				menu.getParent_menu_id() };
		jt.update(sql.toString(), params);
	}

	@Override
	public void updMenu(Menu menu) throws DaoException {
		StringBuilder sql = new StringBuilder();
		sql.append(
				" update menu set MENU_NAME=?, MENU_URL=?,PICTURES=?,STATUS=?,PARENT_MENU_ID=?,UPDATE_TIME=NOW() where MENU_ID=? ");
		Object[] params = { menu.getMenu_name(), menu.getMenu_url(), menu.getPictures(), menu.getStatus(),
				menu.getParent_menu_id() };
		jt.update(sql.toString(), params);
	}

	@Override
	public int selTotalRecord(Map<String, Object> params, Map<String, String> operator) {

		int count = 0;
		ArrayList<Object> arrayParam = new ArrayList<>();
		StringBuilder sql = new StringBuilder();
		sql.append(" select count(*) from (").append(
				" select  menu.*,parentMenu.MENU_NAME as PARENT_MENU_NAME from menu  LEFT JOIN menu as parentMenu on menu.PARENT_MENU_ID=parentMenu.MENU_ID ")
				.append(" ) AS menu ");
		// 获取所有的?的值
		if (params != null && !params.isEmpty()) {
			sql.append(" where ");
			for (String key : params.keySet()) {
				sql.append(" " + key +" " + operator.get(key)+" ?  and");
				arrayParam.add(params.get(key));
			}

			sql.delete(sql.length() - 3, sql.length());
		}

		sql.append(" order by PARENT_MENU_ID ");

		Object[] param = (Object[]) arrayParam.toArray(new Object[arrayParam.size()]);

		//count = jt.countQuery(sql.toString(), param);
		count = jt.queryForObject(sql.toString(), param,Integer.class);

		return count;
	}

	@Override
	public List<Menu> selParentMenu() throws DaoException {
		List<Menu> list = null;
		StringBuilder sql = new StringBuilder();
		sql.append(" select * from menu where parent_menu_id is NULL");
		list = jt.query(sql.toString(), menuRM);
		return list;
	}

	@Override
	public List<Menu> selMenuByUrl(String menuUrl) throws DaoException {
		List<Menu> list = null;
		StringBuilder sql = new StringBuilder();
		Object[] params = { menuUrl };
		sql.append(" select * from menu where menu_url=?  and menu_url<> 'javascript:;' ");
		list = jt.query(sql.toString(), menuRM, params);
		return list;
	}

	@Override
	public List<Menu> selMenuByName(String menuName) throws DaoException {
		List<Menu> list = null;
		StringBuilder sql = new StringBuilder();
		Object[] params = { menuName };
		sql.append(" select * from menu where menu_name=?");
		list = jt.query(sql.toString(), menuRM, params);
		return list;
	}

	@Override
	public List<MenuDto> selAllMenu() throws DaoException {
		List<MenuDto> list = null;
		StringBuilder sql = new StringBuilder();
		sql.append(" select * from (").append(
				" select  menu.*,parentMenu.MENU_NAME as PARENT_MENU_NAME from menu  LEFT JOIN menu as parentMenu on menu.PARENT_MENU_ID=parentMenu.MENU_ID ")
				.append(" ) AS menu ");
		list = jt.query(sql.toString(), nemuDtoRM);
		return list;
	}

	@Override
	public void delMenu(Integer menu_id) throws DaoException {
		StringBuilder sql = new StringBuilder();
		sql.append( "delete  from menu where menu_id=?  ");
		Object[] params = { menu_id };
		jt.update(sql.toString(), params);
	}

}
