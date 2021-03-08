package com.cad.demo.entity.xieweihaoEntity;

/*
请求搜索列表和请求搜索详情都采用本实体
 */
public class Query {
    private String category;
    private String content;

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}