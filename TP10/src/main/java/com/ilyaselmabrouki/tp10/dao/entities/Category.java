package com.ilyaselmabrouki.tp10.dao.entities;

import java.io.Serializable;

public class Category implements Serializable {
    private int id;
    private String name;

    @Override
    public String toString() {
        return name;
    }

    // Getters and Setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
