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
public class FileMarkService {
    private MongoTemplate mongoTemplate;

    public FileMarkService(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }


    public int addFileMark(FileMark fileMark) {
        int judge = 0;
        int test = 0;
        int index = 0;
        List<FileMark> re = getFileMarkAll();
        System.out.println(re);
        try{
            for (FileMark r : re){
                String id1 = fileMark.getDocument_id();
                String id2 = r.getDocument_id();
                if (id1.equals(id2)){
                    test = 1;
                    break;
                }
                index = index + 1;
            }
            System.out.println(test);
            if(test == 0){
                mongoTemplate.insert(fileMark);
            }else if(test == 1){
                Query query = new Query();
                query.addCriteria(Criteria.where("document_id").is(fileMark.getDocument_id()));
                Update update = new Update();
                List<Object_marks> os = re.get(index).getObject_marks();
                List<Relation_marks> rs = re.get(index).getRelation_marks();
                for(Object_marks o : os){
                    for(Object_marks o1: fileMark.getObject_marks()){
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
                    for(Relation_marks r1: fileMark.getRelation_marks()){
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
                mongoTemplate.upsert(query,update,FileMark.class);
            }
            judge = 1;
        }catch (Exception e) {
            System.out.println(e);
        }
        return judge;
    }

    public List<FileMark> getFileMarkAll() {
        List<FileMark> res;
        res = mongoTemplate.findAll(FileMark.class);
        return res;
    }

    public int updateEntityStatus(String document_id, String object_type, String name, boolean status) {
        int judge = 0;

        try {
            Query query = new Query();
            query.addCriteria(Criteria.where("document_id").is(document_id).and("object_marks.object_type").is(object_type).and("object_marks.objects.name").is(name));
            //Update update = new Update();
            //update.set("object_marks.objects.is_checked", true).set("object_marks.objects.is_passed", status);
            long a = mongoTemplate.count(query, FileMark.class);
            FileMark fileMark = mongoTemplate.findOne(query, FileMark.class);
            if (a != 0) {
                List<Object_marks> object_marks = fileMark.getObject_marks();
                for (Object_marks object_mark : object_marks) {
                    if (object_mark.getObject_type().equals(object_type)) {
                        List<Object> objects = object_mark.getObjects();
                        for (Object object : objects) {
                            if (object.getName().equals(name)) {
                                object.setIs_checked(true);
                                object.setIs_passed(status);
                                judge = 1;
                                break;
                            }
                        }
                        break;
                    }

                }
                mongoTemplate.remove(query, FileMark.class);
                mongoTemplate.insert(fileMark);

            }
        }catch (Exception e) {
            System.out.println(e);
        }

        return judge;
    }

    public int updateRelationStatus(String document_id, String start_type, String relation_type, String end_type, String start_object, String end_object, boolean status) {
        int judge = 0;

        try {
            Query query = new Query();
            query.addCriteria(Criteria.where("document_id").is(document_id).and("relation_marks.start_type").is(start_type).and("relation_marks.relation_type").is(relation_type).and("relation_marks.end_type").is(end_type).and("relation_marks.relations.start_object").is(start_object).and("relation_marks.relations.end_object").is(end_object));
            //Update update = new Update();
            //update.set("relation_marks.$.relations.$.is_checked", true).set("relation_marks.$.relations.$.is_passed", status);
            long a = mongoTemplate.count(query, FileMark.class);
            FileMark fileMark = mongoTemplate.findOne(query, FileMark.class);
            if (a != 0) {
                //mongoTemplate.upsert(query, update, FileMark.class);
                List<Relation_marks> relation_marks = fileMark.getRelation_marks();
                for(Relation_marks relation_mark: relation_marks) {
                    if (relation_mark.getStart_type().equals(start_type) && relation_mark.getRelation_type().equals(relation_type) && relation_mark.getEnd_type().equals(end_type)) {
                        List<Relations> relations = relation_mark.getRelations();
                        for(Relations relation: relations) {
                            if (relation.getStart_object().equals(start_object) && relation.getEnd_object().equals(end_object)) {
                                relation.setIs_checked(true);
                                relation.setIs_passed(status);
                                judge = 1;
                                break;
                            }
                        }
                        break;
                    }
                }
                mongoTemplate.remove(query, FileMark.class);
                mongoTemplate.insert(fileMark);
            }
        }catch (Exception e) {
            System.out.println(e);
        }

        return judge;
    }
}
