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
                int[] playerLocation;
                System.out.println("Will loadGame");
                playerLocation = game.loadingGame();
                guicreateLoadedMap(playerLocation);
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
            int count = 0;
            gui.guiStartingGame(player, map, count);
            // game.commandWhereToMove(command, map);
        // }
    }

    public void guiStartGameWithOutMapSize(char[][] map, Hero player, int count){
        // System.out.println(count);
        gui.guiStartingGame(player, map, count);
    }

    public void startingCommandWhereToMove(String command, char[][] map, int count){
        game.guiCommandWhereToMove(command, map, count);
    }

    public void fightingOrRunning(String command, int[] location, char map[][], String userInput, Hero player){
        gui.closeJfram3();
        gui.runOrFight(command, location, map, userInput, player);
    }

    public void fighting(String command, int[] location, char map[][], String userInput, Hero player){
        try {
                int random = 0;
                random  = game.getRandomRoll(3);
                game.guiEngageMonster();
                if (random == 0){
                    game.guiItemDrop();
                }else if (random == 1){
                    game.guiItemDrop();
                }else if (random == 2){
                    game.guiItemDrop();
                }else{
                    guiStartGameWithOutMapSize(map, player, 0);
                }
        } catch (ArrayIndexOutOfBoundsException e) {
            game.guicreatingNewMap();
        }catch (Exception e){
            System.out.println("ERROR: contact support");
        }
    }

    public void running(String command, int[] location, char map[][], String userInput, Hero player){
        try {
            int random = 0;
            random = game.getRandomRoll(100);
            if (random < 50){
                game.guiEngageMonster();
                random = game.getRandomRoll(3);
                if (random == 0){
                    game.guiItemDrop();
                }else if (random == 1){
                    game.guiItemDrop();
                }else if (random == 2){
                    game.guiItemDrop();
                }else{
                    guiStartGameWithOutMapSize(map, player, 0);
                }
            }else if (random > 50){
                gui.gotAway();
                guiStartGameWithOutMapSize(map, player, 1);
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            game.guicreatingNewMap();
        }catch (Exception e){
            System.out.println("ERROR: contact support");
        }
    }

    public void noItemDrop(){
        gui.closeJfram3();
        game.dontWantItem();
    }

    public void yesItemDrop(String itemName, String typeOfItem){
        game.WantItem(itemName, typeOfItem);
    }

    public void guiItemDrops(String itemName, String typeOfItem){
        gui.guiItemDropName(itemName, typeOfItem);
    }

    public void whoFightsFirstone(String playerOrMonsterFirst){
        gui.whoAttacksFirst(playerOrMonsterFirst);
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
        gui.closeJfram4();
    }
    
    public static void createLoadedMap(int[] playerLocation){
        game.LoadedPlayerMap(playerLocation);
    }

    public static void guicreateLoadedMap(int[] playerLocation){
        game.guiLoadedPlayerMap(playerLocation);
    }

    public static void guicreateLoadedMapSilent(int[] playerLocation){
        game.guiLoadedPlayerMapSilent(playerLocation);
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

    // public void runOrFightInput(String command, int count){
    //     if (count == 0){
    //         gui.closeJfram3();
    //         gui.runOrFight(command);
    //     }
    //     if (count == 1)
    //     {
    //         System.out.println("got fight");
    //         // return "fight";
    //     }
    //     if (count == 2)
    //     {
    //         System.out.println("got run");
    //         // return "run";
    //     }
    // }
    // public void getInputRunOrFight(String command,String fightorRun){
    //     int count = 0;
    //     if (fightorRun.toLowerCase().equals("fight")){
    //         count = 1;
    //         runOrFightInput(command, count);
    //     }
    //     else if (fightorRun.toLowerCase().equals("run")){
    //         count = 2;
    //         runOrFightInput(command, count);
    //     }
    // }

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

    public void guiMonsterEngageing(String monsterToFight, int deadOrAlive){
        if (deadOrAlive == 1)
        gui.monsterGoingToFight(monsterToFight);
        else if (deadOrAlive == 0)
        gui.monstDeafeatedMessage(monsterToFight);
    }

    public void monsterEngageing(String monsterToFight, int deadOrAlive){
        if (deadOrAlive == 1)
        console.monsterGoingToFight(monsterToFight);
        else if (deadOrAlive == 0)
        console.monstDeafeatedMessage(monsterToFight);
    }

    public void amountOfExp(int monsterExp){
        gui.amountOfExpGiven(monsterExp);
    }

    public void playerLevel(int playerLevel){
        gui.playerLevelUpMessage(playerLevel);
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