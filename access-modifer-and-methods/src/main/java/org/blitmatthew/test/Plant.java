package org.blitmatthew.test;

public abstract class Plant {
    private String name;
    private String genus;

    public Plant() {}
    public Plant(String name, String genus) {
        this.name = name;
        this.genus = genus;
    }

    public abstract void grow();
    public abstract void die();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGenus() {
        return genus;
    }

    public void setGenus(String genus) {
        this.genus = genus;
    }
}
