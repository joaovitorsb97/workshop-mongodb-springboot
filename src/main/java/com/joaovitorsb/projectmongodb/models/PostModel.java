package com.joaovitorsb.projectmongodb.models;

import com.joaovitorsb.projectmongodb.dto.AuthorDTO;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

public class PostModel implements Serializable {
    private static final long serialVersionUID = 1L;

    private String id;
    private Date date;
    private String title;
    private String body;

    private AuthorDTO author;

    public PostModel() {
    }

    public PostModel(String id, Date date, String title, String body, AuthorDTO author) {
        this.id = id;
        this.date = date;
        this.title = title;
        this.body = body;
        this.author = author;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public AuthorDTO getAuthor() {
        return author;
    }

    public void setAuthor(AuthorDTO author) {
        this.author = author;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PostModel postModel = (PostModel) o;
        return Objects.equals(id, postModel.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
