/* ************************************************************************** */
/*                                                                            */
/*                                                        :::      ::::::::   */
/*   Hero.java                                          :+:      :+:    :+:   */
/*                                                    +:+ +:+         +:+     */
/*   By: svan-nie <marvin@42.fr>                    +#+  +:+       +#+        */
/*                                                +#+#+#+#+#+   +#+           */
/*   Created: 2020/09/15 15:28:24 by svan-nie          #+#    #+#             */
/*   Updated: 2020/09/15 15:28:24 by svan-nie         ###   ########.fr       */
/*                                                                            */
/* ************************************************************************** */

package swingy.model.hero;

import swingy.model.items.Items;
import swingy.model.items.Weapon;
import swingy.model.items.Helm;
import swingy.model.items.Armour;

import java.io.File;
import java.util.Scanner;
import java.io.FileWriter;
import java.io.IOException;

import javax.validation.constraints.AssertFalse;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public abstract class Hero{
    @NotBlank(message = "Name is Mandatory")
	@NotNull(message = "Name can't be null")
	@Size(min = 2, max = 10, message = "Name must be between {min} and {max}")
	@Pattern(regexp = "^[a-zA-Z0-9]*$", message = "Name must be Alphanumeric")
    private String heroName;
    @NotNull (message = "Hero class can't be null")
    private String charClass;
    @NotNull (message = "Weapon can't be null")
    protected Weapon weapon;
    @NotNull (message = "Helm can't be null")
    protected Helm helm;
    @NotNull (message = "Armour can't be null")
    protected Armour armour;
    @Min(value = 0, message = "Xp must be more than 0")
    protected int xp = 0;
    @Min(value = 0, message = "Level must be more than 1")
    protected int level = 1;
    @Min(value = 0, message = "Hero needs Hp to be alive. Must be more than 0")
    protected int health = 100;
    @Min(value = 0, message = "No attack, no game. Must be more than 0")
    protected int attack = 0;
    @Min(value = 0, message = "No defense, no build. Must be more than 0")
    protected int defence = 0;
    protected int levelUpexpIncrease = 1000;

    public Hero(String heroName, String charClass){
        this.heroName = heroName;
        this.charClass = charClass;
    }

    public String getHeroName(){
        return this.heroName;
    }
    public String getCharClass(){
        return this.charClass;
    }

    public String getCurrentWeapon(){
        return this.weapon.getItemName();
    }

    public int getCurrentWeaponAttack(){
        return this.weapon.getItemAttack();
    }

    public void setNewWeapon(String newWeapon){
        this.weapon.setItemWeapon(newWeapon);
    }
    
    public String getCurrentHelm(){
        return this.helm.getItemName();
    }

    public int getCurrentHelmHealth(){
        return this.helm.getItemHealth();
    }

    public String getCurrentArmour(){
        return this.armour.getItemName();
    }

    public int getCurrentArmourDefence(){
        return this.armour.getItemDefence();
    }

    public int getXp(){
        return this.xp;
    }

    public int getLevel(){
        return this.level;
    }
    
    public int getHealth(){
        return this.health;
    }

    public int getAttack(){
        return this.attack;
    }
    
    public int getDefence(){
        return this.defence;
    }
    public void setNewHealth(int newHealth){
        this.health = newHealth;
    }

    public void setXp(int newXp){
        this.xp =  this.xp + newXp;
    }

    public void setLevel(int levelUp){
        this.level = levelUp;
    }

    public void expPerLevel(){
        int leftOver = 0;

        if (this.xp >= 1000){
            leftOver = this.xp - this.levelUpexpIncrease;
            this.level++;
            this.xp = leftOver;
            System.out.println("You have levelUp "+this.level);
            this.health = 100 + helm.getItemHealth();
        }else if (this.xp >= 2450){
            leftOver = this.xp - this.levelUpexpIncrease;
            this.level++;
            this.xp = leftOver;
            System.out.println("You have levelUp "+this.level);
            this.health = 100 + helm.getItemHealth();
        }else if (this.xp >= 4800){
            leftOver = this.xp - this.levelUpexpIncrease;
            this.level++;
            this.xp = leftOver;
            System.out.println("You have levelUp "+this.level);
            this.health = 100 + helm.getItemHealth();
        }else if (this.xp >= 8050){
            leftOver = this.xp - this.levelUpexpIncrease;
            this.level++;
            this.xp = leftOver;
            System.out.println("You have levelUp "+this.level);
            this.health = 100 + helm.getItemHealth();
        }else if (this.xp >= 12200){
            leftOver = this.xp - this.levelUpexpIncrease;
            this.level++;
            this.xp = leftOver;
            System.out.println("You have levelUp "+this.level);
            this.levelUpexpIncrease = 12200;
            this.health = 100 + helm.getItemHealth();
        }
    }

    public void setAttackWithWeapon(String newAttack){
        this.attack = this.attack - weapon.getItemAttack();
        this.weapon = new Weapon(newAttack);
        this.attack = this.attack + weapon.getItemAttack();
    }

    public void setHealthWithHelm(String newHealth){
        this.health = this.health - helm.getItemHealth();
        if (this.health <= 0)
        {
            this.health = this.health + helm.getItemHealth();
            System.out.println("Could not swap out helm it would of killed you!!.");
        }else{
            this.helm = new Helm(newHealth);
            this.health = this.health + helm.getItemHealth();
        }
    }

    public void setDefenceWithArmour(String newDefence){
        this.defence = this.defence - armour.getItemDefence();
        this.armour = new Armour(newDefence);
        this.defence = this.defence + armour.getItemDefence();
    }

    public void saveGame(int mapLocation[]){
        try {
            File saveFile = new File("saveGame.txt");
            if (saveFile.createNewFile()){
                FileWriter myWriter = new FileWriter("saveGame.txt");
                System.out.println("File created: "+saveFile.getName());
                myWriter.write(this.heroName+",");
                myWriter.write(this.charClass+",");
                myWriter.write(weapon.getItemName()+",");
                myWriter.write(helm.getItemName()+",");
                myWriter.write(armour.getItemName()+",");
                myWriter.write(this.xp+",");
                myWriter.write(this.level+",");
                myWriter.write(this.health+",");
                myWriter.write(this.attack+",");
                myWriter.write(this.defence+",");
                myWriter.write(this.levelUpexpIncrease+",");
                myWriter.write(mapLocation[0]+",");
                myWriter.write(mapLocation[1]+",");
                myWriter.close();
            }else{
                System.out.println("File already exists.");
                System.out.println("Updating");
                FileWriter myWriter = new FileWriter("saveGame.txt");
                myWriter.write(this.heroName+",");
                myWriter.write(this.charClass+",");
                myWriter.write(weapon.getItemName()+",");
                myWriter.write(helm.getItemName()+",");
                myWriter.write(armour.getItemName()+",");
                myWriter.write(this.xp+",");
                myWriter.write(this.level+",");
                myWriter.write(this.health+",");
                myWriter.write(this.attack+",");
                myWriter.write(this.defence+",");
                myWriter.write(this.levelUpexpIncrease+",");
                myWriter.write(mapLocation[0]+",");
                myWriter.write(mapLocation[1]+",");
                myWriter.close();
            }
            
        } catch (IOException e) {
            System.out.println("An error occurred.");
          } catch (Exception e) {
            System.out.println("ERROR: Something is wrong");
        }
    }

    public int[] loadGame(){
        int[] mapLocation = new int[2];
        try {
            String fullSaveFile = null;
            File saveGameFile = new File("SaveGame.txt");
            boolean exists = saveGameFile.exists();
            if (!exists)
			{
                System.out.println("Error: Missing file " + saveGameFile);
				System.exit(2);
			}
            Scanner scan = new Scanner(saveGameFile);
            while(scan.hasNextLine())
            {
                fullSaveFile = scan.nextLine();
            }
            String[] newString = fullSaveFile.split("[,]", 0);
            this.heroName = newString[0];
            this.charClass = newString[1];
            this.weapon = new Weapon(newString[2]);
            this.helm = new Helm(newString[3]);
            this.armour = new Armour(newString[4]);
            this.xp = Integer.parseInt(newString[5]);
            this.level = Integer.parseInt(newString[6]);
            this.health = Integer.parseInt(newString[7]);
            this.attack = Integer.parseInt(newString[8]);
            this.defence = Integer.parseInt(newString[9]);
            this.levelUpexpIncrease = Integer.parseInt(newString[10]);
            mapLocation[0] = Integer.parseInt(newString[11]);
            mapLocation[1] = Integer.parseInt(newString[12]);
            return mapLocation;
        } catch (Exception e) {
            System.out.println("ERROR: Something is wrong");
        }
        return null;
    }
}