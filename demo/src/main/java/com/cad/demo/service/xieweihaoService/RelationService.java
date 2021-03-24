package com.cad.demo.service.xieweihaoService;
import com.cad.demo.xieweihaoPojo.Relation;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class RelationService {
    private MongoTemplate mongoTemplate;

    public RelationService(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }
    //获取所有实体
    public List<Relation> getEntities() {
        List<Relation> res;
        res = mongoTemplate.findAll(Relation.class);
        return res;

    }
}
