package org.blitmatthew.general.player;

import org.blitmatthew.general.Inventory;
import org.blitmatthew.general.Sheet;

import java.util.Random;

public class PlayerCharacter extends Sheet {
    private Integer hitPoints;
    private Race characterRace;
    private Inventory inventory;

    public PlayerCharacter() {
        super();
    }

    public PlayerCharacter(String name, Short strStat, Short dexStat, Short intStat, Short chrStat, Race characterRace) {
        super(name, strStat, dexStat, intStat, chrStat);
        this.characterRace = characterRace;
        this.inventory = new Inventory();
        this.hitPoints = this.getStrBonus() + new Random().nextInt(12) + 1;
    }

    public Race getCharacterRace() {
        return characterRace;
    }

    public void setCharacterRace(Race characterRace) {
        this.characterRace = characterRace;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }

    public Integer getHitPoints() {
        return hitPoints;
    }

    public void setHitPoints(Integer hitPoints) {
        this.hitPoints = hitPoints;
    }

    @Override
    public String toString() {
        return "PlayerCharacter{" +
                " name= " + this.getName() +
                ", characterRace= " + characterRace +
                ", strStat= " + this.getStrStat() +
                ", dexStat= " + this.getDexStat() +
                ", intStat= " + this.getIntStat() +
                ", chrStat= " + this.getChrStat() +
                ", inventory=" + inventory +
                '}';
    }
}
