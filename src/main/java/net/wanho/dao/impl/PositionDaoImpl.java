package net.wanho.dao.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import net.wanho.dao.PositionDaoI;
import net.wanho.dto.Position_Menu_RelationsDto;
import net.wanho.entity.Position;
import net.wanho.entity.mapper.PositionMapper;
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
public class PositionDaoImpl implements PositionDaoI {
	// 通过工厂产生对象
	/*JDBCTemplate jt = (JDBCTemplate) ObjectFactory.getObject("jdbcTemplate");
	PositionMapper rm = new PositionMapper();
*/
	@Autowired
	private JdbcTemplate jt;
	private RowMapper<Position> rm= BeanPropertyRowMapper.newInstance(Position.class);


	@Override
	public List<Position> selAllPosition() throws DaoException {
		List<Position> list = null;
		StringBuilder sql = new StringBuilder();
		sql.append(" select * from emm_position ");
		list = jt.query(sql.toString(), rm);
		return list;
	}

	@Override
	public List<Position> selPositionByPage(int currentPage, int pageSize, Map<String, Object> params,
			Map<String, String> operator) throws DaoException {
		List<Position> list = null;
		ArrayList<Object> arrayParam = new ArrayList<>();
		StringBuilder sql = new StringBuilder();
		sql.append(" select * from  emm_position ");
		// 获取所有的?的值
		if (params != null && !params.isEmpty() && operator != null && !operator.isEmpty()
				&& params.size() == operator.size()) {
			sql.append(" where ");
			for (String key : params.keySet()) {
				sql.append(" " + key + " " + operator.get(key) + " ?  and");
				arrayParam.add(params.get(key));
			}

			sql.delete(sql.length() - 3, sql.length());
		}
		
		arrayParam.add((currentPage - 1) * pageSize);

		arrayParam.add(pageSize);

		sql.append(" order by POSITION_ID limit ?,?  ");

		Object[] param = (Object[]) arrayParam.toArray(new Object[arrayParam.size()]);

		list = jt.query(sql.toString(), rm, param);

		return list;
	}

	@Override
	public int selTotalRecord(Map<String, Object> params, Map<String, String> operator) throws DaoException {
		int count = 0;
		ArrayList<Object> arrayParam = new ArrayList<>();
		StringBuilder sql = new StringBuilder();
		sql.append(" select count(*) from  emm_position ");
		// 获取所有的?的值
		if (params != null && !params.isEmpty()) {
			sql.append(" where ");
			for (String key : params.keySet()) {
				sql.append(" " + key + " " + operator.get(key) + " ?  and");
				arrayParam.add(params.get(key));
			}

			sql.delete(sql.length() - 3, sql.length());
		}

		sql.append(" order by POSITION_ID ");

		Object[] param = (Object[]) arrayParam.toArray(new Object[arrayParam.size()]);

		count = jt.queryForObject(sql.toString(), param,Integer.class);

		return count;
	}

	@Override
	public List<Position> selPositionById(Integer position_id) throws DaoException {
		List<Position> list = null;
		StringBuilder sql = new StringBuilder();
		Object[] params = { position_id };
		sql.append(" select * from  emm_position where  position_id = ? ");
		list = jt.query(sql.toString(), rm, params);
		return list;
	}

	@Override
	public void updPosition(Position position) throws DaoException {
		StringBuilder sql = new StringBuilder();
		sql.append(" update emm_position set POSITION_NAME=? ,POSITION_LEVEL=?,UPDATE_TIME=NOW() where POSITION_ID=? ");
		Object[] params = { position.getPosition_name(), position.getPosition_level(), position.getPosition_id() };
		jt.update(sql.toString(), params);
	}

	@Override
	public void insPosition(Position position) throws DaoException {
		StringBuilder sql = new StringBuilder();
		sql.append(
				" insert into emm_position (POSITION_NAME,POSITION_LEVEL,CREATE_TIME,UPDATE_TIME)  values (?,?,NOW(),NOW()) ");
		Object[] params = { position.getPosition_name(), position.getPosition_level()};
		jt.update(sql.toString(), params);
	}

	@Override
	public List<Position> selPositionByName(String position_name) throws DaoException {
		List<Position> list = null;
		StringBuilder sql = new StringBuilder();
		Object[] params = { position_name };
		sql.append(" select * from emm_position where POSITION_NAME=?");
		list = jt.query(sql.toString(), rm, params);
		return list;
	}

	@Override
	public void delPosition(Integer position_id) throws DaoException {
		StringBuilder sql = new StringBuilder();
		sql.append(" delete from   emm_position  where POSITION_ID=? ");
		Object[] params = {  position_id };
		jt.update(sql.toString(), params);
	}

}
