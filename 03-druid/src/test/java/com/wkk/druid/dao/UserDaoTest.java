package com.wkk.druid.dao;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @Time: 20-3-10上午11:45
 * @Author: kongwiki
 * @Email: kongwiki@163.com
 */
@SpringBootTest
class UserDaoTest {
    @Autowired
    private UserDao userDao;

    @Test
    void findById() {
        System.out.println(userDao.findById(1L).getUsername());
    }
}
