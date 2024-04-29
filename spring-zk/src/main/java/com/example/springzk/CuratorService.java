package com.example.springzk;

import org.apache.curator.RetryPolicy;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.apache.curator.retry.RetryForever;
import org.apache.curator.retry.RetryNTimes;
import org.apache.curator.retry.RetryOneTime;
import org.apache.curator.retry.RetryUntilElapsed;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * 类描述：TODO
 *
 * @author kongweikun <kongweikun@baidu.com>
 * @date 2024/4/28
 */
@Component
public class CuratorService {

    @Value(value = "${curator.connectString:localhost:2181}")
    private String connectString;

    @Value(value = "${curator.sessionTimeoutMs:500}")
    private int sessionTimeoutMs;

    @Value("${curator.namespace:kwk}")
    private String namespace;

    /**
     * session 重连策略，使用其中一种即可
     */
    // RetryForever：间隔{参数1}毫秒后重连，永远重试
    private RetryPolicy retryForever = new RetryForever(3000);

    // RetryOneTime：{参数1}毫秒后重连，只重连一次
    private RetryPolicy retryOneTime = new RetryOneTime(3000);

    // RetryNTimes： {参数2}毫秒后重连，重连{参数1}次
    private RetryPolicy retryNTimes = new RetryNTimes(3,3000);

    // RetryUntilElapsed：每{参数2}毫秒重连一次，总等待时间超过{参数1}毫秒后停止重连
    private RetryPolicy retryUntilElapsed = new RetryUntilElapsed(10000,3000);

    // ExponentialBackoffRetry：可重连{参数2}次，并增加每次重连之间的睡眠时间，增加公式如下：
    // {参数1} * Math.max(1,random.nextInt(1 << ({参数2：maxRetries} + 1)))
    private RetryPolicy exponential = new ExponentialBackoffRetry(1000,3);



    public CuratorFramework getCuratorFramework() {
        return CuratorFrameworkFactory.builder()
                .connectString(connectString)
                .sessionTimeoutMs(sessionTimeoutMs)
                .retryPolicy(retryOneTime)
                .namespace(namespace)
                .build();
    }


}
