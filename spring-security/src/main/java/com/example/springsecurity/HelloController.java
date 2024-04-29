package com.example.springsecurity;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 类描述：TODO
 *
 * @author kongweikun <kongweikun@baidu.com>
 * @date 2024/4/28
 */
@RestController
public class HelloController {

    @GetMapping("/hello")
    public String hello() {
        return "hello spring security";
    }

    @GetMapping("/index")
    public String index() {
        return "login success";
    }
}
