/* ************************************************************************** */
/*                                                                            */
/*                                                        :::      ::::::::   */
/*   Gui_Interface.java                                 :+:      :+:    :+:   */
/*                                                    +:+ +:+         +:+     */
/*   By: svan-nie <marvin@42.fr>                    +#+  +:+       +#+        */
/*                                                +#+#+#+#+#+   +#+           */
/*   Created: 2020/09/24 18:18:53 by svan-nie          #+#    #+#             */
/*   Updated: 2020/09/24 18:18:53 by svan-nie         ###   ########.fr       */
/*                                                                            */
/* ************************************************************************** */

package swingy.view.gui_interface;

// import javax.swing.*;
import swingy.controller.GameController;
import swingy.model.hero.Hero;

// import java.awt.GraphicsConfiguration;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.*; 
import java.awt.event.*;

public class Gui_Interface extends javax.swing.JFrame implements ActionListener{

    private static GameController gameController = null;
    private int clicks = 0;
    private JLabel label = new JLabel("Do you wish to start a new game or load a game?");
    private JLabel labelc = new JLabel("Number of clicks:  0     ");
    // private JButton newGame = new JButton("New Game");
    // private JButton loadGame = new JButton("Load Game");
    private JFrame frame = new JFrame();
    private JFrame frame2 = new JFrame();
    private JFrame frame3 = new JFrame();
    private JFrame frame4 = new JFrame();
    public Gui_Interface(GameController gameController){

        this.gameController = gameController;
        byte startGame = 1;
        byte loadingGame = 2;
        byte guiInterface = 2;
        JPanel panel = new JPanel();
        JButton newGame = new JButton("New Game");
        JButton loadGame = new JButton("Load Game");
        // newGame.addActionListener(this);
        // loadGame.addActionListener(this);
        newGame.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // JOptionPane.showMessageDialog(this, textBox.getText());
                label.setText("newGame");
                gameController.initializingGame(startGame, guiInterface);
                frame.setVisible(false);
                // setNameAndClass();
            }
        });
        loadGame.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // JOptionPane.showMessageDialog(this, textBox.getText());
                label.setText("loadGame");
                gameController.initializingGame(loadingGame, guiInterface);
                frame.setVisible(false);
                // setNameAndClass();
            }
        });

        panel.setBorder(BorderFactory.createEmptyBorder(500, 500, 500, 500));
        panel.setLayout(new GridLayout(0, 1));
        panel.add(label);
        panel.add(newGame);
        panel.add(loadGame);
        panel.add(labelc);

        frame.add(panel, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Swingy");
        frame.pack();
        frame.setVisible(true);
    }

    // public void newGame.addActionListener(new ActionListener(){

    // }
    public void actionPerformed(ActionEvent e) {
        clicks++;
        labelc.setText("Number of clicks:  " + clicks);
    }

    public void heroNameInput(){
        JPanel panel = new JPanel();
        JButton okay = new JButton("Okay");
        JLabel enterValidClass = new JLabel("Please Enter a valid Char Class");
        JLabel heroClassLabel = new JLabel("Choose your Class.");
        JLabel classAssassin = new JLabel("1st) Assassin");
        JLabel classKnight = new JLabel("2st) Knight");
        JLabel classWizard = new JLabel("3st) Wizard");
        JLabel classEnterBelow = new JLabel("Please Select your class below");
        JTextField className = new JTextField();
        JLabel heroNameLabel = new JLabel("Choose your Hero Name.");
        JTextField heroName = new JTextField();
        String name = "Hello world";
        okay.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // JOptionPane.showMessageDialog(this, textBox.getText());
                // gameController.initializingGame(loadingGame, guiInterface);
                String userClassInput = className.getText();
                String res = heroName.getText();
                if (userClassInput.toLowerCase().equals("assassin")){
                    frame2.setVisible(false);
                    gameController.guiCharacterCreate(res, "Assassin");
                }else if(userClassInput.toLowerCase().equals("knight")){
                    frame2.setVisible(false);
                    gameController.guiCharacterCreate(res, "Knight");
                }else if(userClassInput.toLowerCase().equals("wizard")){
                    frame2.setVisible(false);
                    gameController.guiCharacterCreate(res, "Wizard");
                }else
                classEnterBelow.setText("Please Enter a valid Char Class");
            }
        });
        panel.setBorder(BorderFactory.createEmptyBorder(150, 150, 150, 150));
        panel.setLayout(new GridLayout(0, 1));
        panel.add(enterValidClass);
        panel.add(heroClassLabel);
        panel.add(classAssassin);
        panel.add(classKnight);
        panel.add(classWizard);
        panel.add(classEnterBelow);
        panel.add(className);
        panel.add(heroNameLabel);
        panel.add(heroName);
        panel.add(okay);
        // panel.add(heroName);

        frame2.add(panel, BorderLayout.CENTER);
        frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame2.setTitle("Swingy");
        frame2.pack();
        frame2.setVisible(true);
    }

    public void guiStartingGame(Hero player, char map[][]){
        JPanel panel = new JPanel();
        JButton okay = new JButton("Okay");
        JButton north = new JButton("north");
        JButton south = new JButton("south");
        JButton east = new JButton("east");
        JButton west = new JButton("west");
        JButton save = new JButton("save");
        JButton quit = new JButton("quit");
        JLabel playerStates = new JLabel("Player Stats.");
        JLabel playerName = new JLabel("Hero Name: "+player.getHeroName());
        JLabel playerClass = new JLabel("Heros Class: "+player.getCharClass());
        JLabel playerExp = new JLabel("exp: "+player.getXp());
        JLabel playerLevel = new JLabel("Current level: "+player.getLevel());
        JLabel playerHealth = new JLabel("Current Health: "+player.getHealth());
        JLabel playerAttack = new JLabel("Current Attack: "+player.getAttack());
        JLabel playerDefence = new JLabel("Current Defence: "+player.getDefence());
        JLabel playerCurrentWeapon = new JLabel("Current Weapon: "+player.getCurrentWeapon());
        JLabel playerCurrentWeaponAttack = new JLabel("Current Weapon stats: "+player.getCurrentWeaponAttack()+" Attack");
        JLabel playerCurrentArmour = new JLabel("Current Armour: "+player.getCurrentArmour());
        JLabel playerCurrentWeaponDefence = new JLabel("Current Armour stats: "+player.getCurrentArmourDefence()+" Defence");
        JLabel playerCurrentHelm = new JLabel("Current Helm: "+player.getCurrentHelm());
        JLabel playerCurrentHelmHealth = new JLabel("Current Helm stats: "+player.getCurrentHelmHealth()+" Health");
        north.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String sNorth = "north";
                    gameController.startingCommandWhereToMove(sNorth, map);
                    // frame3.setVisible(false);
                    // frame3.setVisible(true);
            }
        });
        south.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String sSouth = "south";
                gameController.startingCommandWhereToMove(sSouth, map);
                // frame3.setVisible(false);
                // frame3.setVisible(true)
            }
        });
        east.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String sEast = "east";
                gameController.startingCommandWhereToMove(sEast, map);
                // frame.setVisible(false);
            }
        });
        west.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String sWest = "west";
                gameController.startingCommandWhereToMove(sWest, map);
                // frame.setVisible(false);
            }
        });
        panel.setBorder(BorderFactory.createEmptyBorder(150, 150, 150, 150));
        panel.setLayout(new GridLayout(0, 1));
        panel.add(playerStates);
        panel.add(playerName);
        panel.add(playerClass);
        panel.add(playerExp);
        panel.add(playerLevel);
        panel.add(playerHealth);
        panel.add(playerAttack);
        panel.add(playerDefence);
        panel.add(playerCurrentWeapon);
        panel.add(playerCurrentWeaponAttack);
        panel.add(playerCurrentArmour);
        panel.add(playerCurrentWeaponDefence);
        panel.add(playerCurrentHelm);
        panel.add(playerCurrentHelmHealth);
        // panel.add(okay);
        panel.add(north);
        panel.add(south);
        panel.add(east);
        panel.add(west);
        panel.add(save);
        panel.add(quit);

        frame3.add(panel, BorderLayout.CENTER);
        frame3.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame3.setTitle("Swingy");
        frame3.pack();
        frame3.setVisible(true);
    }
    public void closeJfram3(){
        frame3.dispose();
    }

    public void runOrFight(String command){
        JPanel panel = new JPanel();
        JButton fight = new JButton("Fight");
        JButton run = new JButton("Run");
        JLabel runOrFightMessage = new JLabel("Do you wish to Run or Fight");
        fight.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String fighting = "fight";
               gameController.getInputRunOrFight(command, fighting);
            }
        });
        run.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String running = "run";
                gameController.getInputRunOrFight(command, running);
            }
        });
        panel.setBorder(BorderFactory.createEmptyBorder(150, 150, 150, 150));
        panel.setLayout(new GridLayout(0, 1));
        panel.add(runOrFightMessage);
        panel.add(fight);
        panel.add(run);

        frame4.add(panel, BorderLayout.CENTER);
        frame4.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame4.setTitle("Swingy");
        frame4.pack();
        frame4.setVisible(true);
    }

    // public void displayPlayerInfo(Hero player){
    //     JLabel playersattack = new JLabel("Current ");
    //     System.out.println("-------------------------------------");
    //     System.out.println("Player Stats");
    //     System.out.println("Hero Name: "+player.getHeroName());
    //     System.out.println("Heros Class: "+player.getCharClass());
    //     System.out.println("exp: "+player.getXp());
    //     System.out.println("Current level: "+player.getLevel());
    //     System.out.println("Current Health: "+player.getHealth());
    //     System.out.println("Current Attack: "+player.getAttack());
    //     System.out.println("Current Defence: "+player.getDefence());
    //     System.out.println("Current Weapon: "+player.getCurrentWeapon());
    //     System.out.println("Current Weapon stats: "+player.getCurrentWeaponAttack()+" Attack");
    //     System.out.println("Current Armour: "+player.getCurrentArmour());
    //     System.out.println("Current Armour stats: "+player.getCurrentArmourDefence()+" Defence");
    //     System.out.println("Current Helm: "+player.getCurrentHelm());
    //     System.out.println("Current Helm stats: "+player.getCurrentHelmHealth()+" Health");
    //     System.out.println("-------------------------------------");
    // }

    public void mainMenuGui(){
        Gui_Interface firstGuiInterface = new Gui_Interface(gameController);

    }
}