package com.wkk.aop.aop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author kongweikun@163.com
 * @date 2023/3/24
 */
@SpringBootApplication
public class Application implements CommandLineRunner {

    @Autowired
    private OrderService orderService;

    public static void main(String[] args) {
        new SpringApplication(Application.class).run(args);
    }

    @Override
    public void run(String... args) throws Exception {
        SaveOrder saveOrder = new SaveOrder();
        saveOrder.setId(1L);
        orderService.saveOrder(saveOrder);

        UpdateOrder updateOrder = new UpdateOrder();
        updateOrder.setOrderId(2L);
        orderService.updateOrder(updateOrder);
    }
}
