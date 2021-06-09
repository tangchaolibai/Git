package com.es.test;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.HttpHost;
import org.elasticsearch.action.bulk.BulkRequest;
import org.elasticsearch.action.bulk.BulkResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.xcontent.XContentType;
import org.elasticsearch.rest.RestStatus;

public class ESTest_Doc_Insert_Batch {

    public static void main(String[] args) throws Exception{
        RestHighLevelClient client = new RestHighLevelClient(RestClient.builder(new HttpHost("localhost", 9200, "http")));


        BulkRequest request = new BulkRequest();

        request.add(new IndexRequest().index("user").id("1001").source(XContentType.JSON, "name", "zhangsan","age",30,"sex","男"));
        request.add(new IndexRequest().index("user").id("1002").source(XContentType.JSON,"name","lisi","age",30,"sex","男"));
        request.add(new IndexRequest().index("user").id("1003").source(XContentType.JSON,"name","wangwu","age",40,"sex","男"));
        request.add(new IndexRequest().index("user").id("1004").source(XContentType.JSON,"name","wangwu1","age",40,"sex","女"));
        request.add(new IndexRequest().index("user").id("1005").source(XContentType.JSON,"name","wangwu2","age",50,"sex","男"));
        request.add(new IndexRequest().index("user").id("1006").source(XContentType.JSON,"name","wangwu3","age",50,"sex","男"));

        BulkResponse bulk = client.bulk(request, RequestOptions.DEFAULT);
        RestStatus status = bulk.status();
        System.out.println(status.getStatus());
        client.close();;
    }

}
