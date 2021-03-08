package com.cad.demo.xieweihaoPojo;

import org.bson.types.ObjectId;

import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Arrays;

@Document(collection = "EntityTypes")
public class Entity {
    private ObjectId _id;
    private String properties[];
    private String name;

    @Override
    public String toString() {
        return "Entity{" +
                "_id=" + _id +
                ", properties=" + Arrays.toString(properties) +
                ", name='" + name + '\'' +
                '}';
    }

    public ObjectId get_id() {
        return _id;
    }

    public void set_id(ObjectId _id) {
        this._id = _id;
    }

    public void setProperties(String[] properties) {
        this.properties = properties;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String[] getProperties() {
        return properties;
    }

    public String getName() {
        return name;
    }
}
