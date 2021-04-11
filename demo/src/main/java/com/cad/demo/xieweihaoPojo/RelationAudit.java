package com.cad.demo.xieweihaoPojo;

public class RelationAudit {
    private String document_id;
    private String start_type;
    private String relation_type;

    public boolean isStatus() {
        return status;
    }

    private String end_type;
    private String start_object;
    private String end_object;

    public void setStatus(boolean status) {
        this.status = status;
    }

    private boolean status;

    public void setDocument_id(String document_id) {
        this.document_id = document_id;
    }

    public void setStart_type(String start_type) {
        this.start_type = start_type;
    }

    public void setRelation_type(String relation_type) {
        this.relation_type = relation_type;
    }

    public void setEnd_type(String end_type) {
        this.end_type = end_type;
    }

    public void setStart_object(String start_object) {
        this.start_object = start_object;
    }

    public void setEnd_object(String end_object) {
        this.end_object = end_object;
    }

    public String getDocument_id() {
        return document_id;
    }

    public String getStart_type() {
        return start_type;
    }

    public String getRelation_type() {
        return relation_type;
    }

    public String getEnd_type() {
        return end_type;
    }

    public String getStart_object() {
        return start_object;
    }

    public String getEnd_object() {
        return end_object;
    }
}
