package com.wkk.circular.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

/**
 * TODO 类描述
 *
 * @author weikunkun
 * @since 2022/10/23
 */
@Service
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class AuthorService {
    @Autowired
    public BookService bookService;
}
