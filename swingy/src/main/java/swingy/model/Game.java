/* ************************************************************************** */
/*                                                                            */
/*                                                        :::      ::::::::   */
/*   Game.java                                          :+:      :+:    :+:   */
/*                                                    +:+ +:+         +:+     */
/*   By: svan-nie <marvin@42.fr>                    +#+  +:+       +#+        */
/*                                                +#+#+#+#+#+   +#+           */
/*   Created: 2020/09/17 19:50:59 by svan-nie          #+#    #+#             */
/*   Updated: 2020/09/17 19:50:59 by svan-nie         ###   ########.fr       */
/*                                                                            */
/* ************************************************************************** */

package swingy.model;

import swingy.model.hero.CreateHero;
import swingy.model.monster.CreateMonster;
import swingy.model.hero.Hero;
import swingy.model.hero.HeroCheck;
import swingy.model.monster.Monster;

import swingy.controller.GameController;
import swingy.model.Map;
//mayberemove
import java.util.*;
import java.util.concurrent.TimeUnit;

public class Game{
    private Scanner scan = new Scanner(System.in);
    private Random random = new Random();
    private ArrayList<String> monsterList = new ArrayList<>(Arrays.asList("Dragon", "Witch", "Ogre"));
    private ArrayList<String> weaponList = new ArrayList<>(Arrays.asList("Bronze sword", "Iron Sword", "Silver Sword", "Dragon Sword"));
    private ArrayList<String> helmList = new ArrayList<>(Arrays.asList("Bronze Helm", "Iron Helm", "Silver Helm", "Dragon Helm"));
    private ArrayList<String> armourList = new ArrayList<>(Arrays.asList("Bronze Armour", "Iron Armour", "Silver Armour", "Dragon Armour"));
    private static Map map = null;
    private static Hero player = null;
    private static Monster monster = null;
    private static GameController gameController;

    public Game(GameController gameController){
        Game.gameController = gameController;
        map = new Map();
    }

    public void createCharacter(String heroName, String charClass){
        player = CreateHero.newHero(heroName, charClass);
        if (HeroCheck.nameCheck(player)) {
            try {
                TimeUnit.SECONDS.sleep(1);
                gameController.characterCreate();
                
            } catch (Exception e) {
                System.out.println("ERROR: Please contact support");
            }
		}
    }
    public void createMonster(String monsterName, String monsterClass){
        monster = CreateMonster.newMonster(monsterName, monsterClass);
    }

    public int[] loadingGame(){
        int[] mapLocation;
        player = CreateHero.loadHero("noName", "noName");
        mapLocation = player.loadGame();
        if (HeroCheck.nameCheck(player)) {
            try {
                TimeUnit.SECONDS.sleep(1);
                gameController.characterCreate();
                
            } catch (Exception e) {
                System.out.println("ERROR: Please contact support");
            }
		}
        return mapLocation;
    }

    public Hero getHero(){
        return player;
    }
    public void creatingMap(){
        try {
            System.out.println("Generating Map...");
            map.generateMap(player.getLevel());
            System.out.println("Adding player to map");
            map.addPlayerToMap();
            System.out.println("Adding Monsters to map");
            map.addMonstersToMap();
        } catch (Exception e) {
            System.out.println("Error: Please contract support.");
        }
        gameController.startGame(map.getMap(), map.getMapSize(), player);
    }

    public void guiCreatingMap(){
        try {
            System.out.println("Generating Map...");
            map.generateMap(player.getLevel());
            System.out.println("Adding player to map");
            map.addPlayerToMap();
            System.out.println("Adding Monsters to map");
            map.addMonstersToMap();
        } catch (Exception e) {
            System.out.println("Error: Please contract support.");
        }
        gameController.guiStartGame(map.getMap(), map.getMapSize(), player);
    }

    public void LoadedPlayerMap(int[] playerLocation){
        try {
            System.out.println("Generating Map...");
            map.generateMap(player.getLevel());
            System.out.println("Adding Monsters to map");
            map.addMonstersToMap();
            System.out.println("Adding player to map");
            map.addLoadedPlayerToMap(playerLocation);
        } catch (Exception e) {
            System.out.println("Error: Please contract support.");
        }
        gameController.startGame(map.getMap(), map.getMapSize(), player);
    }

    public void guiLoadedPlayerMap(int[] playerLocation){
        try {
            System.out.println("Generating Map...");
            map.generateMap(player.getLevel());
            System.out.println("Adding Monsters to map");
            map.addMonstersToMap();
            System.out.println("Adding player to map");
            map.addLoadedPlayerToMap(playerLocation);
        } catch (Exception e) {
            System.out.println("Error: Please contract support.");
        }
        gameController.guiStartGame(map.getMap(), map.getMapSize(), player);
    }

