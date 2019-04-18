package net.wanho.entity.mapper;

import java.sql.ResultSet;

import net.wanho.entity.Menu;


public class MenuMapper implements RowMapper<Menu> {

	@Override
	public Menu mapRow(ResultSet rs) throws Exception {
		return new Menu(rs.getInt("MENU_ID"),
				   rs.getString("MENU_NAME"),
				   rs.getString("MENU_URL"),
				   rs.getString("PICTURES"),
				   rs.getString("STATUS"),
				   rs.getTimestamp("CREATE_TIME"),
				   rs.getTimestamp("UPDATE_TIME"),
		           rs.getInt("PARENT_MENU_ID"));
	}

}

