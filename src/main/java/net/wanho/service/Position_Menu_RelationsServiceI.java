package net.wanho.service;

import java.util.List;

import net.wanho.dto.ListMenuDto;
import net.wanho.dto.Position_Menu_RelationsDto;
import net.wanho.exception.ServiceException;

public interface Position_Menu_RelationsServiceI {

	List<Position_Menu_RelationsDto> queryPositionMenuRelationsByPositionId(Integer position_id) throws ServiceException;
	
	void updPositionMenuRelations(Integer[] arrayMenus, Integer position_id) throws ServiceException;
	
	void addPosition(Position_Menu_RelationsDto relationsDto) throws ServiceException;
	
	List<Position_Menu_RelationsDto> queryPositionMenuRelationsByMenuId(Integer menu_id) throws ServiceException;
	
	List<ListMenuDto> queryLimits(Integer position_id) throws ServiceException;
}
