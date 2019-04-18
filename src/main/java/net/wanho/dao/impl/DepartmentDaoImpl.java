package net.wanho.dao.impl;


import java.util.List;


import net.wanho.dao.DepartmentDaoI;
import net.wanho.entity.Department;
import net.wanho.entity.mapper.DepartmentMapper;

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
public class DepartmentDaoImpl implements DepartmentDaoI {
    // 通过工厂产生对象
    //JDBCTemplate jt = (JDBCTemplate) ObjectFactory.getObject("jdbcTemplate");
    //DepartmentMapper rm = new DepartmentMapper();

    @Autowired
    private JdbcTemplate jt;
    private RowMapper<Department> rm = BeanPropertyRowMapper.newInstance(Department.class);

    @Override
    public List<Department> selAllDepartment() throws DaoException {
        List<Department> list = null;
        StringBuilder sql = new StringBuilder();
        sql.append(" select * from department ");
        list=jt.query(sql.toString(),rm);
        return list;
    }

}
