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

    public List<Item> getReferenceListAll(){
        List<Item> res;
        List<Item> res1;
        res = mongoTemplate.findAll(Item.class);
        MongoClient mongoClient = new MongoClient("114.67.200.39", 27817);
        MongoDatabase mongoDatabase = mongoClient.getDatabase("Hypertension");
        MongoCollection<Document> collection_item = mongoDatabase.getCollection("Tagging_items");
        for(Item i :res){
            //System.out.println(i.getCol_name());
            dealWithCollection(i.getCol_name(), mongoDatabase, collection_item);
        }
        res1 = mongoTemplate.findAll(Item.class);
        return res1;
    }

    public static void dealWithCollection(String name, MongoDatabase mongoDatabase, MongoCollection<Document> collection_item){
        Boolean state = false;

        if(name != ""){
            MongoCollection<Document> collection = mongoDatabase.getCollection(name);
            int a = (int) collection.countDocuments();
            int b = (int) collection.countDocuments(Filters.eq("is_marked",true));
            if(a == b && a != 0){
                state = true;
            }
            System.out.println(a);
            collection_item.updateMany(Filters.eq("col_name",name), new Document("$set", new Document("sum_num", a).append("mark_num",b).append("state",state)));

        }

    }

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

}
