package com.cad.demo.service.xieweihaoService;

import com.baidu.hugegraph.structure.graph.Edge;
import com.baidu.hugegraph.structure.graph.Path;
import com.baidu.hugegraph.structure.graph.Vertex;
import com.baidu.hugegraph.structure.gremlin.Result;
import com.baidu.hugegraph.structure.gremlin.ResultSet;
import com.cad.demo.dao.HugeGraphLabelDAO;
import com.cad.demo.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
public class HugeGraphLabelService {

    @Autowired
    private HugeGraphLabelDAO hugeGraphLabelDAO;

    public List<Object> getNodes(String category) {
        ResultSet resultSet = hugeGraphLabelDAO.getNodes(category);
        Iterator<Result> results = resultSet.iterator();
        List<Object> res = new ArrayList<>();
        results.forEachRemaining(result -> {
            Object object = result.getObject();
            HugeGraphVertex hugeGraphVertex = new HugeGraphVertex();
            hugeGraphVertex.setLabel(((Vertex)object).label());
            hugeGraphVertex.setId(((Vertex)object).id().toString());
            hugeGraphVertex.setPropertie(((Vertex)object).properties());
            res.add(hugeGraphVertex);
        });
        return res;
    }

}
