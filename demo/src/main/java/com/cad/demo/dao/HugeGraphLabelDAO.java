package com.cad.demo.dao;
import com.baidu.hugegraph.driver.GremlinManager;
import com.baidu.hugegraph.driver.HugeClient;
import com.baidu.hugegraph.driver.SchemaManager;
import com.baidu.hugegraph.structure.gremlin.ResultSet;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public class HugeGraphLabelDAO {
    HugeClient hugeClient = new HugeClient("http://114.67.200.39:44640", "hugegraph");
    SchemaManager schemaManager = hugeClient.schema();
    GremlinManager gremlinManager = hugeClient.gremlin();

    //g.V().hasLabel(" + category + ").limit(50)
    public ResultSet getNodes(String category) {
        System.out.println(category);
        return gremlinManager.gremlin("g.V().hasLabel('" + category + "').limit(50)").execute();
    }


}
