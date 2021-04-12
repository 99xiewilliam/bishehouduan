package com.cad.demo.service.xieweihaoService;
import com.cad.demo.xieweihaoPojo.*;
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
    public List<DiagnosisReport> getDiagnosisReportListAll(){
        List<DiagnosisReport> res;
        res = mongoTemplate.findAll(DiagnosisReport.class);
        return res;
    }
    public List<DrugInstructions> getDrugInstructionsListAll(){
        List<DrugInstructions> res;
        res = mongoTemplate.findAll(DrugInstructions.class);
        return res;
    }
    public List<Guide> getGuideListAll(){
        List<Guide> res;
        res = mongoTemplate.findAll(Guide.class);
        return res;
    }
    public List<Book> getBookListAll(){
        List<Book> res;
        res = mongoTemplate.findAll(Book.class);
        return res;
    }
    public Reference getReference(String id) {
        Query query = new Query();
        query.addCriteria(Criteria.where("_id").is(id));
        Reference reference =  mongoTemplate.findOne(query, Reference.class);
        return reference;
    }

    public Book getBook(String id) {
        Query query = new Query();
        query.addCriteria(Criteria.where("_id").is(id));
        Book reference =  mongoTemplate.findOne(query, Book.class);
        return reference;
    }
    public Guide getGuide(String id) {
        Query query = new Query();
        query.addCriteria(Criteria.where("_id").is(id));
        Guide reference =  mongoTemplate.findOne(query, Guide.class);
        return reference;
    }
    public DrugInstructions getDrugInstructions(String id) {
        Query query = new Query();
        query.addCriteria(Criteria.where("_id").is(id));
        DrugInstructions reference =  mongoTemplate.findOne(query, DrugInstructions.class);
        return reference;
    }
    public DiagnosisReport getDiagnosisReport(String id) {
        Query query = new Query();
        query.addCriteria(Criteria.where("_id").is(id));
        DiagnosisReport reference =  mongoTemplate.findOne(query, DiagnosisReport.class);
        return reference;
    }
    public int ModifyInfo(String id, String category) {
        int judge = 0;
        try {
            Query query = new Query();
            query.addCriteria(Criteria.where("_id").is(id));
            Update update = new Update();
            if (category.equals("Paper")) {
                long a = mongoTemplate.count(query, Reference.class);
                update.set("is_marked", true);
                if (a != 0) {
                    mongoTemplate.upsert(query, update, Reference.class);
                    judge = 1;
                }
            }
            else if (category.equals("Book")) {
                long a = mongoTemplate.count(query, Book.class);
                update.set("is_marked", true);
                if (a != 0) {
                    mongoTemplate.upsert(query, update, Book.class);
                    judge = 1;
                }
            }
            else if (category.equals("Guide")) {
                long a = mongoTemplate.count(query, Guide.class);
                update.set("is_marked", true);
                if (a != 0) {
                    mongoTemplate.upsert(query, update, Guide.class);
                    judge = 1;
                }
            }
            else if (category.equals("DrugInstructions")) {
                long a = mongoTemplate.count(query, DrugInstructions.class);
                update.set("is_marked", true);
                if (a != 0) {
                    mongoTemplate.upsert(query, update, DrugInstructions.class);
                    judge = 1;
                }
            }
            else if (category.equals("DiagnosisReport")) {
                long a = mongoTemplate.count(query, DiagnosisReport.class);
                update.set("is_marked", true);
                if (a != 0) {
                    mongoTemplate.upsert(query, update, DiagnosisReport.class);
                    judge = 1;
                }
            }

        }catch (Exception e){
            System.out.println(e);
        }
        return judge;
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
