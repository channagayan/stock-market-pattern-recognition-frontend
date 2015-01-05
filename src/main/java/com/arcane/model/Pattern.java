package com.arcane.model;

import java.io.Serializable;

/**
 * Created by Chann on 1/5/2015.
 */
public class Pattern implements Serializable {
    private String name;
    private int id;

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
