package com.arcane.model;

import java.io.Serializable;

/**
 * Created by Chann on 1/5/2015.
 */
public class Pattern implements Serializable {
    private String name;
    private int id;
    private String stock;
    private String type;
    private String timeStamp;//for sorting the list in recent pattern table

    public String getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(String timeStamp) {
        this.timeStamp = timeStamp;
    }

    public String getStock() {
        return stock;
    }

    public void setStock(String company) {
        this.stock = company;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

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
