package com.cad.demo.service.xieweihaoService;

import com.cad.demo.xieweihaoPojo.PeopleRemember;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PeopleRememberService {
    private MongoTemplate mongoTemplate;
    public PeopleRememberService(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    public int insertVisited(PeopleRemember peopleRemember) {
        int judge = 0;
        try {
            mongoTemplate.insert(peopleRemember);
            judge = 1;
        }catch (Exception e) {
            System.out.println(e);
        }
        return judge;
    }

    public int CountVisited() {
        int count = 0;
        List<PeopleRemember> res = mongoTemplate.findAll(PeopleRemember.class);
        for(PeopleRemember peopleRemember : res) {
            count = count + 1;
        }
        return count;
    }
}
