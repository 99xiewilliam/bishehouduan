package com.cad.demo.service.xieweihaoService;

import com.cad.demo.xieweihaoPojo.*;
import com.cad.demo.xieweihaoPojo.Object;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;
import org.springframework.data.mongodb.core.MongoTemplate;

import java.io.File;
import java.util.List;


@Service
public class ExpertInputService {
    private MongoTemplate mongoTemplate;

    public ExpertInputService(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }


    public int addExpertInput(ExpertInput expertInput) {
        int judge = 0;
        int test = 0;
        int index = 0;
        List<ExpertInput> re = getExpertInputAll();
        System.out.println(re);
        try{
            for (ExpertInput r : re){
                String id1 = expertInput.getDocument_id();
                String id2 = r.getDocument_id();
                if (id1.equals(id2)){
                    test = 1;
                    break;
                }
                index = index + 1;
            }
            System.out.println(test);
            if(test == 0){
                mongoTemplate.insert(expertInput);
            }else if(test == 1){
                Query query = new Query();
                query.addCriteria(Criteria.where("document_id").is(expertInput.getDocument_id()));
                Update update = new Update();
                List<Object_marks> os = re.get(index).getObject_marks();
                List<Relation_marks> rs = re.get(index).getRelation_marks();
                for(Object_marks o : os){
                    for(Object_marks o1: expertInput.getObject_marks()){
                        if(o1.getObject_type().equals(o.getObject_type())){
                            if(o1.getObjects().size() != 0){
                                for(Object obj: o1.getObjects()){
                                    o.getObjects().add(obj);
                                }
                            }
                            break;
                        }

                    }
                }
                for(Relation_marks r : rs){
                    for(Relation_marks r1: expertInput.getRelation_marks()){
                        if(r.getStart_type().equals(r1.getStart_type()) &&
                                r.getRelation_type().equals(r1.getRelation_type()) && r.getEnd_type().equals(r1.getEnd_type())){
                            if(r1.getRelations().size() != 0){
                                for(Relations rel: r1.getRelations()){
                                    r.getRelations().add(rel);
                                }
                            }
                            break;
                        }

                    }
                }
                update.set("object_marks", re.get(index).getObject_marks());
                update.set("relation_marks", re.get(index).getRelation_marks());
                mongoTemplate.upsert(query,update,ExpertInput.class);
            }
            judge = 1;
        }catch (Exception e) {
            System.out.println(e);
        }
        return judge;
    }

    public List<ExpertInput> getExpertInputAll() {
        List<ExpertInput> res;
        res = mongoTemplate.findAll(ExpertInput.class);
        return res;
    }
}
