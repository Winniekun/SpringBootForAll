package com.example.springzk;

import org.I0Itec.zkclient.ZkClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * 类描述：TODO
 *
 * @author kongweikun <kongweikun@baidu.com>
 * @date 2024/4/28
 */
@Component
public class ZkClientServer {

    @Value(value = "${zk.address:localhost:2181}")
    private String address;

    public ZkClient getZkClient() {
        return new ZkClient(address);
    }
}
