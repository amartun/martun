package com.martun.entity;

import java.util.Random;

public class User {

    private String fullName;
    private int age;
    private int id;

    public User(String fullName, int age) {
        this.fullName = fullName;
        this.age = age;
        this.id = new Random().nextInt();
    }


    public String getFullName() {
        return fullName;
    }

    public int getId() {

        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}

