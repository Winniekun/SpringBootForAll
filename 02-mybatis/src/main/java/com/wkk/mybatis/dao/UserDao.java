package com.wkk.mybatis.dao;

import com.wkk.mybatis.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

/**
 * @Time: 20-3-9下午6:25
 * @Author: kongwiki
 * @Email: kongwiki@163.com
 */
@Component
@Mapper
public interface UserDao {
    @Select("select * from user where id = #{id}")
    @Results(id="user", value = {
            @Result(property = "id", column = "id", javaType = Long.class),
            @Result(property = "usercode", column = "usercode", javaType = String.class),
            @Result(property = "username", column = "username", javaType = String.class),
            @Result(property = "password", column = "password", javaType = String.class),
            @Result(property = "salt", column = "salt", javaType = String.class),
            @Result(property = "locked", column = "locked", javaType = String.class)

    })
    User findById(long id);
}
