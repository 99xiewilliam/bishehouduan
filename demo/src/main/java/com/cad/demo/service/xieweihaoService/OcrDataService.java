package com.cad.demo.service.xieweihaoService;
import com.cad.demo.xieweihaoPojo.OcrData;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import org.bson.Document;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OcrDataService {
    private MongoTemplate mongoTemplate;
    public OcrDataService(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }
    public List<OcrData> getOcrData() {
        List<OcrData> res;
        res = mongoTemplate.findAll(OcrData.class);
        return res;
    }

    public int InsertOcrData(OcrData data) {
        int judge = 0;
        try {
            mongoTemplate.insert(data);
            judge = 1;
        } catch(Exception e) {
            System.out.println(e);
        }
        return judge;
    }
}
