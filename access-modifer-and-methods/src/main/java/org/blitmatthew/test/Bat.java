package org.blitmatthew.test;

import java.io.Serializable;
import java.util.List;

public class Bat extends Animal implements Serializable, Cloneable {
    String color;

    public Bat() {
        super();
    }

    public int getId() {
        return this.id;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
