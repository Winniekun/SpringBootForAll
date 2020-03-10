package com.wkk.druid.service;

import com.wkk.druid.pojo.User;

/**
 * @Time: 20-3-10下午12:16
 * @Author: kongwiki
 * @Email: kongwiki@163.com
 */
public interface UserService {
    User findById(Long id);
}
