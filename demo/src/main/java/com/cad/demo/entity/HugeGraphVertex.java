package com.cad.demo.entity;

import java.util.List;
import java.util.Map;

public class HugeGraphVertex {
    private String id;
    private String label;
//    private String name;
    private Map<String,Object> propertie;
    private String description;

//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }

    public Map getPropertie() {
        return propertie;
    }

    public void setPropertie(Map<String,Object> propertie) {
        this.propertie = propertie;
        this.MaptoStirng();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }
    public void MaptoStirng(){
        String des ="Label: "+ this.label+"<br/>";
        for (Map.Entry<String,Object> entry : this.propertie.entrySet()) {
            des = des+ entry.getKey()+": " +entry.getValue()+"<br/>";
        }
        this.setDescription(des);
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
