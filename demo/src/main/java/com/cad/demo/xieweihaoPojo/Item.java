package com.cad.demo.xieweihaoPojo;

import org.bson.types.ObjectId;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Tagging_items")
public class Item {
    private ObjectId _id;
    private int num;
    private String name;
    private String time;
    private int sum_num;
    private int mark_num;
    private String col_name;
    private boolean state;



    public boolean isState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
    }
    public String getName() {
        return name;
    }

    public String getTime() {
        return time;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public void set_id(ObjectId _id) {
        this._id = _id;
    }

    public ObjectId get_id() {
        return _id;
    }

    public void setSun_num(int sum_num) {
        this.sum_num = sum_num;
    }

    public void setMark_num(int mark_num) {
        this.mark_num = mark_num;
    }

    public void setCol_name(String col_name) {
        this.col_name = col_name;
    }

    public int getSum_num() {
        return sum_num;
    }

    public int getMark_num() {
        return mark_num;
    }

    public String getCol_name() {
        return col_name;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + _id +
                ", name='" + name + '\'' +
                ", time='" + time + '\'' +
                '}';
    }


}
