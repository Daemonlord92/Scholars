package org.blitmatthew.general;

import org.blitmatthew.general.items.Item;

import java.util.LinkedList;
import java.util.List;

public class Inventory {
    private Long id;
    private final List<Item> inventory;
    private Integer gold;

    public Inventory() {
        this.inventory = new LinkedList<>();
        this.gold = 0;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Item> getInventory() {
        return inventory;
    }

    public void addItem(Item item) {
        if(item.getUnique()) {
            if(this.inventory.contains(item)){
                System.out.println("Item " + item.getName()+ " is already in your inventory and is unique");
            } else {
                this.inventory.add(item);
            }
        } else {
            this.inventory.add(item);
        }
    }

    public Integer getGold() {
        return gold;
    }

    public void setGold(Integer gold) {
        this.gold = gold;
    }

    @Override
    public String toString() {
        return "Inventory{" +
                "id=" + id +
                ", inventory=" + inventory +
                ", gold=" + gold +
                '}';
    }
}
