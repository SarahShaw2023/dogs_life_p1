package com.db.grad.javaapi.model;


import javax.persistence.*;

@Entity
@Table(name="dogs")
public class Dog
{
    @Id
    private long id;
    private String name;

    private long age;

//    public Dog() {
//        name = "";
//    }

//    public Dog(String name) {
//        this.name = name;
//    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Column(name = "name", nullable = false)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "age", nullable = false)
    public long getAge() {
        return age;
    }

    public void setAge(long age) {
        this.age = age;
    }
}
