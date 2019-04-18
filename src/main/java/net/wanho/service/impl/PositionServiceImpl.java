package net.wanho.service.impl;

import java.util.List;
import java.util.Map;

import net.wanho.consts.ConstVal;
import net.wanho.dao.PositionDaoI;
import net.wanho.entity.Position;
import net.wanho.exception.DaoException;
import net.wanho.exception.ServiceException;
import net.wanho.factory.ObjectFactory;
import net.wanho.service.PositionServiceI;
import net.wanho.util.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PositionServiceImpl implements PositionServiceI {

	//PositionDaoI positionDaoI = (PositionDaoI) ObjectFactory.getObject("positionDaoI");
	@Autowired
	private PositionDaoI positionDaoI;
	@Override
	public List<Position> queryAllPosition() throws DaoException {
		List<Position> list = positionDaoI.selAllPosition();
		return list;
	}

	@Override
	public PageBean<Position> pageFindPosition(int currentPage, Map<String, Object> params,
			Map<String, String> operator) throws ServiceException {
		PageBean<Position> pageBean = new PageBean<Position>();

		List<Position> list = positionDaoI.selPositionByPage(currentPage, ConstVal.PAGE_SIZE, params, operator);// 获取每一页的内容

		// selTotalRecord()获取总条数
		int totalCount = positionDaoI.selTotalRecord(params, operator);

		// 总页数
		int totalPage = (int) Math.ceil((double) totalCount / ConstVal.PAGE_SIZE);
		pageBean.setCurrentPage(currentPage);
		pageBean.setList(list);
		pageBean.setPageSize(ConstVal.PAGE_SIZE);
		pageBean.setTotalCount(totalCount);
		pageBean.setTotalPage(totalPage);

		return pageBean;
	}

	@Override
	public Position queryPositionById(Integer position_id) throws ServiceException {
		List<Position> list = positionDaoI.selPositionById(position_id);
		return list.size() > 0 ? list.get(0) : null;
	}

	@Override
	public void addPosition(Position position) throws ServiceException {
		positionDaoI.insPosition(position);
	}

	@Override
	public void updatePosition(Position position) throws ServiceException {
		positionDaoI.updPosition(position);

	}

	@Override
	public boolean isExistPositionName(String position_name) throws ServiceException {
		List<Position> list = positionDaoI.selPositionByName(position_name);
		return list.size() > 0 ? true : false;
	}

	@Override
	public void delPositionById(Integer position_id) throws ServiceException {
		positionDaoI.delPosition(position_id);
	}

}