    public void guiLoadedPlayerMapSilent(int[] playerLocation){
        try {
            // System.out.println("Generating Map...");
            map.generateMap(player.getLevel());
            // System.out.println("Adding Monsters to map");
            map.addMonstersToMap();
            // System.out.println("Adding player to map");
            map.addLoadedPlayerToMap(playerLocation);
        } catch (Exception e) {
            System.out.println("Error: Please contract support.");
        }
        gameController.guiStartGame(map.getMap(), map.getMapSize(), player);
    }

    public void guicreatingNewMap(){
        try {
            //                                                         create a new fram to quit or exit then display startgame fram again
            map.generateMap(player.getLevel());
            gameController.guiCreateNewMap(map.getMap(), map.getMapSize(),player);
        } catch (Exception e) {
            System.out.println("Error: Please contract support.");
        }
        gameController.guiStartGame(map.getMap(), map.getMapSize(), player);
    }

    public void creatingNewMap(){
        try {
            gameController.createNewMap();
            System.out.println("Generating Map...");
            map.generateMap(player.getLevel());
            System.out.println("Adding player to map");
            map.addPlayerToMap();
            System.out.println("Adding Monsters to map");
            map.addMonstersToMap();
        } catch (Exception e) {
            System.out.println("Error: Please contract support.");
        }
        gameController.startGame(map.getMap(), map.getMapSize(), player);
    }

