package net.wanho.dto.mapper;

import java.sql.ResultSet;
import net.wanho.dto.MenuDto;
import net.wanho.entity.mapper.RowMapper;


public class MenuDtoMapper implements RowMapper<MenuDto> {

	@Override
	public MenuDto mapRow(ResultSet rs) throws Exception {
		return new MenuDto(rs.getInt("MENU_ID"),
				   rs.getString("MENU_NAME"),
				   rs.getString("MENU_URL"),
				   rs.getString("PICTURES"),
				   rs.getString("STATUS"),
				   rs.getTimestamp("CREATE_TIME"),
				   rs.getTimestamp("UPDATE_TIME"),
		           rs.getInt("PARENT_MENU_ID"),
		           rs.getString("PARENT_MENU_NAME"));
	}

}

