package com.joaovitorsb.projectmongodb.dto;

import com.joaovitorsb.projectmongodb.models.UserModel;

import java.io.Serializable;

public class UserDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private String id;
    private String name;
    private String email;

    public UserDTO() {
    }
    public UserDTO(UserModel userModel) {
        this.id = userModel.getId();
        this.name = userModel.getName();
        this.email = userModel.getEmail();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
