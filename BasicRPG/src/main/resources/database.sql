CREATE TABLE player_character(
id BIGINT AUTO_INCREMENT PRIMARY KEY,
name VARCHAR(300) NOT NULL,
race VARCHAR(50) NOT NULL,
str_stat INT NOT NULL,
str_bonus INT NOT NULL,
dex_stat INT NOT NULL,
dex_bonus INT NOT NULL,
int_stat INT NOT NULL,
int_bonus INT NOT NULL,
chr_stat INT NOT NULL,
chr_bonus INT NOT NULL);

CREATE TABLE item (
id BIGINT AUTO_INCREMENT PRIMARY KEY,
name VARCHAR(300) NOT NULL,
value INT NOT NULL,
is_unique BOOLEAN NOT NULL,
damage INT,
damage_bonus INT,
heal INT);

CREATE TABLE inventory(
    -> id BIGINT AUTO_INCREMENT PRIMARY KEY,
    -> gold INT DEFAULT 0);

CREATE TABLE inventory_item(
    -> inventory_id BIGINT,
    -> item_id BIGINT,
    -> quantity INT DEFAULT 1,
    -> PRIMARY KEY (inventory_id, item_id),
    -> FOREIGN KEY (inventory_id)
    -> REFERENCES inventory(id)
    -> ON DELETE CASCADE,
    -> FOREIGN KEY (item_id)
    -> REFERENCES item(id)
    -> ON DELETE CASCADE);

INSERT INTO item (name, value, is_unique, damage, damage_bonus, heal)
VALUES
('Sword of Light', 150, TRUE, 30, 5, NULL),
('Healing Potion', 25, FALSE, NULL, NULL, 50),
('Fire Staff', 120, FALSE, 25, 10, NULL),
('Ice Dagger', 90, TRUE, 20, 15, NULL),
('Magic Elixir', 45, FALSE, NULL, NULL, 30),
('Shadow Blade', 200, TRUE, 35, 5, NULL),
('Thunder Hammer', 160, TRUE, 40, 20, NULL),
('Minor Healing Potion', 15, FALSE, NULL, NULL, 20),
('Enchanted Shield', 130, TRUE, NULL, NULL, NULL),
('Antidote', 30, FALSE, NULL, NULL, 25),
('Ring of Strength', 110, TRUE, NULL, 10, NULL),
('Necromancer Staff', 180, TRUE, 25, 25, NULL),
('Invisibility Cloak', 250, TRUE, NULL, NULL, NULL);

INSERT INTO item (name, value, is_unique, damage, damage_bonus, heal)
VALUES
('Amulet of Protection', 80, FALSE, NULL, 5, NULL),
('Boots of Speed', 70, FALSE, NULL, NULL, NULL),
('Crystal Wand', 95, TRUE, 15, 20, NULL),
('Divine Robe', 110, TRUE, NULL, NULL, 10),
('Elixir of Fire Resistance', 40, FALSE, NULL, NULL, NULL),
('Flame Sword', 135, FALSE, 25, 10, NULL),
('Ghostly Armor', 200, TRUE, NULL, 10, NULL),
('Herbal Salve', 10, FALSE, NULL, NULL, 15),
('Illuminating Torch', 30, FALSE, NULL, NULL, NULL),
('Jewel of Wisdom', 90, TRUE, NULL, 10, NULL),
('Knight\'s Lance', 105, FALSE, 35, 5, NULL),
('Lightning Rod', 120, TRUE, 20, 20, NULL),
('Mystic Orb', 150, TRUE, NULL, 15, NULL),
('Night Vision Goggles', 75, FALSE, NULL, NULL, NULL),
('Oracle\'s Potion', 55, FALSE, NULL, NULL, 25),
('Poison Dagger', 85, FALSE, 15, NULL, NULL),
('Quiver of Endless Arrows', 100, TRUE, NULL, 10, NULL),
('Restorative Balm', 20, FALSE, NULL, NULL, 30),
('Staff of Healing', 65, FALSE, NULL, NULL, 40),
('Tome of Knowledge', 50, TRUE, NULL, NULL, NULL),
('Umbra Cloak', 115, TRUE, NULL, NULL, 10),
('Vitality Belt', 60, FALSE, NULL, NULL, 20),
('Windfury Bow', 130, TRUE, 30, 15, NULL),
('Xenon Crystal', 45, TRUE, NULL, 20, NULL),
('Zephyr Blade', 140, TRUE, 25, 5, NULL);

