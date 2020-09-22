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

public abstract class Hero{
    private String heroName;
    private String charClass;
    protected Weapon weapon;
    protected Helm helm;
    protected Armour armour;
    protected int xp = 0;
    protected int level = 1;
    protected int health = 100;
    protected int attack = 0;
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
        return this.weapon.getItemHealth();
    }

    // public void setNewHelm(String newHelm){
    //     this.helm.setItemHelm(newHelm);
    // }
    public String getCurrentArmour(){
        return this.armour.getItemName();
    }

    public int getCurrentArmourDefence(){
        return this.weapon.getItemDefence();
    }

    // public void setNewArmour(String newArmour){
    //     this.armour.setItemArmour(newArmour);
    // }

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
        //level 1: 1000 level 2: 2450 level 3: 4800 level 4: 8050 level 5: 12200
        //1,450

        // 1,450
        // 2,350
        // 3,250
        // 4,150
        // if (this.xp >= this.levelUpexpIncrease){
        //     if (this.xp > this.levelUpexpIncrease){
        //         leftOver = this.xp - this.levelUpexpIncrease;
        //         this.level++;
        //         this.xp = leftOver;
        //         System.out.println("You have levelUp "+this.level);
        //         this.levelUpexpIncrease = this.levelUpexpIncrease ;
        //     }else{
        //         this.level++;
        //         this.xp = 0;
        //         System.out.println("You have levelUp "+this.level);
        //         this.levelUpexpIncrease = this.levelUpexpIncrease + 10;
        //     }
        // }
        if (this.xp >= 1000){
            leftOver = this.xp - this.levelUpexpIncrease;
            this.level++;
            this.xp = leftOver;
            System.out.println("You have levelUp "+this.level);
            this.health = 100;
        }else if (this.xp >= 2450){
            leftOver = this.xp - this.levelUpexpIncrease;
            this.level++;
            this.xp = leftOver;
            System.out.println("You have levelUp "+this.level);
            this.health = 100;
        }else if (this.xp >= 4800){
            leftOver = this.xp - this.levelUpexpIncrease;
            this.level++;
            this.xp = leftOver;
            System.out.println("You have levelUp "+this.level);
            this.health = 100;
        }else if (this.xp >= 8050){
            leftOver = this.xp - this.levelUpexpIncrease;
            this.level++;
            this.xp = leftOver;
            System.out.println("You have levelUp "+this.level);
            this.health = 100;
        }else if (this.xp >= 12200){
            leftOver = this.xp - this.levelUpexpIncrease;
            this.level++;
            this.xp = leftOver;
            System.out.println("You have levelUp "+this.level);
            this.levelUpexpIncrease = 12200;
            this.health = 100;
        }
    }

    public void setAttackWithWeapon(String newAttack){
        this.attack = this.attack - weapon.getItemAttack();
        this.weapon = new Weapon(newAttack);
        this.attack = this.attack + weapon.getItemAttack();
        System.out.println("new"+this.attack);
        System.out.println(weapon.getItemName());
        System.out.println(weapon.getItemAttack());
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
}