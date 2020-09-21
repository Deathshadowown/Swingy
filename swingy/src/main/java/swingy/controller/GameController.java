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

//remove import once scanner is inside console.java
import java.util.*;

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
                System.out.println("Will loadGame");
            }            
        } catch (Exception e) {
            //TODO: handle exception
        }
    }

    public void startGame(char[][] map, int mapsize, Hero player)
    {
        //put scanner and command into console.java
        // Scanner scan = new Scanner(System.in);

        String command = null;
        console.instructionsToGame();
        console.displayPlayerInfo(player);
        // console.printMap(map);
        while (true)
        {
            console.printMap(map);
            command = console.displayCommand();
            game.commandWhereToMove(command, map);
        }
    }

    public static void createMap(){
            game.creatingMap();
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
    public void info(Hero player)
    {
        console.displayPlayerInfo(player);
    }
}