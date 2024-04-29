package com.example.springsecurity.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * 类描述：TODO
 *
 * @author kongweikun <kongweikun@baidu.com>
 * @date 2024/4/28
 */
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                // 所有请求都需要认证
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/login.html")
                .loginProcessingUrl("/doLogin")
                .defaultSuccessUrl("/index")
                .failureUrl("/login.html")
                .usernameParameter("uname")
                .passwordParameter("password")
                .permitAll()
                .and()
                .csrf().disable();
    }
}
