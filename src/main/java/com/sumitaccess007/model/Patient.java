package com.sumitaccess007.model;

import org.springframework.stereotype.Component;

@Component
public class Patient {
    private int id;
    private String name;
    private String bgroup;

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

    public String getBgroup() {
        return bgroup;
    }

    public void setBgroup(String bgroup) {
        this.bgroup = bgroup;
    }
}
