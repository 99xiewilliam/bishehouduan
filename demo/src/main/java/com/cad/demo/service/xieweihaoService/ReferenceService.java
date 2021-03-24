package com.cad.demo.service.xieweihaoService;
import com.cad.demo.xieweihaoPojo.Reference;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReferenceService {
    private MongoTemplate mongoTemplate;

    public ReferenceService(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    //获取所有论文
    public List<Reference> getReferenceListAll(){
        List<Reference> res;
        res = mongoTemplate.findAll(Reference.class);
        return res;
    }
    public List<Reference> getReferenceList(String category, String word){
        List<Reference> res;
        if (category.equals("new")){
            Query query = new Query();
            query.limit(6);
            res = mongoTemplate.find(query, Reference.class);
        }
        else if (category.equals("search")){
            Query query = new Query();
            query.addCriteria(Criteria.where("title").regex(word));
            res = mongoTemplate.find(query, Reference.class);
        }
        else if (category.equals("year")){
            Query query = new Query();
            query.addCriteria(Criteria.where("year").regex(word));
            res = mongoTemplate.find(query, Reference.class);
        }
        else{
            res = null;
        }
        return res;
    }

    public List<Reference> referenceDetail(String word){
        Query query = new Query();
        query.addCriteria(Criteria.where("title").is(word));
        List<Reference> sample = mongoTemplate.find(query, Reference.class);
        if(sample.size()==1){
            Integer count = sample.get(0).getCount();
            Update update = Update.update("count", count+1);
            mongoTemplate.updateMulti(query, update, "TestCnkiPaper");
        }
        return sample;
    }
}
