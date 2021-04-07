package com.cad.demo.xieweihaoPojo;


public class PaperInfo {
    public void set_id(String _id) {
        this._id = _id;
    }

    public String get_id() {
        return _id;
    }

    public String getTitle() {
        return this.title;
    }

    public String getDate() {
        return this.date;
    }

    public String getAuthor() {
        return author;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public boolean isIs_marked() {
        return is_marked;
    }

    public void setIs_marked(boolean is_marked) {
        this.is_marked = is_marked;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    private String _id;
    private String title;
    private String date;
    private String author;
    private boolean is_marked;
}
