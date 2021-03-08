package com.cad.demo.service.xieweihaoService;
import com.cad.demo.xieweihaoPojo.Entity;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class EntityService {
    private MongoTemplate mongoTemplate;

    public EntityService(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    public List<Entity> getEntities() {
        List<Entity> res;
        res = mongoTemplate.findAll(Entity.class);
        return res;

    }
}
