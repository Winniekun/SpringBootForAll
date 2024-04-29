package com.example.springzk;

import org.I0Itec.zkclient.ZkClient;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class SpringZkApplicationTests {

    @Autowired
    private ZkClientServer zkClientServer;

    @Test
    void contextLoads() {
        ZkClient zkClient = zkClientServer.getZkClient();
        zkClient.createPersistent("/kwk/hanhuan");
        List<String> children = zkClient.getChildren("/kwk");
        children.forEach(System.out::println);
        zkClient.close();
    }

    @Test
    public void testDelete() {
        ZkClient zkClient = zkClientServer.getZkClient();
        zkClient.delete("/kwk/hanhuan");
        List<String> children = zkClient.getChildren("/kwk");
        children.forEach(System.out::println);
        zkClient.close();
    }

    @Test
    public void testRead() {
        ZkClient zkClient = zkClientServer.getZkClient();
        zkClient.writeData("/kwk/hanhuan", "pretty girl");
        Object data = zkClient.readData("/kwk/hanhuan");
        System.out.println(data);
        zkClient.close();
    }

}
