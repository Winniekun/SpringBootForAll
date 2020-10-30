package com.wkk.es;

import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author kongwiki@163.com
 * @since 2020/10/28
 */
@SpringBootTest
public class EsTest {
    @Autowired
    @Qualifier("restHighLevelClient")
    private RestHighLevelClient client;


}