INSERT INTO item (name, value, is_unique, damage, damage_bonus, heal)
VALUES
('Simple Sword', 20, FALSE, 10, NULL, NULL),
('Wooden Shield', 15, FALSE, NULL, 5, NULL),
('Basic Healing Potion', 5, FALSE, NULL, NULL, 10),
('Rusty Dagger', 10, FALSE, 5, NULL, NULL),
('Leather Armor', 25, FALSE, NULL, 5, NULL),
('Traveler\'s Boots', 10, FALSE, NULL, NULL, NULL),
('Small Backpack', 8, FALSE, NULL, NULL, NULL),
('Old Staff', 12, FALSE, 8, NULL, NULL),
('Worn Cloak', 7, FALSE, NULL, NULL, NULL),
('Tinderbox', 3, FALSE, NULL, NULL, NULL),
('Plain Bow', 18, FALSE, 9, NULL, NULL),
('Basic Quiver', 6, FALSE, NULL, 2, NULL),
('Iron Helm', 12, FALSE, NULL, 2, NULL),
('Cotton Gloves', 4, FALSE, NULL, NULL, NULL),
('Cheap Ring', 5, FALSE, NULL, NULL, NULL);

CREATE TABLE location(
    -> id BIGINT AUTO_INCREMENT PRIMARY KEY,
    -> name VARCHAR(300) NOT NULL);

INSERT INTO location (name)
VALUES
('Emerald City'),
('Silver Lake'),
('Mystic Forest'),
('Golden Sands'),
('Crystal Cove'),
('Shadow Valley'),
('Echo Mountains'),
('Lunar Plains'),
('Solar Peaks'),
('Rogue Island'),
('Twilight Town'),
('Starlight Village'),
('Moonbeam City'),
('Sunset Hills'),
('Radiant Bay'),
('Whispering Meadows'),
('Thunder Ridge'),
('Sapphire Lagoon'),
('Windy Cliffs'),
('Stormy Highlands'),
('Silent Marsh'),
('Burning Desert'),
('Frozen Wastes'),
('Glimmering Shores'),
('Haunted Woods'),
('Crimson Canyon'),
('Ancient Ruins'),
('Misty Cliffs'),
('Breezy Plateau'),
('Duskfall Valley');

CREATE TABLE monster(
    -> id BIGINT AUTO_INCREMENT PRIMARY KEY,
    -> name VARCHAR(300) NOT NULL,
    -> str_stat INT NOT NULL,
    -> str_bonus INT NOT NULL,
    -> dex_stat INT NOT NULL,
    -> dex_bonus INT NOT NULL,
    -> int_stat INT NOT NULL,
    -> int_bonus INT NOT NULL,
    -> chr_stat INT NOT NULL,
    -> chr_bonus INT NOT NULL,
    -> location_id BIGINT,
    -> FOREIGN KEY (location_id)
    -> REFERENCES location(id));

