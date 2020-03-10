package com.wkk.druid.service.impl;

import com.wkk.druid.dao.UserDao;
import com.wkk.druid.pojo.User;
import com.wkk.druid.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Time: 20-3-10下午12:17
 * @Author: kongwiki
 * @Email: kongwiki@163.com
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;
    @Override
    public User findById(Long id) {
        return userDao.findById(id);
    }
}
