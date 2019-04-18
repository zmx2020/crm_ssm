package net.wanho.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import net.wanho.dao.EmployeeDaoI;
import net.wanho.dto.EmployeeDto;
import net.wanho.dto.mapper.EmployeeDtoMapper;
import net.wanho.exception.DaoException;
import net.wanho.factory.ObjectFactory;
import net.wanho.util.DataAccessException;
/*import net.wanho.util.JDBCTemplate;*/
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

@Repository
public class EmployeeDaoImpl implements EmployeeDaoI {
    // 通过工厂产生对象
    //JDBCTemplate jt = (JDBCTemplate) ObjectFactory.getObject("jdbcTemplate");
    @Autowired
    private JdbcTemplate jt;

    //EmployeeDtoMapper rm = new EmployeeDtoMapper();
    private RowMapper<EmployeeDto> rm = BeanPropertyRowMapper.newInstance(EmployeeDto.class);


    @Override
    public List<EmployeeDto> selEmployeeByPage(int currentPage, int pageSize, Map<String, Object> params,
                                               Map<String, String> operator) throws DaoException {
        List<EmployeeDto> list = null;
        ArrayList<Object> arrayParam = new ArrayList<>();
        StringBuilder sql = new StringBuilder();
        sql.append(" select * from (").append(" select  employee.*,  ").append(
                " PARENT_EMPLOYEE.EMPLOYEE_NAME as PARENT_EMPLOYEE_NAME, department.DEPARTMENT_NAME, emm_position.POSITION_NAME ")
                .append(" from   employee ")
                .append(" LEFT JOIN employee as PARENT_EMPLOYEE on  employee.PARENT_EMPLOYEE_ID =PARENT_EMPLOYEE.employee_id ")
                .append(" LEFT JOIN department on  employee.DEPARTMENT_ID =department.DEPARTMENT_ID  ")
                .append(" LEFT JOIN emm_position on  employee.POSITION_ID =emm_position.POSITION_ID ")
                .append(" ) AS employee ");
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

        sql.append(" order by EMPLOYEE_ID limit ?,?  ");

        Object[] param = (Object[]) arrayParam.toArray(new Object[arrayParam.size()]);

        list = jt.query(sql.toString(), rm, param);

        return list;
    }

    @Override
    public int selTotalRecord(Map<String, Object> params, Map<String, String> operator) {

        int count = 0;
        ArrayList<Object> arrayParam = new ArrayList<>();
        StringBuilder sql = new StringBuilder();
        sql.append(" select count(*)  from (").append(" select  employee.*,  ").append(
                " PARENT_EMPLOYEE.EMPLOYEE_NAME as PARENT_EMPLOYEE_NAME, department.DEPARTMENT_NAME, emm_position.POSITION_NAME ")
                .append(" from   employee ")
                .append(" LEFT JOIN employee as PARENT_EMPLOYEE on  employee.PARENT_EMPLOYEE_ID =PARENT_EMPLOYEE.employee_id ")
                .append(" LEFT JOIN department on  employee.DEPARTMENT_ID =department.DEPARTMENT_ID  ")
                .append(" LEFT JOIN emm_position on  employee.POSITION_ID =emm_position.POSITION_ID ")
                .append(" ) AS employee ");
        // 获取所有的?的值
        if (params != null && !params.isEmpty()) {
            sql.append(" where ");
            for (String key : params.keySet()) {
                sql.append(" " + key + " " + operator.get(key) + " ?  and");
                arrayParam.add(params.get(key));
            }

            sql.delete(sql.length() - 3, sql.length());
        }

        sql.append(" order by EMPLOYEE_ID ");

        Object[] param = (Object[]) arrayParam.toArray(new Object[arrayParam.size()]);

        //count = jt.countQuery(sql.toString(), param);

        count = jt.queryForObject(sql.toString(), param,Integer.class);

        return count;
    }

