package com.cad.demo.xieweihaoPojo;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "authPeople")
public class auth {
    private String username;

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    private String password;

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
