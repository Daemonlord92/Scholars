package org.blitmatthew.general.monster;

import org.blitmatthew.general.Sheet;

public class Monster extends Sheet {
    private Integer hitPoints;
    private Integer damage;
    private Long locationId;

    public Monster() {
        super();
    }

    public Monster(String name, Short strStat, Short dexStat, Short intStat, Short chrStat, Integer hitPoints, Integer damage) {
        super(name, strStat, dexStat, intStat, chrStat);
        this.hitPoints = hitPoints;
        this.damage = damage;
    }

    public Integer getHitPoints() {
        return hitPoints;
    }

    public void setHitPoints(Integer hitPoints) {
        this.hitPoints = hitPoints;
    }

    public Integer getDamage() {
        return damage;
    }

    public void setDamage(Integer damage) {
        this.damage = damage;
    }

    public Long getLocationId() {
        return locationId;
    }

    public void setLocationId(Long locationId) {
        this.locationId = locationId;
    }
}
