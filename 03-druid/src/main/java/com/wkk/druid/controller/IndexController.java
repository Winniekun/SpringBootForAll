package com.wkk.druid.controller;

import com.wkk.druid.pojo.User;
import com.wkk.druid.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Time: 20-3-10下午12:15
 * @Author: kongwiki
 * @Email: kongwiki@163.com
 */
@RestController
public class IndexController {
    @Autowired
    private UserService userService;
    @RequestMapping("/user")
    public User getUser(){
        return userService.findById(1L);
    }
}
