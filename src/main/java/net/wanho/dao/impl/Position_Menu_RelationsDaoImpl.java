package net.wanho.dao.impl;

import java.util.List;

import net.wanho.dao.Position_Menu_RelationsDaoI;
import net.wanho.dto.MenuDto;
import net.wanho.dto.Position_Menu_RelationsDto;
import net.wanho.dto.mapper.Position_Menu_RelationsDtoMapper;
import net.wanho.entity.Menu;
import net.wanho.exception.DaoException;
import net.wanho.factory.ObjectFactory;
import net.wanho.util.DataAccessException;
/*import net.wanho.util.JDBCTemplate;*/
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class Position_Menu_RelationsDaoImpl implements Position_Menu_RelationsDaoI {
	// 通过工厂产生对象
	/*JDBCTemplate jt = (JDBCTemplate) ObjectFactory.getObject("jdbcTemplate");
	Position_Menu_RelationsDtoMapper rm = new Position_Menu_RelationsDtoMapper();
*/
	@Autowired
	private JdbcTemplate jt;
	private RowMapper<Position_Menu_RelationsDto> rm= BeanPropertyRowMapper.newInstance(Position_Menu_RelationsDto.class);

	@Override
	public List<Position_Menu_RelationsDto> selPositionMenuRelationsByPositionId(Integer position_id)
			throws DaoException {
		List<Position_Menu_RelationsDto> list = null;
		StringBuilder sql = new StringBuilder();
		Object[] params = { position_id };
		sql.append(
				" select * from ( select  position_menu_relations.*,emm_position.POSITION_NAME,menu.MENU_NAME,menu.MENU_URL,menu.PARENT_MENU_ID,menu.pictures,menu.status  from position_menu_relations ")
				.append(" left join emm_position on  position_menu_relations.POSITION_ID=emm_position.POSITION_ID ")
				.append(" left JOIN menu on position_menu_relations.MENU_ID=menu.MENU_ID ")
				.append("  order by emm_position.POSITION_NAME,MENU_ID ) as position_menu_relations "
						+ "where    position_menu_relations.POSITION_ID=?");
		list = jt.query(sql.toString(), rm, params);
		return list;
	}

	@Override
	public void insPosition(Position_Menu_RelationsDto relationsDto) throws DaoException {
		StringBuilder sql = new StringBuilder();
		sql.append("insert into  position_menu_relations ( POSITION_ID,MENU_ID) values(?,?)  ");
		Object[] params = { relationsDto.getPosition_id(), relationsDto.getMenu_id() };
		jt.update(sql.toString(), params);
	}

	@Override
	public void delPositionMenuRelations(Integer position_id) throws DaoException {

		StringBuilder sql = new StringBuilder();
		sql.append("delete from position_menu_relations where POSITION_ID=?  ");
		Object[] params = { position_id };
		jt.update(sql.toString(), params);

	}

	@Override
	public List<Position_Menu_RelationsDto> selPositionMenuRelationsByMenuId(Integer menu_id) throws DaoException {
		List<Position_Menu_RelationsDto> list = null;
		StringBuilder sql = new StringBuilder();
		Object[] params = { menu_id };
		sql.append(
				" select * from ( select  position_menu_relations.*,emm_position.POSITION_NAME,menu.MENU_NAME,menu.MENU_URL,menu.PARENT_MENU_ID,menu.pictures,menu.status  from position_menu_relations ")
				.append(" left join emm_position on  position_menu_relations.POSITION_ID=emm_position.POSITION_ID ")
				.append(" left JOIN menu on position_menu_relations.MENU_ID=menu.MENU_ID ")
				.append("  order by emm_position.POSITION_NAME,MENU_ID ) as position_menu_relations where  position_menu_relations.menu_ID=?");
		list = jt.query(sql.toString(), rm, params);
		return list;
	}

	@Override
	public List<Position_Menu_RelationsDto> selParentMenuByPositionId(Integer position_id) throws DaoException {
		List<Position_Menu_RelationsDto> list = null;
		StringBuilder sql = new StringBuilder();
		sql.append(
				" select * from ( select  position_menu_relations.*,emm_position.POSITION_NAME,menu.MENU_NAME,menu.MENU_URL,menu.PARENT_MENU_ID,menu.pictures,menu.status  from position_menu_relations ")
				.append(" left join emm_position on  position_menu_relations.POSITION_ID=emm_position.POSITION_ID ")
				.append(" left JOIN menu on position_menu_relations.MENU_ID=menu.MENU_ID ")
				.append(" order by emm_position.POSITION_NAME,MENU_ID ) as position_menu_relations where  position_menu_relations.POSITION_ID=?  ")
				.append(" and position_menu_relations.parent_menu_id is null ORDER BY   parent_menu_id ");
		Object[] params = { position_id };
		list = jt.query(sql.toString(), rm, params);
		return list;
	}

	@Override
	public List<Position_Menu_RelationsDto> selChildrenMenuByPositionId(Integer position_id, Integer parent_menu_id)
			throws DaoException {
		List<Position_Menu_RelationsDto> list = null;
		StringBuilder sql = new StringBuilder();
		sql.append(
				" select * from ( select  position_menu_relations.*,emm_position.POSITION_NAME,menu.MENU_NAME,menu.MENU_URL,menu.PARENT_MENU_ID,menu.pictures,menu.status  from position_menu_relations ")
				.append(" left join emm_position on  position_menu_relations.POSITION_ID=emm_position.POSITION_ID ")
				.append(" left JOIN menu on position_menu_relations.MENU_ID=menu.MENU_ID ")
				.append(" order by emm_position.POSITION_NAME,MENU_ID ) as position_menu_relations where   position_menu_relations.POSITION_ID=? ")
				.append(" and position_menu_relations.parent_menu_id =? ORDER BY   parent_menu_id ");
		Object[] params = { position_id ,parent_menu_id};
		list = jt.query(sql.toString(), rm, params);
		return list;
	}

}
