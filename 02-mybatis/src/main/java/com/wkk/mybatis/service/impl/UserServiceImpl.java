package com.wkk.mybatis.service.impl;

import com.wkk.mybatis.dao.UserDao;
import com.wkk.mybatis.pojo.User;
import com.wkk.mybatis.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Time: 20-3-9下午6:36
 * @Author: kongwiki
 * @Email: kongwiki@163.com
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;
    @Override
    public User findUserById(long id) {
        return userDao.findById(id);
    }
}
