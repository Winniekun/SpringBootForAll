package com.wkk.druid.dao;

import com.wkk.druid.pojo.User;

/**
 * @Time: 20-3-10上午11:30
 * @Author: kongwiki
 * @Email: kongwiki@163.com
 */
public interface UserDao {
    User findById(long id);
}
