package com.cad.demo.xieweihaoPojo;

public class EntityAudit {
    private String document_id;
    private String check_user_id;

    public void setCheck_user_id(String check_user_id) {
        this.check_user_id = check_user_id;
    }

    public String getCheck_user_id() {
        return check_user_id;
    }

    public String getDocument_id() {
        return document_id;
    }

    public void setDocument_id(String document_id) {
        this.document_id = document_id;
    }

    public void setObject_type(String object_type) {
        this.object_type = object_type;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getObject_type() {
        return object_type;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getName() {
        return name;
    }

    private String object_type;
    private String name;
    private boolean status;
}
