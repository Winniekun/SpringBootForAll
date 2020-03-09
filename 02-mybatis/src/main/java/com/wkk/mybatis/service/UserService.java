package com.wkk.mybatis.service;

import com.wkk.mybatis.pojo.User;

/**
 * @Time: 20-3-9下午6:35
 * @Author: kongwiki
 * @Email: kongwiki@163.com
 */
public interface UserService {
    User findUserById(long id);
}
