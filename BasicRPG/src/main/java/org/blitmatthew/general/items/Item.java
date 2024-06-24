package org.blitmatthew.general.items;

public abstract class Item {

    private Long id;
    private String name;
    private Integer value;
    private Boolean isUnique;

    public Item () {}

    public Item(String name, Integer value, Boolean isUnique) {
        this.name = name;
        this.value = value;
        this.isUnique = isUnique;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public Boolean getUnique() {
        return isUnique;
    }

    public void setUnique(Boolean unique) {
        isUnique = unique;
    }

    @Override
    public String toString() {
        return "Item{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", value=" + value +
                ", isUnique=" + isUnique +
                '}';
    }
}
