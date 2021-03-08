package com.cad.demo.xieweihaoPojo;

import java.util.List;

public class Relation_marks {
    private String relation_id;
    private String start_type;
    private String relation_type;
    private String end_type;
    private List<Relations> relations;
    private boolean is_checked;
    private boolean is_passed;
    private String mark_user;
    private String mark_time;
    private String check_user;
    private String check_time;

    public String getRelation_id() {
        return relation_id;
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

    public List<Relations> getRelations() {
        return relations;
    }

    public boolean isIs_checked() {
        return is_checked;
    }

    public boolean isIs_passed() {
        return is_passed;
    }

    public String getMark_user() {
        return mark_user;
    }

    public String getMark_time() {
        return mark_time;
    }

    public String getCheck_user() {
        return check_user;
    }

    public String getCheck_time() {
        return check_time;
    }

    public void setRelation_id(String relation_id) {
        this.relation_id = relation_id;
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

    public void setRelations(List<Relations> relations) {
        this.relations = relations;
    }

    public void setIs_checked(boolean is_checked) {
        this.is_checked = is_checked;
    }

    public void setIs_passed(boolean is_passed) {
        this.is_passed = is_passed;
    }

    public void setMark_user(String mark_user) {
        this.mark_user = mark_user;
    }

    public void setMark_time(String mark_time) {
        this.mark_time = mark_time;
    }

    public void setCheck_user(String check_user) {
        this.check_user = check_user;
    }

    public void setCheck_time(String check_time) {
        this.check_time = check_time;
    }
}
