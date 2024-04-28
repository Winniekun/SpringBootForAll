package com.wkk.mybatis.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;

/**
 * @Time: 20-3-9下午6:37
 * @Author: kongwiki
 * @Email: kongwiki@163.com
 */
@Slf4j
@Controller
public class IndexController {

    @Value("${user.name}")
    private String username;

    public String getName() {
        log.info("username: [{}]", username);
        return username;
    }
}
