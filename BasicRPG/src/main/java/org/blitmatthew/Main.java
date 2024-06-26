package org.blitmatthew;

import org.blitmatthew.database.InventoryDao;
import org.blitmatthew.database.ItemDao;
import org.blitmatthew.database.PlayerDao;
import org.blitmatthew.general.Inventory;
import org.blitmatthew.general.items.Item;
import org.blitmatthew.general.items.Potion;
import org.blitmatthew.general.player.PlayerCharacter;
import org.blitmatthew.general.player.Race;

import java.util.List;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Random random = new Random();
//        PlayerCharacter playerCharacter = new PlayerCharacter(
//                "Zephyr",
//                (short) (random.nextInt(6) + random.nextInt(6) + random.nextInt(6)),
//                (short) (random.nextInt(6) + random.nextInt(6) + random.nextInt(6)),
//                (short) (random.nextInt(6) + random.nextInt(6) + random.nextInt(6)),
//                (short) (random.nextInt(6) + random.nextInt(6) + random.nextInt(6)),
//                Race.ELF);
        InventoryDao inventoryDao = new InventoryDao();
        PlayerDao playerDao = new PlayerDao(inventoryDao);
        ItemDao itemDao = new ItemDao();
//        playerCharacter = playerDao.save(playerCharacter);
        //System.out.println(playerCharacter);
        //itemDao.getAllItems().forEach(System.out::println);
        List<Item> items = itemDao.getAllItems();
        Potion healingPotion = (Potion) items.stream().filter(x -> x.getName().equalsIgnoreCase("healing potion")).findFirst().orElseThrow();

//        Item swordOfLight = items.stream().filter(x -> x.getName().equalsIgnoreCase("sword of light")).findFirst().orElseThrow();
//        inventoryDao.addItemToInventory(swordOfLight, 6l);
//        List<Item> inventory = inventoryDao.getInventoryOfPlayerCharacter(1l);
//        System.out.println(inventory);
        PlayerCharacter playerCharacter = playerDao.getPlayerCharacterByName("Zephyr");
//        playerCharacter.getInventory().addItem(healingPotion);
//        playerCharacter.getInventory().addItem(healingPotion);
//        playerCharacter.getInventory().addItem(healingPotion);
//        playerCharacter.getInventory().setGold(500);
//        inventoryDao.update(playerCharacter.getInventory());
        inventoryDao.removeItem(healingPotion, playerCharacter.getInventory().getId());
        playerCharacter = playerDao.getPlayerCharacterByName("Zephyr");

        System.out.println(playerCharacter);
    }
}