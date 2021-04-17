package com.cad.demo.dao;


import ch.qos.logback.classic.Logger;
import com.baidu.hugegraph.driver.GremlinManager;
import com.baidu.hugegraph.driver.HugeClient;
import com.baidu.hugegraph.driver.SchemaManager;
import com.baidu.hugegraph.structure.gremlin.ResultSet;
import com.cad.demo.xieweihaoPojo.Request;
import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;
//import org.apache.commons.httpclient.methods.RequestEntity;
import java.io.IOException;

@Repository
public class RestApiDAO {
    @Autowired
    private RestTemplate restTemplate;

//    public String getNodes() {
//        String str = "";
//        try {
//            String url = "http://114.67.200.39:44641/graphs/hugegraph/schema/edgelabels";
//            restTemplate.getForObject(url, String.class);
//            return restTemplate.getForObject(url, String.class);
//        }catch (Exception e) {
//            System.out.println(e);
//        }
//        return str;
//    }
    public String setNodes(Request request, String jsonStr) {
        String str = "";
        String id = request.getId();
        String url = "http://114.67.200.39:44640/graphs/hugegraph/graph/vertices/" + id + "?action=append";
        HttpPut httpPut = new HttpPut(url);
        httpPut.setHeader("Content-type", "application/json");
        //httpPut.setHeader("DataEncoding", "UTF-8");
        RequestConfig requestConfig = RequestConfig.custom().setConnectTimeout(35000).setConnectionRequestTimeout(35000).setSocketTimeout(60000).build();
        httpPut.setConfig(requestConfig);

        CloseableHttpClient httpClient = HttpClients.createDefault();
        CloseableHttpResponse httpResponse = null;
        //URLEncode.encode(jsonStr, "GBK");
        try {
            httpPut.setEntity(new StringEntity(jsonStr,"application/json", "UTF-8"));
            httpResponse = httpClient.execute(httpPut);
            HttpEntity entity = httpResponse.getEntity();
            String result = EntityUtils.toString(entity);
            return result;
        } catch (ClientProtocolException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            if (httpResponse != null) {
                try {
                    httpResponse.close();
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
            if (null != httpClient) {
                try {
                    httpClient.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;

    }

//    public ResultSet getAllClass() {
//        return gremlin.gremlin("g.V().limit(500)").execute();
//    }
}
