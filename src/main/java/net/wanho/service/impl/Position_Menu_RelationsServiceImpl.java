package net.wanho.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import net.wanho.dao.MenuDaoI;
import net.wanho.dao.PositionDaoI;
import net.wanho.dao.Position_Menu_RelationsDaoI;
import net.wanho.dto.ListMenuDto;
import net.wanho.dto.Position_Menu_RelationsDto;
import net.wanho.exception.ServiceException;
import net.wanho.factory.ObjectFactory;
import net.wanho.service.Position_Menu_RelationsServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Position_Menu_RelationsServiceImpl implements Position_Menu_RelationsServiceI {

	//Position_Menu_RelationsDaoI position_Menu_RelationsDaoI = (Position_Menu_RelationsDaoI) ObjectFactory.getObject("position_Menu_RelationsDaoI");
	//MenuDaoI menuDaoI = (MenuDaoI) ObjectFactory.getObject("menuDaoI");
	//PositionDaoI positionDaoI = (PositionDaoI) ObjectFactory.getObject("positionDaoI");
	@Autowired
	private Position_Menu_RelationsDaoI position_Menu_RelationsDaoI;
	@Autowired
	private MenuDaoI menuDaoI;
	@Autowired
	private PositionDaoI positionDaoI;

	@Override
	public List<Position_Menu_RelationsDto> queryPositionMenuRelationsByPositionId(Integer position_id)
			throws ServiceException {
		List<Position_Menu_RelationsDto> list = position_Menu_RelationsDaoI.selPositionMenuRelationsByPositionId(position_id);
		return list;
	}

	@Override
	public void addPosition(Position_Menu_RelationsDto relationsDto) throws ServiceException {
		position_Menu_RelationsDaoI.insPosition(relationsDto);
	}
	
	@Override
	public void updPositionMenuRelations(Integer[] arrayMenus, Integer position_id) throws ServiceException {
		position_Menu_RelationsDaoI.delPositionMenuRelations(position_id);
		for(int i=0;i<arrayMenus.length;i++) {
			Position_Menu_RelationsDto temp =new Position_Menu_RelationsDto();
			temp.setPosition_id(position_id);
			temp.setMenu_id(arrayMenus[i]);
			position_Menu_RelationsDaoI.insPosition(temp);
		}
	}

	@Override
	public List<Position_Menu_RelationsDto> queryPositionMenuRelationsByMenuId(Integer menu_id)
			throws ServiceException {
		List<Position_Menu_RelationsDto> list = position_Menu_RelationsDaoI.selPositionMenuRelationsByMenuId(menu_id);
		return list;
	}

	@Override
	public List<ListMenuDto> queryLimits(Integer position_id) throws ServiceException {
		List<ListMenuDto> list = new ArrayList();
		List<Position_Menu_RelationsDto> parentMenus=null;
		List<Position_Menu_RelationsDto> children=null;
		parentMenus=position_Menu_RelationsDaoI.selParentMenuByPositionId(position_id);
		for(Position_Menu_RelationsDto temp:parentMenus ) {
			ListMenuDto listMenuDto =new ListMenuDto(); 
			listMenuDto.setMenu_id(temp.getMenu_id());
			listMenuDto.setMenu_name(temp.getMenu_name());
			listMenuDto.setMenu_url(temp.getMenu_url());
			listMenuDto.setPictures(temp.getPictures());
			listMenuDto.setStatus(temp.getStatus());
			children=position_Menu_RelationsDaoI.selChildrenMenuByPositionId(position_id, temp.getMenu_id());
			listMenuDto.setChildern(children);
			list.add(listMenuDto);
		}
		return list;
	}
	@Test
	public void Teest() {
		Position_Menu_RelationsServiceI position_Menu_RelationsServiceI = (Position_Menu_RelationsServiceI) ObjectFactory.getObject("position_Menu_RelationsServiceI");
		 try {
			List<ListMenuDto> sss= position_Menu_RelationsServiceI.queryLimits(14);
			for(ListMenuDto temp :sss) {
				System.out.println(temp.getMenu_id());
				System.out.println(temp.getMenu_name());
				System.out.println(temp.getMenu_url());
				System.out.println(temp.getPictures());
				System.out.println(temp.getStatus());
				for(Position_Menu_RelationsDto ctemp: temp.getChildern()) {
					System.out.println(ctemp.getMenu_name());
					System.out.println(ctemp.getMenu_url());
					System.out.println(ctemp.getParent_menu_id());
				}
				
			}
		} catch (ServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
