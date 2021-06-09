package com.es.test;

import org.apache.http.HttpHost;
import org.elasticsearch.action.bulk.BulkRequest;
import org.elasticsearch.action.bulk.BulkResponse;
import org.elasticsearch.action.delete.DeleteRequest;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.xcontent.XContentType;
import org.elasticsearch.rest.RestStatus;

public class ESTest_Doc_Delete_Batch {

    public static void main(String[] args) throws Exception{
        RestHighLevelClient client = new RestHighLevelClient(RestClient.builder(new HttpHost("localhost", 9200, "http")));


        BulkRequest request = new BulkRequest();

        DeleteRequest deleteRequest = new DeleteRequest();
        DeleteRequest source1 = deleteRequest.index("user").id("1001");
        DeleteRequest source2 = deleteRequest.index("user").id("1002");
        DeleteRequest source3 = deleteRequest.index("user").id("1003");
        request.add(source1);
        request.add(source2);
        request.add(source3);

        BulkResponse bulk = client.bulk(request, RequestOptions.DEFAULT);
        RestStatus status = bulk.status();
        System.out.println(status.getStatus());
        client.close();;
    }

}
