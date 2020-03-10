package com.wkk.aop.dao.impl;

import com.sun.javafx.fxml.BeanAdapter;
import com.wkk.aop.dao.SysLogDao;
import com.wkk.aop.pojo.SysLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

/**
 * @Time: 20-3-10下午4:29
 * @Author: kongwiki
 * @Email: kongwiki@163.com
 */
@Component
public class SysLogDaoImpl implements SysLogDao {
    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public void saveSysLog(SysLog log) {
        StringBuffer sql = new StringBuffer("insert into SYS_LOG");
        sql.append("(username,operation,time,method,params,ip,create_time) ");
        sql.append("values(:username,:operation,:time,:method,");
        sql.append(":params,:ip,:createTime)");
        NamedParameterJdbcTemplate template = new NamedParameterJdbcTemplate(this.jdbcTemplate.getDataSource());
        template.update(sql.toString(), new BeanPropertySqlParameterSource(log));

    }
}
