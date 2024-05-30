package org.blitmatthew.test;

import java.util.Date;

public class Person {
    private String name;
    private int age;
    public final Date dob;
    public final String eyeColor;
    private int height;

    public Person(Date dob, String eyeColor) {
        this.dob = dob;
        this.eyeColor = eyeColor;
    }

    public Person(String name, int age, Date dob, String eyeColor, int height) {
        this.name = name;
        this.age = age;
        this.dob = dob;
        this.eyeColor = eyeColor;
        this.height = height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public Date getDob() {
        return dob;
    }

    public String getEyeColor() {
        return eyeColor;
    }

    public int getHeight() {
        return height;
    }
}
