package net.wanho.dao.impl;

import java.util.List;

import net.wanho.dao.LoginDaoI;
import net.wanho.dto.LoginDto;

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
public class LoginDaoImpl implements LoginDaoI {
	//通过工厂产生对象
	//JDBCTemplate jt = (JDBCTemplate) ObjectFactory.getObject("jdbcTemplate");
	@Autowired
	private JdbcTemplate jt;
	//LoginMapper rm = new LoginMapper();
	private RowMapper<LoginDto> rm= BeanPropertyRowMapper.newInstance(LoginDto.class);
	/***
	 * 根据用户名及密码查询记录 参数 employeeId,password 返回List<LoginDto>
	 * 
	 * @throws DataAccessException
	 */
	@Override
	public List<LoginDto> selectbyEmpidAndPwd(String employeeId, String password) throws DaoException {

		List<LoginDto> list = null;

		Object[] params = { employeeId, password };

		String sql = " select  * from (SELECT log_in.USER_ID,log_in.EMM_PASSWORD,employee.* FROM "
				+ " log_in ,employee where  log_in.EMPLOYEE_ID=employee.EMPLOYEE_ID ) as LoginDto "
				+ " where LoginDto.EMPLOYEE_ID=? and LoginDto.EMM_PASSWORD=? ";

		list = jt.query(sql, rm, params);
		return list;
	}

	@Override
	public void updatePassword(String employeeId, String password) throws DaoException {

		Object[] params = { password,employeeId  };
		String sql = "update log_in set EMM_PASSWORD=? where EMPLOYEE_ID=?";
		jt.update(sql, params);

	}

	@Override
	public void insLogin(Long employee_id) throws DaoException {
		Object[] params = { employee_id };
		String sql = "insert into  log_in  set EMPLOYEE_ID=? ,EMM_PASSWORD='123456' ";
		jt.update(sql, params);
	}
}
