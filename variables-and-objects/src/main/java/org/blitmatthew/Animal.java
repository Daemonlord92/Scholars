package org.blitmatthew;

public class Animal {
    private String name;
    private Integer size;
    private Integer weight;
    protected String speak;

    public Animal() {}

    public Animal(String name, Integer size, Integer weight, String speak) {
        this.name = name;
        this.size = size;
        this.weight = weight;
        this.speak = speak;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public String getSpeak() {
        return speak;
    }

    public void setSpeak(String speak) {
        this.speak = speak;
    }
}