INSERT INTO monster (name, str_stat, str_bonus, dex_stat, dex_bonus, int_stat, int_bonus, chr_stat, chr_bonus, location_id)
VALUES
('Goblin', 12, 1, 14, 2, 8, -1, 6, -2, 1),
('Troll', 18, 4, 8, -1, 6, -2, 4, -3, 2),
('Dragon', 20, 5, 10, 0, 16, 3, 14, 2, 3),
('Vampire', 14, 2, 16, 3, 12, 1, 18, 4, 4),
('Werewolf', 15, 2, 13, 1, 10, 0, 8, -1, 5),
('Zombie', 8, -1, 6, -2, 4, -3, 5, -3, 6),
('Witch', 10, 0, 12, 1, 18, 4, 16, 3, 7),
('Ghost', 6, -2, 18, 4, 14, 2, 12, 1, 8),
('Ogre', 16, 3, 8, -1, 6, -2, 7, -2, 9),
('Harpy', 12, 1, 17, 3, 13, 1, 15, 2, 10),
('Cyclops', 20, 5, 10, 0, 8, -1, 6, -2, 11),
('Sprite', 4, -3, 18, 4, 16, 3, 14, 2, 12),
('Siren', 10, 0, 15, 2, 14, 2, 17, 3, 13),
('Mummy', 14, 2, 8, -1, 10, 0, 12, 1, 14),
('Golem', 18, 4, 6, -2, 8, -1, 3, -4, 15),
('Fairy', 4, -3, 20, 5, 14, 2, 16, 3, 16),
('Ghoul', 13, 1, 15, 2, 7, -2, 6, -2, 17),
('Necromancer', 8, -1, 12, 1, 18, 4, 14, 2, 18),
('Imp', 6, -2, 17, 3, 14, 2, 10, 0, 19),
('Minotaur', 18, 4, 12, 1, 6, -2, 8, -1, 20),
('Banshee', 6, -2, 14, 2, 16, 3, 18, 4, 21),
('Wraith', 8, -1, 16, 3, 15, 2, 12, 1, 22),
('Sphinx', 14, 2, 10, 0, 18, 4, 16, 3, 23),
('Hydra', 16, 3, 12, 1, 10, 0, 8, -1, 24),
('Cerberus', 18, 4, 10, 0, 6, -2, 5, -3, 25),
('Phoenix', 12, 1, 18, 4, 16, 3, 20, 5, 26),
('Chimera', 17, 3, 14, 2, 12, 1, 9, -1, 27),
('Kraken', 20, 5, 14, 2, 8, -1, 6, -2, 28),
('Lich', 10, 0, 12, 1, 20, 5, 15, 2, 29),
('Griffin', 15, 2, 16, 3, 12, 1, 10, 0, 30),
('Yeti', 17, 3, 12, 1, 7, -2, 6, -2, 1),
('Basilisk', 14, 2, 8, -1, 15, 2, 10, 0, 2),
('Djinn', 12, 1, 18, 4, 16, 3, 14, 2, 3),
('Elf', 10, 0, 16, 3, 14, 2, 12, 1, 4),
('Dwarf', 16, 3, 12, 1, 10, 0, 8, -1, 5),
('Giant Spider', 12, 1, 16, 3, 6, -2, 4, -3, 6),
('Salamander', 8, -1, 18, 4, 12, 1, 10, 0, 7),
('Pixie', 4, -3, 20, 5, 15, 2, 18, 4, 8),
('Centaur', 14, 2, 16, 3, 10, 0, 12, 1, 9),
('Mermaid', 10, 0, 14, 2, 16, 3, 18, 4, 10),
('Orc', 16, 3, 10, 0, 8, -1, 6, -2, 11),
('Skeleton Warrior', 12, 1, 14, 2, 6, -2, 5, -3, 12),
('Sea Serpent', 16, 3, 16, 3, 12, 1, 8, -1, 13),
('Stone Golem', 18, 4, 6, -2, 10, 0, 4, -3, 14),
('Forest Nymph', 8, -1, 18, 4, 14, 2, 16, 3, 15),
('Sandworm', 14, 2, 8, -1, 6, -2, 5, -3, 16),
('Ice Elemental', 10, 0, 12, 1, 18, 4, 16, 3, 17),
('Fire Elemental', 12, 1, 14, 2, 18, 4, 10, 0, 18),
('Mountain Troll', 18, 4, 8, -1, 6, -2, 4, -3, 19),
('Shadow Demon', 14, 2, 18, 4, 16, 3, 12, 1, 20);
