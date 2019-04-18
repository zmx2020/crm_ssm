package net.wanho.dao;

import java.util.List;

import net.wanho.dto.Position_Menu_RelationsDto;
import net.wanho.exception.DaoException;

public interface Position_Menu_RelationsDaoI {
	
	List<Position_Menu_RelationsDto> selPositionMenuRelationsByPositionId(Integer position_id) throws DaoException;
	
	/*void updPosition(Position position) throws DaoException;*/
	
	void insPosition(Position_Menu_RelationsDto relationsDto) throws DaoException;
	
	void delPositionMenuRelations(Integer position_id) throws DaoException;
	
	List<Position_Menu_RelationsDto> selPositionMenuRelationsByMenuId(Integer menu_id) throws DaoException;

	List<Position_Menu_RelationsDto> selParentMenuByPositionId(Integer position_id) throws DaoException;
	
	List<Position_Menu_RelationsDto> selChildrenMenuByPositionId(Integer position_id, Integer parent_menu_id) throws DaoException;
	
}
