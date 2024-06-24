package org.blitmatthew.general.items;

public class Potion extends Item{
    private Integer heal;

    public Potion() {
        super();
    }

    public Potion(String name, Integer value, Boolean isUnique, Integer heal) {
        super(name, value, isUnique);
        this.heal = heal;
    }

    public Integer getHeal() {
        return heal;
    }

    public void setHeal(Integer heal) {
        this.heal = heal;
    }
}
