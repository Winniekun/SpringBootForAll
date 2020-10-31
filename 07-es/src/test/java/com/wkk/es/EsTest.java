package com.wkk.es;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.elasticsearch.action.admin.indices.create.CreateIndexRequest;
import org.elasticsearch.action.admin.indices.create.CreateIndexResponse;
import org.elasticsearch.action.admin.indices.delete.DeleteIndexRequest;
import org.elasticsearch.action.admin.indices.get.GetIndexRequest;
import org.elasticsearch.action.support.master.AcknowledgedResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;

/**
 * @author kongwiki@163.com
 * @since 2020/10/28
 */
@SpringBootTest
public class EsTest {
    @Autowired
    @Qualifier("restHighLevelClient")
    private RestHighLevelClient client;

    @Test
    public void createIndex() throws IOException {

        //1. 创建索引请求
        CreateIndexRequest request = new CreateIndexRequest("wkk_index");
        //2. 客户端执行请求 IndicesClient，并获取响应信息
        CreateIndexResponse createIndexResponse = client.indices().create(request, RequestOptions.DEFAULT);
        ObjectMapper objectMapper = new ObjectMapper();
        //输出结果：{"acknowledged":true,"shardsAcknowledged":true,"fragment":false}
        System.out.println(objectMapper.writeValueAsString(createIndexResponse));
    }

    @Test
    public void getIndex() throws IOException {
        //1. 创建获取索引请求
        GetIndexRequest getIndexRequest = new GetIndexRequest().indices("wkk_index");
        //2. 判断索引是否存在
        boolean exists = client.indices().exists(getIndexRequest, RequestOptions.DEFAULT);
        //输出结果：true
        System.out.println(exists);

    }

    @Test
    public void delIndex() throws IOException {
        DeleteIndexRequest request = new DeleteIndexRequest("wkk_index");
        AcknowledgedResponse delete = client.indices().delete(request, RequestOptions.DEFAULT);
        System.out.println(delete.isAcknowledged());
    }
}