    @Override
    public List<EmployeeDto> selEmployeeById(Integer employee_id) throws DaoException {
        List<EmployeeDto> list = null;
        StringBuilder sql = new StringBuilder();
        Object[] params = {employee_id};
        sql.append(" select * from (").append(" select  employee.*,  ").append(
                " PARENT_EMPLOYEE.EMPLOYEE_NAME as PARENT_EMPLOYEE_NAME, department.DEPARTMENT_NAME, emm_position.POSITION_NAME ")
                .append(" from   employee ")
                .append(" LEFT JOIN employee as PARENT_EMPLOYEE on  employee.PARENT_EMPLOYEE_ID =PARENT_EMPLOYEE.employee_id ")
                .append(" LEFT JOIN department on  employee.DEPARTMENT_ID =department.DEPARTMENT_ID  ")
                .append(" LEFT JOIN emm_position on  employee.POSITION_ID =emm_position.POSITION_ID ")
                .append(" ) AS employee where  employee_id = ?");
        list = jt.query(sql.toString(), rm, params);
        return list;
    }

    @Override
    public List<EmployeeDto> selEmployeeByEmail(String email) throws DaoException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<EmployeeDto> selEmployeeByPhone(String phone) throws DaoException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Long insEmployee(EmployeeDto menu) throws DaoException {
        final StringBuilder sql = new StringBuilder();
        sql.append(
                " insert into employee (EMPLOYEE_NAME,DEPARTMENT_ID,POSITION_ID,PHONE,EMAIL, STATUS,PARENT_EMPLOYEE_ID,CREATE_TIME,UPDATE_TIME)  values (?,?,?,?,?,'0',?,NOW(),NOW()) ");
        final Object[] params = {menu.getEmployee_name(), menu.getDepartment_id(), menu.getPosition_id(), menu.getPhone(),
                menu.getEmail(), menu.getParent_employee_id()};

        //return (Long) jt.update(sql.toString(), params);

        KeyHolder keyHolder = new GeneratedKeyHolder();
        jt.update(new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(Connection conn) throws SQLException {
                PreparedStatement ps = conn.prepareStatement(sql.toString(), Statement.RETURN_GENERATED_KEYS);
                ps.setString(1, (String) params[0]);
                ps.setInt(2, (Integer) params[1]);
                ps.setInt(3, (Integer) params[2]);
                ps.setString(4, (String) params[3]);
                ps.setString(5, (String) params[4]);
                ps.setInt(6, (Integer) params[5]);
                return ps;
            }
        }, keyHolder);
        return keyHolder.getKey().longValue();

    }

    @Override
    public void updEmployee(EmployeeDto employeeDto) throws DaoException {
        StringBuilder sql = new StringBuilder();
        sql.append(
                " update employee set EMPLOYEE_NAME=? ,DEPARTMENT_ID=?,POSITION_ID=?,PHONE=?,EMAIL=?, PARENT_EMPLOYEE_ID=?, UPDATE_TIME=NOW() where EMPLOYEE_ID=? ");
        Object[] params = {employeeDto.getEmployee_name(), employeeDto.getDepartment_id(),
                employeeDto.getPosition_id(), employeeDto.getPhone(), employeeDto.getEmail(),
                employeeDto.getParent_employee_id(), employeeDto.getEmployee_id()};
        jt.update(sql.toString(), params);

    }

    @Override
    public void updateEmployeeStatus(Integer employee_id, String status) throws DaoException {
        StringBuilder sql = new StringBuilder();
        sql.append(" update employee set STATUS=? , UPDATE_TIME=NOW() where EMPLOYEE_ID=? ");
        Object[] params = {status, employee_id};
        jt.update(sql.toString(), params);

    }

    @Override
    public List<EmployeeDto> selEmployeeByPositionId(Integer position_id) throws DaoException {
        List<EmployeeDto> list = null;
        StringBuilder sql = new StringBuilder();
        Object[] params = {position_id};
        sql.append(" select * from (").append(" select  employee.*,  ").append(
                " PARENT_EMPLOYEE.EMPLOYEE_NAME as PARENT_EMPLOYEE_NAME, department.DEPARTMENT_NAME, emm_position.POSITION_NAME ")
                .append(" from   employee ")
                .append(" LEFT JOIN employee as PARENT_EMPLOYEE on  employee.PARENT_EMPLOYEE_ID =PARENT_EMPLOYEE.employee_id ")
                .append(" LEFT JOIN department on  employee.DEPARTMENT_ID =department.DEPARTMENT_ID  ")
                .append(" LEFT JOIN emm_position on  employee.POSITION_ID =emm_position.POSITION_ID ")
                .append(" ) AS employee where  POSITION_ID = ?");
        list = jt.query(sql.toString(), rm, position_id);
        return list;
    }

}
