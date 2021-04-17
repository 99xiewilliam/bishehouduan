package com.cad.demo.dao;


import com.baidu.hugegraph.driver.GremlinManager;
import com.baidu.hugegraph.driver.HugeClient;
import com.baidu.hugegraph.driver.SchemaManager;
import com.baidu.hugegraph.structure.gremlin.ResultSet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

@Repository
public class RestApiDAO {
    @Autowired
    private RestTemplate restTemplate;

    HugeClient hugeClient = new HugeClient("http://114.67.200.39:44640","hugegraph");
//    SchemaManager schema = hugeClient.schema();
//    GremlinManager gremlin = hugeClient.gremlin();
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
    public String getNodes() {
        String str = "";



        return str;
    }

//    public ResultSet getAllClass() {
//        return gremlin.gremlin("g.V().limit(500)").execute();
//    }
}
