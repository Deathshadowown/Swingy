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
import swingy.model.hero.Hero;

import swingy.controller.GameController;
import swingy.model.Map;
//mayberemove
import java.util.*;

public class Game{
    private static Map map = null;
    private static Hero player = null;
    private static GameController gameController;
    private Scanner scan = new Scanner(System.in);

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
    
    public Hero getHero(){
        return player;
    }
    public void creatingMap(){
        try {
            System.out.println("Generating Map...");
            map.generateMap(player.getLevel());
            System.out.println("Adding player to map");
            map.addPlayerToMap();
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
            // must add enimies to map here
            // System.out.println("Displaying Map for Player");
            // char currentMap[][] = map.getMap();
            // map.printMap(currentMap);
        } catch (Exception e) {
            //TODO: handle exception
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
        xAxis = location[0];
        yAxis = location[1];
        try {
        if (command.toLowerCase().equals("north")){
                System.out.println("You choose north");
                xAxis--;
                System.out.println(xAxis);
                System.out.println(yAxis);
                map[location[0]][yAxis] = 'O';
                map[xAxis][yAxis] = 'P';
                
            }else if (command.toLowerCase().equals("south")){
                System.out.println("You choose south");
                xAxis++;
                System.out.println(xAxis);
                System.out.println(yAxis);
                map[location[0]][yAxis] = 'O';
                map[xAxis][yAxis] = 'P';
            }else if (command.toLowerCase().equals("east")){
                System.out.println("You choose east");
                yAxis++;
                System.out.println(xAxis);
                System.out.println(yAxis);
                map[xAxis][location[1]] = 'O';
                map[xAxis][yAxis] = 'P';
            }else if (command.toLowerCase().equals("west")){
                System.out.println("You choose west");
                yAxis--;
                System.out.println(xAxis);
                System.out.println(yAxis);
                map[xAxis][location[1]] = 'O';
                map[xAxis][yAxis] = 'P';
            }
            } catch (ArrayIndexOutOfBoundsException e) {
                //TODO: handle exception
                // going to use scanner to ask if you want to still
                System.out.println("You won!!");
                creatingNewMap();
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