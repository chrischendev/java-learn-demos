package com.chris.java8.tech.stream;

/**
 * create by: Chris Chan
 * create on: 2019/6/11 21:07
 * use for:
 */

public class UserModel {
    private int id;
    private String name;
    private int age;
    private int level;

    public UserModel() {
    }

    public UserModel(int id, String name, int age, int level) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.level = level;
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }
}
