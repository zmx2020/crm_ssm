package net.wanho.entity.mapper;

import java.sql.ResultSet;

public interface RowMapper<T> {
	
	public T mapRow(ResultSet rs) throws Exception;

}
