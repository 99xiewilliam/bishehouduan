package com.cad.demo.xieweihaoPojo;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Visit")
public class PeopleRemember {
    private String username;

    public void setUsername(String username) {
        this.username = username;
    }

    public void setDate(String date) {
        Date = date;
    }

    public String getUsername() {
        return username;
    }

    public String getDate() {
        return Date;
    }

    private String Date;
}
