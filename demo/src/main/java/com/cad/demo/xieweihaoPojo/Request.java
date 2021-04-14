package com.cad.demo.xieweihaoPojo;

import org.springframework.web.multipart.MultipartFile;

public class Request {
    public String getId() {
        return id;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public void setId(String id) {
        this.id = id;
    }

    private String id;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    private String time;

    public void setImg(MultipartFile img) {
        this.img = img;
    }

    public MultipartFile getImg() {
        return img;
    }

    private String name;
    private MultipartFile img;
    public void setCategory(String category) {
        this.category = category;
    }

    public String getCategory() {
        return category;
    }

    private String category;

}
