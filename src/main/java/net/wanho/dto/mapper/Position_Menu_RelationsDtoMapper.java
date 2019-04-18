package net.wanho.dto.mapper;

import java.sql.ResultSet;

import net.wanho.dto.Position_Menu_RelationsDto;
import net.wanho.entity.mapper.RowMapper;


public class Position_Menu_RelationsDtoMapper implements RowMapper<Position_Menu_RelationsDto> {

	@Override
	public Position_Menu_RelationsDto mapRow(ResultSet rs) throws Exception {
		return new Position_Menu_RelationsDto(rs.getInt("RELATION_ID"),
				   rs.getInt("POSITION_ID"),			   
				   rs.getString("POSITION_NAME"),
				   rs.getInt("MENU_ID"),
				   rs.getString("MENU_NAME"),
				   rs.getString("MENU_URL"),
				   rs.getString("PARENT_MENU_ID"),
				   rs.getString("PICTURES"),
				   rs.getString("STATUS"));
	}

}

