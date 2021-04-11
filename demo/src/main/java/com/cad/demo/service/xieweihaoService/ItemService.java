package com.cad.demo.service.xieweihaoService;
import com.cad.demo.xieweihaoPojo.Item;
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
import java.util.logging.Filter;

@Service
public class ItemService {
    private MongoTemplate mongoTemplate;

    public ItemService(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    //获取所有文本类型
    public List<Item> getReferenceListAll(){
        List<Item> res;
        List<Item> res1;
        res = mongoTemplate.findAll(Item.class);
        MongoClient mongoClient = new MongoClient("127.0.0.1", 27017);
        MongoDatabase mongoDatabase = mongoClient.getDatabase("Hypertension");
        MongoCollection<Document> collection_item = mongoDatabase.getCollection("TestCnkiPaper");
        for(Item i :res){
            //System.out.println(i.getCol_name());
            dealWithCollection(i.getCol_name(), mongoDatabase, collection_item, mongoTemplate);
        }
        res1 = mongoTemplate.findAll(Item.class);
        return res1;
    }

    public static void dealWithCollection(String name, MongoDatabase mongoDatabase, MongoCollection<Document> collection_item, MongoTemplate mongoTemplate){

        if(name != ""){
            //MongoCollection<Document> collection = mongoDatabase.getCollection(name);
            int a = (int) collection_item.countDocuments();
            int b = (int) collection_item.countDocuments(Filters.eq("is_marked",true));
            if(a == b && a != 0){
                Query query = new Query();
                query.addCriteria(Criteria.where("col_name").is(name));
                Update update1 = new Update();
                update1.set("state", true);
                mongoTemplate.upsert(query, update1, Item.class);
            }
            System.out.println(a);
            System.out.println(b);
            Query query = new Query();
            query.addCriteria(Criteria.where("col_name").is(name));
            Update update = new Update();
            update.set("sum_num", a);
            update.set("mark_num", b);
            mongoTemplate.upsert(query, update, Item.class);
            //collection_item.updateMany(Filters.eq("col_name",name), new Document("$set", new Document("sum_num", a).append("mark_num",b).append("state",state)));

        }

    }
    //添加
    public int addItem(Item item){
        int judge = 0;
        try {
            mongoTemplate.insert(item);
            judge = 1;
        }catch (Exception e){
            System.out.println(e);
        }
        return judge;
    }

    public int updateTime(String time, String name) {
        int judge = 0;
        try {
            Query query = new Query();
            Update update = new Update();
            query.addCriteria(Criteria.where("col_name").is(name));
            update.set("time", time);
            long a = mongoTemplate.count(query, Item.class);
            System.out.println(a);
            if (a != 0) {
                System.out.println("update time success");
                mongoTemplate.upsert(query, update, Item.class);
                judge = 1;
            }

        }catch (Exception e) {
            System.out.println(e);
        }
        return judge;
    }

}
