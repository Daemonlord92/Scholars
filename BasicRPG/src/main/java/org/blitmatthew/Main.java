package org.blitmatthew;

import org.blitmatthew.database.InventoryDao;
import org.blitmatthew.database.ItemDao;
import org.blitmatthew.database.PlayerDao;
import org.blitmatthew.general.player.PlayerCharacter;
import org.blitmatthew.general.player.Race;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Random random = new Random();
//        PlayerCharacter playerCharacter = new PlayerCharacter(
//                "Test",
//                (short) (random.nextInt(6) + random.nextInt(6) + random.nextInt(6)),
//                (short) (random.nextInt(6) + random.nextInt(6) + random.nextInt(6)),
//                (short) (random.nextInt(6) + random.nextInt(6) + random.nextInt(6)),
//                (short) (random.nextInt(6) + random.nextInt(6) + random.nextInt(6)),
//                Race.GOBLIN);
        InventoryDao inventoryDao = new InventoryDao();
        PlayerDao playerDao = new PlayerDao(inventoryDao);
        ItemDao itemDao = new ItemDao();
        //playerCharacter = playerDao.save(playerCharacter);
        //System.out.println(playerCharacter);
        //itemDao.getAllItems().forEach(System.out::println);
    }
}