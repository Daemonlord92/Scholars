package org.blitmatthew.general.items;

public class Weapon extends Item{
    private Integer damage;
    private Integer damageBonus;

    public Weapon() {
        super();
    }

    public Weapon(String name, Integer value, Boolean isUnique, Integer damage, Integer damageBonus) {
        super(name, value, isUnique);
        this.damage = damage;
        this.damageBonus = damageBonus;
    }

    public Integer getDamage() {
        return damage;
    }

    public void setDamage(Integer damage) {
        this.damage = damage;
    }

    public Integer getDamageBonus() {
        return damageBonus;
    }

    public void setDamageBonus(Integer damageBonus) {
        this.damageBonus = damageBonus;
    }
}
