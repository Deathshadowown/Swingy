/* ************************************************************************** */
/*                                                                            */
/*                                                        :::      ::::::::   */
/*   GameController.java                                 :+:      :+:    :+:   */
/*                                                    +:+ +:+         +:+     */
/*   By: svan-nie <marvin@42.fr>                    +#+  +:+       +#+        */
/*                                                +#+#+#+#+#+   +#+           */
/*   Created: 2020/09/17 17:46:30 by svan-nie          #+#    #+#             */
/*   Updated: 2020/09/17 17:46:30 by svan-nie         ###   ########.fr       */
/*                                                                            */
/* ************************************************************************** */

package swingy.controller;

import swingy.view.console_interface.Console_Interface;
import swingy.model.Game;
import swingy.model.hero.Hero;

public class GameController{

    private static Console_Interface console = null;
    private static Game game = null;

    public GameController(int interfaces){
        if (interfaces == 1){
            console = new Console_Interface(this);
        }
            else if (interfaces == 2){
                System.out.println("not implemented");
            }
        if (interfaces == 1){
            console.mainConsole();
        }
    }

    public void initializingGame(byte mainConsole){
        byte newGame = 1;
        byte loadGame = 2;
        game = new Game(this);
        try {
            if (mainConsole == newGame){
                System.out.println("newGame must create hero: ");
                characterCreate();
                createMap();
                // System.out.println("got hero");
            }else if (mainConsole == loadGame){
                int[] playerLocation;
                System.out.println("Will loadGame");
                playerLocation = game.loadingGame();
                createLoadedMap(playerLocation);
            }            
        } catch (Exception e) {
            System.out.println(e);
            System.out.println("ERROR: Please contact support with error above");
        }
    }

    public void startGame(char[][] map, int mapsize, Hero player)
    {
        String command = null;
        console.instructionsToGame();
        // console.printMap(map);
        while (true)
        {
            console.displayPlayerInfo(player);
            console.printMap(map);
            command = console.displayCommand();
            game.commandWhereToMove(command, map);
        }
    }

    public static void createMap(){
            game.creatingMap();
    }
    
    public static void createLoadedMap(int[] playerLocation){
        game.LoadedPlayerMap(playerLocation);
    }

    public static void createNewMap(){
        console.displayWinningMessage();
        console.displayContinuePlaying();
        // game.creatingNewMap();
    }
    public void characterCreate(){
        String heroName = console.getHeroName();
        String charClass = console.getCharClass();
        game.createCharacter(heroName, charClass);
    }
    //function was just to test in game.java
    public void info(Hero player){
        console.displayPlayerInfo(player);
    }

    public String engageMonsterOrRun(String command){
        command = console.displayEngageorRunMessage(command);
        return(command);
    }

    public void failedToRun(){
        console.displayFailedRunMessage();
    }
    public String itemDrops(String item){
        String command = null;
        command = console.itemDropInput(item);
        return command;
    }

    public void moveCommandDisplay(String command){
        console.DisplayMovedMessage(command);
    }
    public void monsterEngageing(String monsterToFight, int deadOrAlive){
        if (deadOrAlive == 1)
        console.monsterGoingToFight(monsterToFight);
        else if (deadOrAlive == 0)
        console.monstDeafeatedMessage(monsterToFight);
    }
    public void escaped(){
        console.escapedMessage();
    }

    public void attackFirstPlayerMonster(int playerOrMonster){
        console.whoAttacksFirstMessage(playerOrMonster);
    }
    public void herosDeath(){
        console.herosDeathMessage();
    }
}