    public void guiCommandWhereToMove(String command, char map[][], int count){
        if (command.toLowerCase().equals("north")){
            guimovingAroundMap(command, map, count);
        }else if (command.toLowerCase().equals("south")){
            guimovingAroundMap(command, map, count);
        }else if (command.toLowerCase().equals("east")){
            guimovingAroundMap(command, map, count);
        }else if (command.toLowerCase().equals("west")){
            guimovingAroundMap(command, map, count);
        }else if (command.toLowerCase().equals("save")){
            int[] location;
            location = getHeroPostion(map);
            player.saveGame(location);
        }else if (command.toLowerCase().equals("quit")){
            System.exit(2);
        }
}

public void saveGameFile(char[][] map, int mapsize, Hero player){
    int[] location = new int[2];
    int rnd = 0;
    int rnd2 = 0;
    int mapSizee = (player.getLevel() - 1) * 5 + 10 - (player.getLevel() % 2);
    rnd = random.nextInt(mapSizee);
    rnd2 = random.nextInt(mapSizee);
    location[0] = rnd;
    location[1] = rnd2;
    player.saveGame(location);
    System.out.println("save successful");
}

public void guimovingAroundMap(String command, char map[][], int count){
    int[] location;
    System.out.println(command);
    location = getHeroPostion(map);
    guiCalculateMove(command, location, map, count);
}

public int getRandomRoll(int number){
    Random random = new Random();
    if (number == 100){
        return random.nextInt(100);
    }else if (number == 6){
        return random.nextInt(6);
    }
    else if (number == 3){
        return random.nextInt(3);
    }
    return 0;
}

public void guiCalculateMove(String command, int[] location, char map[][], int count){
    int xAxis = 0;
    int yAxis = 0;
    String postion = null;
    String userInput = null;
    String newCommand = null;
    Random random = new Random();
    int getrandom = 0;
    xAxis = location[0];
    yAxis = location[1];
    try {
    if (command.toLowerCase().equals("north")){
            xAxis--;
            postion = String.valueOf(map[xAxis][yAxis]);
            if (postion.equals("E")){
                map[xAxis][yAxis] = 'O';
                gameController.fightingOrRunning(command, location, map, userInput, player);
            }else{
                map[location[0]][yAxis] = 'O';
                map[xAxis][yAxis] = 'P';
                gameController.guiStartGameWithOutMapSize(map, player, count);
            }
        }else if (command.toLowerCase().equals("south")){
            xAxis++;
            postion = String.valueOf(map[xAxis][yAxis]);
            if (postion.equals("E")){
                map[xAxis][yAxis] = 'O';
                gameController.fightingOrRunning(command, location, map, userInput, player);
            }else{
                map[location[0]][yAxis] = 'O';
                map[xAxis][yAxis] = 'P';
            }
        }else if (command.toLowerCase().equals("east")){
            yAxis++;
            postion = String.valueOf(map[xAxis][yAxis]);
            if (postion.equals("E")){
                map[xAxis][yAxis] = 'O';
                gameController.fightingOrRunning(command, location, map, userInput, player);
            }else{
                map[xAxis][location[1]] = 'O';
                map[xAxis][yAxis] = 'P';
            }
        }else if (command.toLowerCase().equals("west")){
            yAxis--;
            postion = String.valueOf(map[xAxis][yAxis]);
            if (postion.equals("E")){
                map[xAxis][yAxis] = 'O';
                gameController.fightingOrRunning(command, location, map, userInput, player);
            }else{
                map[xAxis][location[1]] = 'O';
                map[xAxis][yAxis] = 'P';
            }
        }
        } catch (ArrayIndexOutOfBoundsException e) {
            guicreatingNewMap();
        }
}
public void guiEngageMonster(){
    int whoFightsFirst = 0;
    int heroNewHealth = 0;
    int monsterNewHealth = 0;
    int monsterExp = 0;
    int currentLevel = 0;
    String playerOrMonsterFirst = null;
    currentLevel = player.getLevel();
    whoFightsFirst = random.nextInt(100);
    String monsterToFight = null;
    monsterToFight = monsterList.get(random.nextInt(monsterList.size())); // gui not displaying right monster
    gameController.guiMonsterEngageing(monsterToFight, 0);
    createMonster(monsterToFight, monsterToFight);
    monsterExp = monster.getXpGiven();
    if (whoFightsFirst <= 50){
        playerOrMonsterFirst = "player";
        gameController.whoFightsFirstone(playerOrMonsterFirst);
    }else if (whoFightsFirst >= 50){
        playerOrMonsterFirst = "monster";
        gameController.whoFightsFirstone(playerOrMonsterFirst);
    }
    while (true){
        if (whoFightsFirst <= 50){
            int heroAttack = player.getAttack();
            int monsterTotalAttack = monster.getAttack() - player.getDefence();
            monsterNewHealth = monster.getHealth() - heroAttack;
            monster.setNewHealth(monsterNewHealth);
            if (monster.getHealth() <= 0){
                gameController.guiMonsterEngageing(monsterToFight, 1);
                gameController.amountOfExp(monsterExp);
                player.setXp(monster.getXpGiven());
                player.expPerLevel();
                if (currentLevel > player.getLevel()){
                    gameController.playerLevel(player.getLevel());
                }
                // itemDrop();
                break;
            }
            heroNewHealth = player.getHealth() - monsterTotalAttack;
            player.setNewHealth(heroNewHealth);
            if (player.getHealth() <= 0)
            {
                System.out.println("you died!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
                // gameController.herosDeath();
            }
        }else if (whoFightsFirst >= 50){
            int heroAttack = player.getAttack();
            int monsterTotalAttack = monster.getAttack() - player.getDefence();
            heroNewHealth = player.getHealth() - monsterTotalAttack;
            player.setNewHealth(heroNewHealth);
            if (player.getHealth() <= 0)
            {
                System.out.println("you died!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
                // gameController.herosDeath();
            }
            monsterNewHealth = monster.getHealth() - heroAttack;
            monster.setNewHealth(monsterNewHealth);
            if (monster.getHealth() <= 0){
                gameController.guiMonsterEngageing(monsterToFight, 1);
                gameController.amountOfExp(monsterExp);
                player.setXp(monster.getXpGiven());
                player.expPerLevel();
                if (currentLevel > player.getLevel()){ // might not be working
                    gameController.playerLevel(player.getLevel());
                }
                // itemDrop();
                break;
            }
        }
    }
}

public void guiItemDrop(){
    int itemDrop = 0;
    String newCommand = null;
    String typeOfItem = null;
    itemDrop = random.nextInt(3);
    if(itemDrop == 0){
        String WeaponDrop = weaponList.get(random.nextInt(weaponList.size()));
        // newCommand = gameController.itemDrops(WeaponDrop);
        typeOfItem = "weapon";
        gameController.guiItemDrops(WeaponDrop, typeOfItem);
        // if (newCommand.equals("yes")){
        //     player.setAttackWithWeapon(WeaponDrop);
        // }
    }else if (itemDrop == 1){
        String armourDrop = armourList.get(random.nextInt(armourList.size()));
        // newCommand = gameController.itemDrops(armourDrop);
        typeOfItem = "armour";
        gameController.guiItemDrops(armourDrop, typeOfItem);
        // if (newCommand.equals("yes")){
        //     player.setDefenceWithArmour(armourDrop);
        // }
    }else if (itemDrop == 2){
        String helmDrop = helmList.get(random.nextInt(helmList.size()));
        // newCommand = gameController.itemDrops(helmDrop);
        typeOfItem = "helm";
        gameController.guiItemDrops(helmDrop, typeOfItem);
        // if (newCommand.equals("yes")){
        //     player.setHealthWithHelm(helmDrop);
        // }
    }
}

public void dontWantItem(){
   gameController.guiStartGameWithOutMapSize(map.getMap(), player, 0);
}
public void WantItem(String itemName, String typeOfItem){
    if (typeOfItem.toLowerCase().equals("weapon")){
        player.setAttackWithWeapon(itemName);
    }else if (typeOfItem.toLowerCase().equals("armour")){
        player.setDefenceWithArmour(itemName);
    }else if (typeOfItem.toLowerCase().equals("helm")){
        player.setHealthWithHelm(itemName);
    }
    gameController.guiStartGameWithOutMapSize(map.getMap(), player, 0);
}

    public void commandWhereToMove(String command, char map[][]){
            if (command.toLowerCase().equals("north")){
                movingAroundMap(command, map);
            }else if (command.toLowerCase().equals("south")){
                movingAroundMap(command, map);
            }else if (command.toLowerCase().equals("east")){
                movingAroundMap(command, map);
            }else if (command.toLowerCase().equals("west")){
                movingAroundMap(command, map);
            }else if (command.toLowerCase().equals("save")){
                int[] location;
                location = getHeroPostion(map);
                player.saveGame(location);
            }else if (command.toLowerCase().equals("quit")){
                System.exit(2);
            }
    }

    public void movingAroundMap(String command, char map[][]){
        int[] location;
        location = getHeroPostion(map);
        calculateMove(command, location, map);
    }

    public void calculateMove(String command, int[] location, char map[][]){
        int xAxis = 0;
        int yAxis = 0;
        String postion = null;
        String newCommand = null;
        Random random = new Random();
        int getrandom = 0;
        xAxis = location[0];
        yAxis = location[1];
        try {
        if (command.toLowerCase().equals("north")){
                gameController.moveCommandDisplay(command);
                xAxis--;
                postion = String.valueOf(map[xAxis][yAxis]);
                if (postion.equals("E")){
                    newCommand = gameController.engageMonsterOrRun(command);
                    if (newCommand.equals("fight")){
                        engageMonster();
                        map[location[0]][yAxis] = 'O';
                        map[xAxis][yAxis] = 'P';
                    }else if (newCommand.equals("run")){
                        getrandom = random.nextInt(100);
                        if (getrandom < 50){
                            gameController.failedToRun();
                            engageMonster();
                            map[location[0]][yAxis] = 'O';
                            map[xAxis][yAxis] = 'P';
                        }else
                        gameController.escaped();
                    }
                }else{
                    map[location[0]][yAxis] = 'O';
                    map[xAxis][yAxis] = 'P';
                }
            }else if (command.toLowerCase().equals("south")){
                gameController.moveCommandDisplay(command);
                xAxis++;
                postion = String.valueOf(map[xAxis][yAxis]);
                if (postion.equals("E")){
                    newCommand = gameController.engageMonsterOrRun(command);
                    if (newCommand.equals("fight")){
                        engageMonster();
                        map[location[0]][yAxis] = 'O';
                        map[xAxis][yAxis] = 'P';
                    }else if (newCommand.equals("run")){
                        getrandom = random.nextInt(100);
                        if (getrandom < 50){
                            gameController.failedToRun();
                            engageMonster();
                            map[location[0]][yAxis] = 'O';
                            map[xAxis][yAxis] = 'P';
                        }else
                        gameController.escaped();
                    }
                }else{
                    map[location[0]][yAxis] = 'O';
                    map[xAxis][yAxis] = 'P';
                }
            }else if (command.toLowerCase().equals("east")){
                gameController.moveCommandDisplay(command);
                yAxis++;
                postion = String.valueOf(map[xAxis][yAxis]);
                if (postion.equals("E")){
                    newCommand = gameController.engageMonsterOrRun(command);
                    if (newCommand.equals("fight")){
                        engageMonster();
                        map[xAxis][location[1]] = 'O';
                        map[xAxis][yAxis] = 'P';
                    }else if (newCommand.equals("run")){
                        getrandom = random.nextInt(100);
                        if (getrandom < 50){
                            gameController.failedToRun();
                            engageMonster();
                            map[xAxis][location[1]] = 'O';
                            map[xAxis][yAxis] = 'P';
                        }else
                        gameController.escaped();
                    }
                }else{
                    map[xAxis][location[1]] = 'O';
                    map[xAxis][yAxis] = 'P';
                }
            }else if (command.toLowerCase().equals("west")){
                gameController.moveCommandDisplay(command);
                yAxis--;
                postion = String.valueOf(map[xAxis][yAxis]);
                if (postion.equals("E")){
                    newCommand = gameController.engageMonsterOrRun(command);
                    if (newCommand.equals("fight")){
                        engageMonster();
                        map[xAxis][location[1]] = 'O';
                        map[xAxis][yAxis] = 'P';
                    }else if (newCommand.equals("run")){
                        getrandom = random.nextInt(100);
                        if (getrandom < 50){
                            gameController.failedToRun();
                            engageMonster();
                            map[xAxis][location[1]] = 'O';
                            map[xAxis][yAxis] = 'P';
                        }else
                        gameController.escaped();
                    }
                }else{
                    map[xAxis][location[1]] = 'O';
                    map[xAxis][yAxis] = 'P';
                }
            }
            } catch (ArrayIndexOutOfBoundsException e) {
                creatingNewMap();
            }
    }
    
    public void engageMonster(){
        int whoFightsFirst = 0;
        int heroNewHealth = 0;
        int monsterNewHealth = 0;
        whoFightsFirst = random.nextInt(100);
        String monsterToFight = null;
        monsterToFight = monsterList.get(random.nextInt(monsterList.size()));
        gameController.monsterEngageing(monsterToFight, 1);
        createMonster(monsterToFight, monsterToFight);
        if (whoFightsFirst <= 50){
            gameController.attackFirstPlayerMonster(0);
        }else if (whoFightsFirst >= 50){
            gameController.attackFirstPlayerMonster(1);
        }
        while (true){
            if (whoFightsFirst <= 50){
                int heroAttack = player.getAttack();
                int monsterTotalAttack = monster.getAttack() - player.getDefence();
                monsterNewHealth = monster.getHealth() - heroAttack;
                monster.setNewHealth(monsterNewHealth);
                if (monster.getHealth() <= 0){
                    gameController.monsterEngageing(monsterToFight, 0);
                    System.out.println("You have earned "+monster.getXpGiven()+" Exp");
                    player.setXp(monster.getXpGiven());
                    player.expPerLevel();
                    itemDrop();
                    break;
                }
                heroNewHealth = player.getHealth() - monsterTotalAttack;
                player.setNewHealth(heroNewHealth);
                if (player.getHealth() <= 0)
                {
                    gameController.herosDeath();
                }
            }else if (whoFightsFirst >= 50){
                int heroAttack = player.getAttack();
                int monsterTotalAttack = monster.getAttack() - player.getDefence();
                heroNewHealth = player.getHealth() - monsterTotalAttack;
                player.setNewHealth(heroNewHealth);
                if (player.getHealth() <= 0)
                {
                    gameController.herosDeath();
                }
                monsterNewHealth = monster.getHealth() - heroAttack;
                monster.setNewHealth(monsterNewHealth);
                if (monster.getHealth() <= 0){
                    gameController.monsterEngageing(monsterToFight, 0);
                    System.out.println("You have earned "+monster.getXpGiven()+" Exp");
                    player.setXp(monster.getXpGiven());
                    player.expPerLevel();
                    itemDrop();
                    break;
                }
            }
        }
    }

    public void itemDrop(){
        int itemDrop = 0;
        String newCommand = null;
        itemDrop = random.nextInt(6);
        if(itemDrop == 0){
            String WeaponDrop = weaponList.get(random.nextInt(weaponList.size()));
            newCommand = gameController.itemDrops(WeaponDrop);
            if (newCommand.equals("yes")){
                player.setAttackWithWeapon(WeaponDrop);
            }
        }else if (itemDrop == 1){
            String armourDrop = armourList.get(random.nextInt(armourList.size()));
            newCommand = gameController.itemDrops(armourDrop);
            if (newCommand.equals("yes")){
                player.setDefenceWithArmour(armourDrop);
            }
        }else if (itemDrop == 2){
            String helmDrop = helmList.get(random.nextInt(helmList.size()));
            newCommand = gameController.itemDrops(helmDrop);
            if (newCommand.equals("yes")){
                player.setHealthWithHelm(helmDrop);
            }
        }
    }

    public int[] getHeroPostion(char map[][]){
        String postion = null;
        int[] location = new int[2];
        while (location[0] < map.length)
        {
            while (location[1] < map[location[0]].length)
            {
                postion = String.valueOf(map[location[0]][location[1]]);
                if (postion.equals("P"))
                {
                    break;
                }
                location[1]++;
            }
            if (postion.equals("P"))
            break;
            location[1] = 0;
            location[0]++;
        }
        return location;
    }

    public Hero getPlayer() {
		return player;
    }
}