package com.brn.workshopmongo.dto;

import com.brn.workshopmongo.domain.User;

import java.io.Serializable;
import java.security.PrivateKey;

public class AuthorDTO implements Serializable {
    private String id;

    private String name;

    public AuthorDTO() {
    }

    public AuthorDTO(User obj) {
        this.id = obj.getId();
        this.name = obj.getName();
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

    @Override
    public String toString() {
        return "AuthorDTO{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
