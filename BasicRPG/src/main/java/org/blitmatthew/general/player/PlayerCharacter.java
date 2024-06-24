package org.blitmatthew.general.player;

import org.blitmatthew.general.Inventory;
import org.blitmatthew.general.Sheet;

public class PlayerCharacter extends Sheet {
    private Race characterRace;
    private Inventory inventory;

    public PlayerCharacter(String name, Short strStat, Short dexStat, Short intStat, Short chrStat, Race characterRace) {
        super(name, strStat, dexStat, intStat, chrStat);
        this.characterRace = characterRace;
        this.inventory = new Inventory();
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

    @Override
    public String toString() {
        return "PlayerCharacter{" +
                "name" + this.getName() +
                "characterRace=" + characterRace +
                ", inventory=" + inventory +
                '}';
    }
}
