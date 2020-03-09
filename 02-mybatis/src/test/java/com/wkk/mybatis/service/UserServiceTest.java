package com.wkk.mybatis.service;

import com.wkk.mybatis.dao.UserDao;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @Time: 20-3-9下午6:38
 * @Author: kongwiki
 * @Email: kongwiki@163.com
 */
@SpringBootTest
class UserServiceTest {
    @Autowired
    private UserService userService;

    @Test
    void findUserById() {
        long id = 1;
        System.out.println("username: "+userService.findUserById(id).getUsername());
    }
}
