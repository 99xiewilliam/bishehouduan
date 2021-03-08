package com.cad.demo.xieweihaoPojo;
import org.bson.types.ObjectId;

import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Arrays;
import java.util.List;

@Document(collection = "FileMark")
public class FileMark {
    private ObjectId _id;
    private String document_id;

    public void setDocument_type(String document_type) {
        this.document_type = document_type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDocument_type() {
        return document_type;
    }

    public String getType() {
        return type;
    }

    private String document_type;
    private String type;
    private List<Object_marks> object_marks;
    private List<Relation_marks> relation_marks;

    public void set_id(ObjectId _id) {
        this._id = _id;
    }

    public void setObject_marks(List<Object_marks> object_marks) {
        this.object_marks = object_marks;
    }

    public void setRelation_marks(List<Relation_marks> relation_marks) {
        this.relation_marks = relation_marks;
    }

    public ObjectId get_id() {
        return _id;
    }

    public String getDocument_id() {
        return document_id;
    }

    public void setDocument_id(String document_id) {
        this.document_id = document_id;
    }

    public List<Object_marks> getObject_marks() {
        return object_marks;
    }

    public List<Relation_marks> getRelation_marks() {
        return relation_marks;
    }
}
