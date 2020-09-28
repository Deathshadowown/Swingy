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
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
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
    private JFrame frame5 = new JFrame();
    private JFrame frame6 = new JFrame();
    private JFrame frame7 = new JFrame();
    private JFrame frame8 = new JFrame();
    private JFrame frame9 = new JFrame();
    private JFrame frame10 = new JFrame();
    private JFrame frame11 = new JFrame();
    private JFrame frame12 = new JFrame();
    private JFrame frame13 = new JFrame();
    private JFrame frame14 = new JFrame();


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
                // Container old = getContentPane();
                // remove(old);
                frame.setVisible(false);
                gameController.initializingGame(startGame, guiInterface);
                // setVisible(false);
                // setNameAndClass();
            }
        });
        loadGame.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // JOptionPane.showMessageDialog(this, textBox.getText());
                label.setText("loadGame");
                gameController.initializingGame(loadingGame, guiInterface);
                // setVisible(false);
                // setNameAndClass();
            }
        });

        panel.setBorder(BorderFactory.createEmptyBorder(500, 500, 500, 500));
        panel.setLayout(new GridLayout(0, 1));
        panel.add(label);
        panel.add(newGame);
        panel.add(loadGame);

        frame.add(panel, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.setTitle("Swingy");
        frame.pack();
        frame.setVisible(true);
    }

    public void gameWon(){
        JPanel panel = new JPanel();
        JButton okay = new JButton("okay");
        JLabel wonGame = new JLabel("congratulations Hero you have made it to the end of the map,"
        + " May you be knowen through out the whole world!!!!. Save has been made Please load game to start a new map");
        panel.setBorder(BorderFactory.createEmptyBorder(150, 150, 150, 150));
        panel.setLayout(new GridLayout(0, 1));
        panel.add(wonGame);
        panel.add(okay);
        okay.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        frame13.add(panel, BorderLayout.CENTER);
        frame13.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame13.setTitle("Swingy1");
        frame13.pack();
        frame13.setVisible(true);
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
        add(panel, BorderLayout.CENTER);
        // revalidate();
        // repaint();
        frame2.add(panel, BorderLayout.CENTER);
        frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame2.setTitle("Swingy2");
        frame2.pack();
        frame2.setVisible(true);
    }

    public void heroStates(Hero player){
        JPanel panel = new JPanel();
        JButton okay = new JButton("okay");
        JLabel randomMessages = new JLabel("Please press Okay when you done fighting or running to see what happend");
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
        // JTextArea newText = new JTextArea();

        panel.setBorder(BorderFactory.createEmptyBorder(150, 150, 150, 150));
        panel.setLayout(new GridLayout(0, 1));
        // panel.add(newText);
        panel.add(randomMessages);
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
        panel.add(okay);
        okay.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame12.dispose();
            }
        });

        frame12.add(panel, BorderLayout.CENTER);
        frame12.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame12.setTitle("Swingy3");
        frame12.pack();
        frame12.setVisible(true);
    }
    
    public void guiStartingGame(Hero player, char map[][], int count){
        JPanel panel = new JPanel();
        JButton north = new JButton("north");
        JButton south = new JButton("south");
        JButton east = new JButton("east");
        JButton west = new JButton("west");
        JButton fight = new JButton("fight");
        JButton run = new JButton("run");
        JButton save = new JButton("save");
        JButton quit = new JButton("quit");
        JButton okay = new JButton("okay");
        JLabel randomMessages = new JLabel("Press okay to Refresh states");
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
        panel.setBorder(BorderFactory.createEmptyBorder(150, 150, 150, 150));
        panel.setLayout(new GridLayout(0, 1));
        panel.add(newText);
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
        panel.add(north);
        panel.add(south);
        panel.add(east);
        panel.add(west);
        panel.add(save);
        panel.add(quit);
        panel.add(okay);
            north.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String sNorth = "north";
                    gameController.startingCommandWhereToMove(sNorth, map, count);
                    // frame3.setVisible(false);
                    // frame3.setVisible(true);
                }
            });
            south.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String sSouth = "south";
                    gameController.startingCommandWhereToMove(sSouth, map, count);
                    // frame3.setVisible(false);
                    // frame3.setVisible(true)
                }
            });
            east.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String sEast = "east";
                    gameController.startingCommandWhereToMove(sEast, map, count);
                    // frame.setVisible(false);
                }
            });
            west.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String sWest = "west";
                    gameController.startingCommandWhereToMove(sWest, map, count);
                    // frame.setVisible(false);
                }
            });
            save.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String saveGame = "save";
                    gameController.startingCommandWhereToMove(saveGame, map, count);
                    // frame.setVisible(false);
                }
            });
            quit.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    System.exit(0);
                }
            });
            okay.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    gameController.guiStartGameWithOutMapSize(map, player, 0);
                    }
            });

        frame3.add(panel, BorderLayout.CENTER);
        frame3.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame3.setTitle("Swingy4");
        // frame3.revalidate();
        // frame3.repaint();
        frame3.pack();
        frame3.setVisible(true);
    }
    public void closeJfram3(){
        frame3.dispose();
    }
    public void closeJfram4(){
        frame4.dispose();
    }

    public void gotAway(){
        JPanel panel = new JPanel();
        JButton okay = new JButton("okay");
        JLabel youGotAway = new JLabel("You got away!!");
        panel.setBorder(BorderFactory.createEmptyBorder(150, 150, 150, 150));
        panel.setLayout(new GridLayout(0, 1));
        panel.add(youGotAway);
        panel.add(okay);
        okay.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame5.dispose();
            }
        });
    }

        public void whoAttacksFirst(String playerOrMonsterFirst){
            JPanel panel = new JPanel();
            Object[] options = {"OK"};
            int n;
            if (playerOrMonsterFirst.toLowerCase().equals("player")){
                n = JOptionPane.showOptionDialog(this,
                               "hero got first attack","Title",
                               JOptionPane.PLAIN_MESSAGE,
                               JOptionPane.QUESTION_MESSAGE,
                               null,
                               options,
                               options[0]);
            }else if (playerOrMonsterFirst.toLowerCase().equals("monster")){
                n = JOptionPane.showOptionDialog(this,
                               "monster got first attack","Title",
                               JOptionPane.PLAIN_MESSAGE,
                               JOptionPane.QUESTION_MESSAGE,
                               null,
                               options,
                               options[0]);
            }
            panel.setBorder(BorderFactory.createEmptyBorder(150, 150, 150, 150));
            panel.setLayout(new GridLayout(0, 1));

        frame6.add(panel, BorderLayout.CENTER);
        frame6.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame6.setTitle("Swingy5");
        frame6.pack();
        frame6.setVisible(false);
        }
        
        
        public void monsterGoingToFight(String monsterToFight){
            JPanel panel = new JPanel();
            // JButton okay = new JButton("okay");
            panel.setBorder(BorderFactory.createEmptyBorder(150, 150, 150, 150));
            panel.setLayout(new GridLayout(0, 1));
            Object[] options = {"OK"};
            int n = JOptionPane.showOptionDialog(this,
                           "You going to fight: "+monsterToFight,"Title",
                           JOptionPane.PLAIN_MESSAGE,
                           JOptionPane.QUESTION_MESSAGE,
                           null,
                           options,
                           options[0]);
        frame7.add(panel, BorderLayout.CENTER);
        frame7.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame7.setTitle("Swingy6");
        frame7.pack();
        frame7.setVisible(false);
    }

    public void guiHerosDeathMessage(){
        JPanel panel = new JPanel();
        JButton okay = new JButton("okay");
        JLabel deadMessage = new JLabel("You have Died, may you rest in peace");
        panel.setBorder(BorderFactory.createEmptyBorder(150, 150, 150, 150));
        panel.setLayout(new GridLayout(0, 1));
        panel.add(deadMessage);
        panel.add(okay);
        okay.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
    frame14.add(panel, BorderLayout.CENTER);
    frame14.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame14.setTitle("Swingy7");
    frame14.pack();
    frame14.setVisible(true);
    }

    public void monstDeafeatedMessage(String monsterDeath){
        JPanel panel = new JPanel();
        JButton okay = new JButton("okay");
        panel.setBorder(BorderFactory.createEmptyBorder(150, 150, 150, 150));
        panel.setLayout(new GridLayout(0, 1));
        Object[] options = {"OK"};
        int n = JOptionPane.showOptionDialog(this,
                       "You have Deafeated "+monsterDeath,"Title",
                       JOptionPane.PLAIN_MESSAGE,
                       JOptionPane.QUESTION_MESSAGE,
                       null,
                       options,
                       options[0]);
        frame8.add(panel, BorderLayout.CENTER);
        frame8.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame8.setTitle("Swingy8");
        frame8.pack();
        frame8.setVisible(false);
    }

    public void amountOfExpGiven(int monsterExp){
        JPanel panel = new JPanel();
        JButton okay = new JButton("okay");
        panel.setBorder(BorderFactory.createEmptyBorder(150, 150, 150, 150));
        panel.setLayout(new GridLayout(0, 1));
        Object[] options = {"OK"};
        int n = JOptionPane.showOptionDialog(this,
                       "You have earned "+monsterExp+" Exp","Title",
                       JOptionPane.PLAIN_MESSAGE,
                       JOptionPane.QUESTION_MESSAGE,
                       null,
                       options,
                       options[0]);

        frame9.add(panel, BorderLayout.CENTER);
        frame9.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame9.setTitle("Swingy9");
        frame9.pack();
        frame9.setVisible(false);
    }

    public void playerLevelUpMessage(int playerLevel){
        JPanel panel = new JPanel();
        JButton okay = new JButton("okay");
        JLabel playerLvl = new JLabel("You have levelUp "+playerLevel);
        panel.setBorder(BorderFactory.createEmptyBorder(150, 150, 150, 150));
        panel.setLayout(new GridLayout(0, 1));
        panel.add(playerLvl);
        panel.add(okay);
        okay.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame10.dispose();
            }
        });

        frame10.add(panel, BorderLayout.CENTER);
        frame10.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame10.setTitle("Swingy10");
        frame10.pack();
        frame10.setVisible(true);
    }
    // private JLabel itemN = new JLabel("Do you want to equip item yes or no?");
    public void guiItemDropName(String itemName, String typeOfItem, char map[][], Hero player){
        JPanel panel = new JPanel();
        panel.setBorder(BorderFactory.createEmptyBorder(150, 150, 150, 150));
        panel.setLayout(new GridLayout(0, 1));
        frame11.dispose();
        if (JOptionPane.showConfirmDialog(null, "Do you want to equip item yes or no?"+itemName, "WARNING",
        JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                // yes option
                frame11.dispose();
                gameController.yesItemDrop(itemName, typeOfItem, map, player);
        } else {
            frame11.dispose();
            gameController.noItemDrop();
                // no option
        }
        frame11.add(panel, BorderLayout.CENTER);
        frame11.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame11.setTitle("Swingy11");
        frame11.pack();
        frame11.setVisible(false);
    }

    public void runOrFight(String command, int[] location, char map[][], String userInput, Hero player){
        JPanel panel = new JPanel();
        JButton fight = new JButton("Fight");
        JButton run = new JButton("Run");
        JLabel runOrFightMessage = new JLabel("Do you wish to Run or Fight");
        fight.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String fighting = "fight";
                frame4.dispose();
                gameController.fighting(command, location, map, fighting, player);
            }
        });
        run.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String running = "run";
                frame4.dispose();
                gameController.running(command, location, map, running, player);
                // gameController.fightingOrRunning(running, 1);
                // gameController.getInputRunOrFight(command, running);
            }
        });
        panel.setBorder(BorderFactory.createEmptyBorder(150, 150, 150, 150));
        panel.setLayout(new GridLayout(0, 1));
        panel.add(runOrFightMessage);
        panel.add(fight);
        panel.add(run);

        frame4.add(panel, BorderLayout.CENTER);
        frame4.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame4.setTitle("Swingy12");
        frame4.pack();
        frame4.setVisible(true);
    }
}