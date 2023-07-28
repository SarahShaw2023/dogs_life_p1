package com.db.grad.javaapi.model;

public class Dog
{
    private long id;
    private String name;

    public Dog() {
        id = 0; // change?
        name = "";
    }

    public Dog(String name) {
        id = 0; // change?
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
