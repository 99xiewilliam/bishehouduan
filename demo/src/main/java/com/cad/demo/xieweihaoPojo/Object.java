package com.cad.demo.xieweihaoPojo;

public class Object {
    private String name;
    private String description;
    private String ICD_11;
    private String type;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setICD_11(String ICD_11) {
        this.ICD_11 = ICD_11;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setIs_checked(boolean is_checked) {
        this.is_checked = is_checked;
    }

    public void setIs_passed(boolean is_passed) {
        this.is_passed = is_passed;
    }

    public void setMark_user_id(String mark_user_id) {
        this.mark_user_id = mark_user_id;
    }

    public void setMark_time(String mark_time) {
        this.mark_time = mark_time;
    }

    public void setCheck_user_id(String check_user_id) {
        this.check_user_id = check_user_id;
    }

    public void setCheck_time(String check_time) {
        this.check_time = check_time;
    }

    public void setMultiple_marked(Boolean multiple_marked) {
        this.multiple_marked = multiple_marked;
    }

    public String getDescription() {
        return description;
    }

    public String getICD_11() {
        return ICD_11;
    }

    public String getType() {
        return type;
    }

    public boolean isIs_checked() {
        return is_checked;
    }

    public boolean isIs_passed() {
        return is_passed;
    }

    public String getMark_user_id() {
        return mark_user_id;
    }

    public String getMark_time() {
        return mark_time;
    }

    public String getCheck_user_id() {
        return check_user_id;
    }

    public String getCheck_time() {
        return check_time;
    }

    public Boolean getMultiple_marked() {
        return multiple_marked;
    }

    private boolean is_checked;
    private boolean is_passed;
    private String mark_user_id;
    private String mark_time;
    private String check_user_id;
    private String check_time;
    private boolean multiple_marked;
}
