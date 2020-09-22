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
import java.util.Random;

public class Game{
    private Scanner scan = new Scanner(System.in);
    private ArrayList<String> monsterList = new ArrayList<>(Arrays.asList("Dragon", "Witch", "Ogre")); // make armour as well
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
            // must add enimies to map here
            // System.out.println("Displaying Map for Player");
            // char currentMap[][] = map.getMap();
            // map.printMap(currentMap);
        } catch (Exception e) {
            //TODO: handle exception
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
                System.out.println("You choose north");
                movingAroundMap(command, map);
            }else if (command.toLowerCase().equals("south")){
                System.out.println("You choose south");
                movingAroundMap(command, map);
            }else if (command.toLowerCase().equals("east")){
                System.out.println("You choose east");
                movingAroundMap(command, map);
            }else if (command.toLowerCase().equals("west")){
                System.out.println("You choose west");
                movingAroundMap(command, map);
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
                System.out.println("You choose north");
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
                System.out.println("You choose south");
                xAxis++;
                map[location[0]][yAxis] = 'O';
                map[xAxis][yAxis] = 'P';
            }else if (command.toLowerCase().equals("east")){
                System.out.println("You choose east");
                yAxis++;
                map[xAxis][location[1]] = 'O';
                map[xAxis][yAxis] = 'P';
            }else if (command.toLowerCase().equals("west")){
                System.out.println("You choose west");
                yAxis--;
                map[xAxis][location[1]] = 'O';
                map[xAxis][yAxis] = 'P';
            }
            } catch (ArrayIndexOutOfBoundsException e) {
                creatingNewMap();
            }
    }
    
    public void engageMonster(){
        Random random = new Random();
        int whoFightsFirst = 0;
        int heroNewHealth = 0;
        int monsterNewHealth = 0;
        whoFightsFirst = random.nextInt(100);
        String monsterToFight = null;
        System.out.print("You going to fight: "); // make it go to console
        monsterToFight = monsterList.get(random.nextInt(monsterList.size()));
        //create monster here.
        System.out.println(monsterToFight); // make it go to console
        createMonster(monsterToFight, monsterToFight);
        if (whoFightsFirst <= 50){
            System.out.println("Player Attacks First!!");
        }else if (whoFightsFirst >= 50){
            System.out.println("Monster Attacks First!!");
        }
        while (true){
            if (whoFightsFirst <= 50){
                // monsteAttack = monster.getAttack();
                // heroDefence = player.getDefence();//getAttack
                int heroAttack = player.getAttack();
                int monsterTotalAttack = monster.getAttack() - player.getDefence();
                monsterNewHealth = monster.getHealth() - heroAttack;
                monster.setNewHealth(monsterNewHealth);
                if (monster.getHealth() <= 0){
                    System.out.println("You have Deafeated "+monsterToFight); // add to console
                    break;
                }
                heroNewHealth = player.getHealth() - monsterTotalAttack;
                player.setNewHealth(heroNewHealth);
                if (player.getHealth() <= 0)
                {
                    System.out.println("You have Died, may you rest in peace"); // add to console
                    System.exit(2);
                }
            }else if (whoFightsFirst >= 50){
                int heroAttack = player.getAttack();
                int monsterTotalAttack = monster.getAttack() - player.getDefence();
                heroNewHealth = player.getHealth() - monsterTotalAttack;
                player.setNewHealth(heroNewHealth);
                if (player.getHealth() <= 0)
                {
                    System.out.println("You have Died, may you rest in peace"); // add to console
                    System.exit(2);
                }
                monsterNewHealth = monster.getHealth() - heroAttack;
                monster.setNewHealth(monsterNewHealth);
                if (monster.getHealth() <= 0){
                    System.out.println("You have Deafeated "+monsterToFight); // add to console
                    break;
                }
            }
        }
        // System.exit(2);
        // random monster function
        // switch statment for random monster spawn
        //under here place in if statments--------------
        // function to choose who attacks first
        // function to check both attacks
        // function to - hp from monster or hero
        // function to display gameover if dead
        // function to gain exp
        // function to show you deafeted monster
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