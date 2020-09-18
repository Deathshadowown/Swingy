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
        //going to wright code here must be moved to a better spot later
    }

    public Hero getPlayer() {
		return player;
    }
}