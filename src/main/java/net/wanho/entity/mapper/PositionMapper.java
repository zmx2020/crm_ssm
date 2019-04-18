package net.wanho.entity.mapper;

import java.sql.ResultSet;

import net.wanho.entity.Position;


public class PositionMapper implements RowMapper<Position> {

	@Override
	public Position mapRow(ResultSet rs) throws Exception {
		return new Position(rs.getInt("POSITION_ID"),
				   rs.getString("POSITION_NAME"),
				   rs.getString("POSITION_LEVEL"),
				   rs.getTimestamp("CREATE_TIME"),
				   rs.getTimestamp("UPDATE_TIME"));
	}

}

