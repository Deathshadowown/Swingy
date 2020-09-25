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
import swingy.view.gui_interface.Gui_Interface;
import swingy.model.Game;
import swingy.model.hero.Hero;

public class GameController{

    private static Console_Interface console = null;
    private static Gui_Interface gui = null;
    private static Game game = null;

    public GameController(int interfaces){
        if (interfaces == 1){
            console = new Console_Interface(this);
        }
            else if (interfaces == 2){
                System.out.println("not implemented");
                gui = new Gui_Interface(this);
            }
        if (interfaces == 1){
            console.mainConsole();
        }else if (interfaces == 2){
            try {
                gui.mainMenuGui();
                
            } catch (Exception e) {
                System.out.println(e);
                //TODO: handle exception
            }
        }
    }

    public void initializingGame(byte mainConsole, byte consoleOrGui){
        byte newGame = 1;
        byte loadGame = 2;
        byte consoleUi = 1;
        byte guiUi = 2;
        game = new Game(this);
        try {
            if (consoleOrGui == consoleUi)
            {
            if (mainConsole == newGame){
                System.out.println("newGame must create hero: ");
                characterCreate();
                createMap();
            }else if (mainConsole == loadGame){
                int[] playerLocation;
                System.out.println("Will loadGame");
                playerLocation = game.loadingGame();
                createLoadedMap(playerLocation);
            }
        }else if (consoleOrGui == guiUi){
            if (mainConsole == newGame){
                System.out.println("newGame must create hero: GUI side ");
                // characterCreate();
                gui.heroNameInput();
                // guiCharacterCreate();
                // createMap();
            }else if (mainConsole == loadGame){
        //         // int[] playerLocation;
        //         // System.out.println("Will loadGame");
        //         // playerLocation = game.loadingGame();
        //         // createLoadedMap(playerLocation);
            }
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
        while (true)
        {
            console.displayPlayerInfo(player);
            console.printMap(map);
            command = console.displayCommand();
            game.commandWhereToMove(command, map);
        }
    }

    public void guiStartGame(char[][] map, int mapsize, Hero player)
    {
        // String command = null;
        // console.instructionsToGame();
        // while (true)
        // {
            // console.displayPlayerInfo(player);
            // console.printMap(map);
            // command = console.displayCommand();
            // gui.closeJfram3();
            gui.guiStartingGame(player, map);
            // game.commandWhereToMove(command, map);
        // }
    }
    public void guiStartGameWithOutMapSize(char[][] map, Hero player){
        gui.guiStartingGame(player, map);
    }

    public void startingCommandWhereToMove(String command, char[][] map){
        game.guiCommandWhereToMove(command, map);
    }

    public static void guiCreateMap(){
        game.guiCreatingMap();
    }

    public static void createMap(){
            game.creatingMap();
    }

    public static void guiCreateNewMap(){
        System.out.println("you won!!");
        gui.closeJfram3();
    }
    
    public static void createLoadedMap(int[] playerLocation){
        game.LoadedPlayerMap(playerLocation);
    }

    public static void createNewMap(){
        console.displayWinningMessage();
        console.displayContinuePlaying();
    }

    public void guiCharacterCreate(String heroName, String charClass){
            System.out.println(heroName);
            System.out.println(charClass);
            game.createCharacter(heroName, charClass);
            guiCreateMap();
    }
    public void characterCreate(){
        String heroName = null;
        String charClass = null;
            heroName = console.getHeroName();
            charClass = console.getCharClass();
            game.createCharacter(heroName, charClass);
        // }else if (consoleOrGui == 2)
        // {
            // System.out.println("i got here");
        //     // heroName = "shane";
        //     // charClass = "Assassin";
        //     // game.createCharacter(heroName, charClass);
        // }
    }
    public void info(Hero player){
        console.displayPlayerInfo(player);
    }

    public String engageMonsterOrRun(String command){
        command = console.displayEngageorRunMessage(command);
        return(command);
    }

    public void runOrFightInput(String command, int count){
        if (count == 0){
            gui.closeJfram3();
            gui.runOrFight(command);
        }
        if (count == 1)
        {
            System.out.println("got fight");
            // return "fight";
        }
        if (count == 2)
        {
            System.out.println("got run");
            // return "run";
        }
    }
    public void getInputRunOrFight(String command,String fightorRun){
        int count = 0;
        if (fightorRun.toLowerCase().equals("fight")){
            count = 1;
            runOrFightInput(command, count);
        }
        else if (fightorRun.toLowerCase().equals("run")){
            count = 2;
            runOrFightInput(command, count);
        }
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