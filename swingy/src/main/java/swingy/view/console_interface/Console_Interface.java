/* ************************************************************************** */
/*                                                                            */
/*                                                        :::      ::::::::   */
/*   Console_Interface.java                             :+:      :+:    :+:   */
/*                                                    +:+ +:+         +:+     */
/*   By: svan-nie <marvin@42.fr>                    +#+  +:+       +#+        */
/*                                                +#+#+#+#+#+   +#+           */
/*   Created: 2020/09/17 17:28:22 by svan-nie          #+#    #+#             */
/*   Updated: 2020/09/17 17:28:22 by svan-nie         ###   ########.fr       */
/*                                                                            */
/* ************************************************************************** */

package swingy.view.console_interface;

import swingy.controller.GameController;
import java.util.*;
import swingy.model.hero.Hero;

public class Console_Interface{
    
    private static GameController gameController = null;
    private Scanner scan = new Scanner(System.in);
    public Console_Interface(GameController gameController){
        this.gameController = gameController;
    }

    public static void clearScreen() {
        System. out. print("\033[H\033[2J");
        System. out. flush();
        }

    public void mainConsole(){
        clearScreen();
        System.out.println("Welcome to Swingy, press 1 to start a new game or 2 to load a game");
        byte newGame = 1;
        byte loadGame = 2;
        byte gameMode = 0;
        try {
            while(true){
            // Scanner scan = new Scanner(System.in);
            System.out.print("Please Select: ");
            gameMode = scan.nextByte();
            if (gameMode == newGame){
                System.out.println("New Game");
                break;
            }else if (gameMode == loadGame){
                System.out.println("load Game");
                break;
            }else
            {
                clearScreen();
                System.out.println("Please enter 1 for new Game, or 2, to load game ");
                continue;
            }
        }
        //initializingGame in gamecontroller
        gameController.initializingGame(gameMode);
        }catch (InputMismatchException notInt){
            System.out.println("ERROR: Please enter a valid number: 1,2");
        } catch (Exception e) {
            System.out.println(e);
            System.out.println("ERROR: unknown error");
        }
    }

    public String getHeroName(){
        clearScreen();
        Scanner scan = new Scanner(System.in);
        String heroName = null;
        try {
            System.out.println("Please enter your Hero Name: ");
            heroName = scan.nextLine();
            return heroName;
        } catch (Exception e) {
            System.out.println(e);
            System.out.println("Something is wrong");
            return null;
        }
    }

    public String getCharClass(){
        clearScreen();
        // Scanner scan = new Scanner(System.in);
        // byte charClass = 0;
        try {
            System.out.println("Classes you can Choose are as follows");
            System.out.println("1|Assassin 2|Knight 3|Wizard");
            System.out.print("Please enter your Character Class: ");
            byte charClass = scan.nextByte();
            switch (charClass) {
                case 1:
                    return ("Assassin");
                case 2:
                    return ("Knight");
                case 3:
                    return ("Wizard");
                default:
                    return null;
            }
        } catch (Exception e) {
            System.out.println(e);
            System.out.println("Something is wrong");
            return null;
        }
    }
    public void instructionsToGame(){
        System.out.println("What the game is about add later");
    }

    public void displayPlayerInfo(Hero player){
        System.out.println("-------------------------------------");
        System.out.println("Player Stats");
        System.out.println("Hero Name: "+player.getHeroName());
        System.out.println("Heros Class: "+player.getCharClass());
        System.out.println("exp: "+player.getXp());
        System.out.println("Current level: "+player.getLevel());
        System.out.println("Current Health: "+player.getHealth());
        System.out.println("Current Attack: "+player.getAttack());
        System.out.println("Current Defence: "+player.getDefence());
        System.out.println("-------------------------------------");
    }

    public String displayCommand(){
        String command = null;
        System.out.println("input North, South, East, West");
        System.out.print("what would you like to do: ");
        command = scan.nextLine();
        System.out.println();
        return command;
    }
    public void printMap(char map[][]){
        int i = 0;
        int j = 0;
        while (i < map.length)
        {
            while (j < map[i].length)
            {
                System.out.print(map[i][j]+" ");
                j++;
            }
            System.out.println();
            j = 0;
            i++;
        }
    }
}