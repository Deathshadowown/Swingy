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
import swingy.model.monster.Monster;

import swingy.controller.GameController;
import swingy.model.Map;
//mayberemove
import java.util.*;

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
        // gameController.info(player);
        // map.generateMap(player.getLevel());
        // char currentMap[][] = map.getMap();
        // map.printMap(currentMap);
    }
    public void createMonster(String monsterName, String monsterClass){
        monster = CreateMonster.newMonster(monsterName, monsterClass);
    }

    public int[] loadingGame(){
        int[] mapLocation;
        player = CreateHero.loadHero("noName", "noName");
        mapLocation = player.loadGame();
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

    public void commandWhereToMove(String command, char map[][]){
            if (command.toLowerCase().equals("north")){
                // System.out.println("You choose north");
                movingAroundMap(command, map);
            }else if (command.toLowerCase().equals("south")){
                // System.out.println("You choose south");
                movingAroundMap(command, map);
            }else if (command.toLowerCase().equals("east")){
                // System.out.println("You choose east");
                movingAroundMap(command, map);
            }else if (command.toLowerCase().equals("west")){
                // System.out.println("You choose west");
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
        System.out.println(command);
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
                        System.out.println(getrandom);
                        if (getrandom < 50){
                            gameController.failedToRun();
                            engageMonster();
                            map[location[0]][yAxis] = 'O';
                            map[xAxis][yAxis] = 'P';
                        }
                        // make message form console do later
                        System.out.println("You got away!!.");
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
                        System.out.println(getrandom);
                        if (getrandom < 50){
                            gameController.failedToRun();
                            engageMonster();
                            map[location[0]][yAxis] = 'O';
                            map[xAxis][yAxis] = 'P';
                        }
                        // make message form console do later
                        System.out.println("You got away!!.");
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
                        System.out.println(getrandom);
                        if (getrandom < 50){
                            gameController.failedToRun();
                            engageMonster();
                            map[xAxis][location[1]] = 'O';
                            map[xAxis][yAxis] = 'P';
                        }
                        // make message form console do later
                        System.out.println("You got away!!.");
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
                        System.out.println(getrandom);
                        if (getrandom < 50){
                            gameController.failedToRun();
                            engageMonster();
                            map[xAxis][location[1]] = 'O';
                            map[xAxis][yAxis] = 'P';
                        }
                        // make message form console do later
                        System.out.println("You got away!!.");
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
        //create monster here.
        gameController.monsterEngageing(monsterToFight, 0);
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
                    gameController.monsterEngageing(monsterToFight, 1);
                    // System.out.println("You have Deafeated "+monsterToFight); // add to console
                    System.out.println("You have earned "+monster.getXpGiven()+" Exp"); // add to console
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
                    gameController.monsterEngageing(monsterToFight, 1);
                    System.out.println("You have earned "+monster.getXpGiven()+" Exp"); // add to console
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