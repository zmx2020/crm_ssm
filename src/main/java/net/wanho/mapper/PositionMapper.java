package net.wanho.mapper;

import net.wanho.entity.Position;
import net.wanho.exception.DaoException;

import java.util.List;
import java.util.Map;

public interface PositionMapper {

	List<Position> selAllPosition() throws DaoException;

	List<Position> selPositionByPage(int currentPage, int pageSize, Map<String, Object> params,
                                     Map<String, String> operator) throws DaoException;

	List<Position> selPositionById(Integer position_id) throws DaoException;

	int selTotalRecord(Map<String, Object> params, Map<String, String> operator) throws DaoException;

	void updPosition(Position position) throws DaoException;
	
	void insPosition(Position position) throws DaoException;

	void delPosition(Integer position_id) throws DaoException;
	
	List<Position> selPositionByName(String position_name) throws DaoException;
}
