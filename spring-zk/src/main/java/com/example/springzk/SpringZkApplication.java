package com.example.springzk;

import org.I0Itec.zkclient.ZkClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.List;

@SpringBootApplication
public class SpringZkApplication {

    @Autowired
    private ZkClientServer zkClientServer;

    public static void main(String[] args) {
//        SpringApplication.run(SpringZkApplication.class, args);
        ConfigurableApplicationContext context = SpringApplication.run(SpringZkApplication.class, args);
        ZkClientServer bean = context.getBean(ZkClientServer.class);
        ZkClient zkClient = bean.getZkClient();
        List<String> children = zkClient.getChildren("/");
        children.stream().forEach(System.out::println);
        zkClient.close();
    }

}
