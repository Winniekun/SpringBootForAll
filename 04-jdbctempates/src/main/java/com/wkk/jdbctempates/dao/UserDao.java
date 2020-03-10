package com.wkk.jdbctempates.dao;

import com.wkk.jdbctempates.pojo.User;
import org.springframework.stereotype.Component;

/**
 * @Time: 20-3-10下午2:22
 * @Author: kongwiki
 * @Email: kongwiki@163.com
 */
@Component
public interface UserDao {
    public User fingUserById(long id);
}
