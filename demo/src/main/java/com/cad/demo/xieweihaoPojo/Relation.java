package com.cad.demo.xieweihaoPojo;

import org.bson.types.ObjectId;

import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Arrays;


@Document(collection = "RelationTypes")
public class Relation {
    private ObjectId _id;

    public ObjectId get_id() {
        return _id;
    }

    @Override
    public String toString() {
        return "Relation{" +
                "_id=" + _id +
                ", properties=" + Arrays.toString(properties) +
                ", subject='" + subject + '\'' +
                ", object='" + object + '\'' +
                ", relation='" + relation + '\'' +
                '}';
    }

    public String[] getProperties() {
        return properties;
    }

    public void set_id(ObjectId _id) {
        this._id = _id;
    }

    public void setProperties(String[] properties) {
        this.properties = properties;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public void setObject(String object) {
        this.object = object;
    }

    public void setRelation(String relation) {
        this.relation = relation;
    }

    public String getSubject() {
        return subject;
    }

    public String getObject() {
        return object;
    }

    public String getRelation() {
        return relation;
    }

    private String properties[];
    private String subject;
    private String object;
    private String relation;



}

