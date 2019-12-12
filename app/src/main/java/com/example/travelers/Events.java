package com.example.travelers;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;

@Entity(tableName = "events")
public class Events implements Serializable {

@PrimaryKey
@NonNull
@ColumnInfo(name = "id")
private String id;
@ColumnInfo(name = "title")
private String title;
@ColumnInfo(name = "category")
private String category;
@ColumnInfo(name = "cover_url")
private String cover_url;
@ColumnInfo(name = "date_start")
private String date_start;
@ColumnInfo(name = "date_end")
private String date_end;
@ColumnInfo(name = "description")
private String description;

    public Events(String id, String title, String category, String cover_url, String date_start, String date_end, String description) {
        this.id = id;
        this.title = title;
        this.category = category;
        this.cover_url = cover_url;
        this.date_start = date_start;
        this.date_end = date_end;
        this.description = description;
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

    public String getCover_url() {
        return cover_url;
    }

    public void setCover_url(String cover_url) {
        this.cover_url = cover_url;
    }

    public String getDate_start() { return date_start; }

    public void setDate_start(String date_start) { this.date_start = date_start; }

    public String getDate_end() { return date_end; }

    public void setDate_end(String date_end) { this.date_end = date_end; }

    public String getDescription() { return description; }

    public void setDescription(String description) { this.description = description; }
}
