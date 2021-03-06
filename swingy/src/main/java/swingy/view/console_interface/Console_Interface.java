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
import swingy.model.hero.Hero;
import java.util.*;
import java.util.concurrent.TimeUnit;

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
        byte consoleActivate = 1;
        try {
            while(true){
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
        gameController.initializingGame(gameMode, consoleActivate);
        }catch (InputMismatchException notInt){
            System.out.println("ERROR: Please enter a valid number: 1,2");
        } catch (Exception e) {
            System.out.println(e);
            System.out.println("ERROR: unknown error");
        }
    }

    public void escapedMessage(){
        try {
            System.out.println("You got away!!.");
            TimeUnit.SECONDS.sleep(1);
        } catch (Exception e) {
            System.out.println("ERROR: please contact support");
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
        // System.out.println("What the game is about add later");
        		System.out.println("Welcome to Swingy, a text-based RPG that's loads of \"fun\".");
		System.out.println(
				"You'll be placed in the center of a grid where you'll have to try and reach either of the edges.");
		System.out.println(
				"You can move \"north\", \"south\", \"east\" or \"west\" and will encounter enemies along the way.");
		System.out.println(
				"Enemies will be places randomly on the map and will have a chance to drop loot and give you xp after being defeated.");
		System.out.println(
				"The map size is determined by your level and too complete the game you'll have to reach level 6.");
		System.out.println("Good Luck!.");
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
        System.out.println("Current Weapon: "+player.getCurrentWeapon());
        System.out.println("Current Weapon stats: "+player.getCurrentWeaponAttack()+" Attack");
        System.out.println("Current Armour: "+player.getCurrentArmour());
        System.out.println("Current Armour stats: "+player.getCurrentArmourDefence()+" Defence");
        System.out.println("Current Helm: "+player.getCurrentHelm());
        System.out.println("Current Helm stats: "+player.getCurrentHelmHealth()+" Health");
        System.out.println("-------------------------------------");
    }

    public String displayCommand(){
        String command = null;
        System.out.println("input save to save game or quit to quit game.");
        System.out.println("input North, South, East, West to move around map.");
        System.out.print("what would you like to do: ");
        command = scan.nextLine();
        System.out.println();
        return command;
    }

    public String displayEngageorRunMessage(String command){
        System.out.println("You Found a Monster");
        while(true)
        {
            System.out.print("Do you wish to fight or run? ");
            command = scan.nextLine();
            if (command.toLowerCase().equals("run")){
                break;
            }else if(command.toLowerCase().equals("fight")){
                break;
            }
        }
        return command;
    }

    public void displayWinningMessage(){
        System.out.println("congratulations Hero you have made it to the end of the map,"
        + " May you be knowen through out the whole world!!!!.");
    }

    public void displayContinuePlaying(){
        String userInput = null;

        while (true)
        {
            System.out.print("Do you wish to Continue Playing hero?: yes: or no:");
            userInput = scan.nextLine();
            if (userInput.toLowerCase().equals("yes")){
                break;
            }else if (userInput.toLowerCase().equals("no")){
                System.out.println("Thank you for playing Hero may we see you soon.");
                System.exit(2);
            }
        }
    }

    public String itemDropInput(String item){
        String userInput = null;
        System.out.println("Monster droped "+item);
        while (true)
        {
            System.out.println("Would you like to take it or leave it?");
            System.out.print("Yes or no: ");
            userInput = scan.nextLine();
            if (userInput.toLowerCase().equals("yes")){
                break;
            }
            else if (userInput.toLowerCase().equals("no")){
                break;
            }
        }
        return userInput;
    }

    public void displayFailedRunMessage(){
        try {
            System.out.println("You failed to run away, Get ready to fight!!!");
            TimeUnit.SECONDS.sleep(1);
        } catch (Exception e) {
            System.out.println("ERROR: something is wrong");
        }
    }

    public void DisplayMovedMessage(String command)
    {
        if (command.toLowerCase().equals("north")){
            System.out.println("You Move North");
        }else if (command.toLowerCase().equals("south")){
            System.out.println("You Move South");
        }else if (command.toLowerCase().equals("east")){
            System.out.println("You Move East");
        }else if (command.toLowerCase().equals("west")){
            System.out.println("You Move west");
        }
    }

    public void monsterGoingToFight(String monsterToFight){
        System.out.println("You going to fight: "+monsterToFight);
    }

    public void monstDeafeatedMessage(String monsterDeath){
        System.out.println("You have Deafeated "+monsterDeath);
    }

    public void whoAttacksFirstMessage(int playerOrMonster){
        if (playerOrMonster == 0)
        System.out.println("Player Attacks First!!");
        else if (playerOrMonster == 1)
        System.out.println("Monster Attacks First!!");
    }
    public void herosDeathMessage(){
        System.out.println("You have Died, may you rest in peace");
        System.exit(2);
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