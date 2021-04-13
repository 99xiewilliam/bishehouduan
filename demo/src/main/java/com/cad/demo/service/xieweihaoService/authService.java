package com.cad.demo.service.xieweihaoService;

import com.cad.demo.xieweihaoPojo.Token;
import com.cad.demo.xieweihaoPojo.auth;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class authService {
    private MongoTemplate mongoTemplate;

    public authService(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    public Token getAuthAll(String username, String password) {
        List<auth> res = mongoTemplate.findAll(auth.class);
        Token token = new Token();
        token.setToken("error");
        for(auth auth: res) {
            if (auth.getPassword().equals(password) && auth.getUsername().equals(username)) {
                if (username.equals("admin")) {
                    token.setToken("admin-token");
                }else {
                    token.setToken("editor-token");
                }

            }
        }
        return token;
    }
}
