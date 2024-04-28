package com.wkk.circular.main;

import com.wkk.circular.demo.AppConfig;
import com.wkk.circular.demo.AuthorService;
import com.wkk.circular.demo.BookService;
import org.springframework.beans.BeansException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class CircularApplication {

    public static void main(String[] args) throws BeansException {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        applicationContext.setAllowCircularReferences(false);
        applicationContext.register(AppConfig.class);
        applicationContext.refresh();

        BookService bookService = (BookService) applicationContext.getBean("bookService");
        System.out.println(bookService.authorService);

        AuthorService authorService = (AuthorService) applicationContext.getBean("AuthorService");
        System.out.println(authorService);
    }

}
