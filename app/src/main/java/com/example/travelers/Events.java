package com.example.travelers;

import java.io.Serializable;

public class Events implements Serializable {

private String id;
private String title;
private String category;

    public Events(String id, String title, String category) {
        this.id = id;
        this.title = title;
        this.category = category;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
