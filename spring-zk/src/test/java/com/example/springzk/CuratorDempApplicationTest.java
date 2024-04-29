package com.example.springzk;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.api.CuratorWatcher;
import org.apache.curator.framework.api.GetChildrenBuilder;
import org.apache.curator.framework.recipes.cache.CuratorCache;
import org.apache.curator.framework.recipes.cache.CuratorCacheListener;
import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.WatchedEvent;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

/**
 * 类描述：TODO
 *
 * @author kongweikun <kongweikun@baidu.com>
 * @date 2024/4/28
 */
@SpringBootTest
public class CuratorDempApplicationTest {

    @Autowired
    private CuratorService curatorService;

    @Test
    public void testNodeInfo() throws Exception {
        CuratorFramework curatorFramework = curatorService.getCuratorFramework();
        curatorFramework.start();
        String newNode = curatorFramework.create().forPath("/kwk", "newNode".getBytes());
        System.out.println(newNode);
        curatorFramework.close();
    }

    @Test
    public void testGetAllNode() throws Exception {
        CuratorFramework curatorFramework = curatorService.getCuratorFramework();
        curatorFramework.start();
        List<String> children = curatorFramework.getChildren().forPath("/");
        children.forEach(System.out::println);
        curatorFramework.close();
    }

    @Test
    public void testWatch() throws Exception {
        CuratorFramework curatorFramework = curatorService.getCuratorFramework();
        curatorFramework.start();
        CuratorWatcher curatorWatcher = watchedEvent -> System.out.println(watchedEvent.toString());
//        curatorFramework.create().forPath("/watch", "zookeeper watch feature".getBytes());
        byte[] bytes = curatorFramework.getData().usingWatcher(curatorWatcher).forPath("/watch");
        System.out.println(new String(bytes));
        curatorFramework.setData().forPath("/watch", "zookeeper watch feature 01".getBytes());
        curatorFramework.setData().forPath("/watch", "zookeeper watch feature 02".getBytes());
        curatorFramework.close();
    }

    @Test
    void testWatchLoop() throws Exception {
        // 获取客户端
        CuratorFramework client = curatorService.getCuratorFramework();
        // 开启会话
        client.start();
        // 构建 CuratorCache 实例
        CuratorCache cache = CuratorCache.build(client, "/mooc");
        // 使用 Fluent 风格和 lambda 表达式来构建 CuratorCacheListener 的事件监听
        CuratorCacheListener listener = CuratorCacheListener.builder()
                // 开启对所有事件的监听
                // type 事件类型：NODE_CREATED, NODE_CHANGED, NODE_DELETED;
                // oldNode 原节点：ChildData 类，包括节点路径，节点状态 Stat，节点 data
                // newNode 新节点：同上
                .forAll((type, oldNode, newNode) -> {
                    System.out.println("forAll 事件类型：" + type);
                    System.out.println("forAll 原节点：" + oldNode);
                    System.out.println("forAll 新节点：" + newNode);
                })
                // 开启对节点创建事件的监听
                .forCreates(childData -> {
                    System.out.println("forCreates 新节点：" + childData);
                })
                // 开启对节点更新事件的监听
                .forChanges((oldNode, newNode) -> {
                    System.out.println("forChanges 原节点：" + oldNode);
                    System.out.println("forChanges 新节点：" + newNode);
                })
                // 开启对节点删除事件的监听
                .forDeletes(oldNode -> {
                    System.out.println("forDeletes 原节点：" + oldNode);
                })
                // 初始化
                .forInitialized(() -> {
                    System.out.println("forInitialized 初始化");
                })
                // 构建
                .build();

        // 注册 CuratorCacheListener 到 CuratorCache
        cache.listenable().addListener(listener);
        // CuratorCache 开启缓存
        cache.start();
        // mooc 节点创建
        client.create().forPath("/mooc");
        // mooc 节点更新
        client.setData().forPath("/mooc","Wiki".getBytes());
        // mooc 节点删除
        client.delete().forPath("/mooc");
    }

    @Test
    public void testTemporarilyNode() throws Exception {
        CuratorFramework client = curatorService.getCuratorFramework();
        client.start();

        String node1 = client.create()
                .creatingParentsIfNeeded()
                .withMode(CreateMode.EPHEMERAL_SEQUENTIAL)
                .forPath("/wiki-");
        System.out.println(node1);
        String node2 = client.create()
                .creatingParentsIfNeeded()
                .withMode(CreateMode.EPHEMERAL_SEQUENTIAL)
                .forPath("/wiki-");
        System.out.println(node2);

        client.close();
    }

}
