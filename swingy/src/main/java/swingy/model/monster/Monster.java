/* ************************************************************************** */
/*                                                                            */
/*                                                        :::      ::::::::   */
/*   Monster.java                                       :+:      :+:    :+:   */
/*                                                    +:+ +:+         +:+     */
/*   By: svan-nie <marvin@42.fr>                    +#+  +:+       +#+        */
/*                                                +#+#+#+#+#+   +#+           */
/*   Created: 2020/09/21 21:16:43 by svan-nie          #+#    #+#             */
/*   Updated: 2020/09/21 21:16:43 by svan-nie         ###   ########.fr       */
/*                                                                            */
/* ************************************************************************** */

package swingy.model.monster;

public class Monster{
    private String monsterName;
    private String monsterClass;
    protected int attack;
    protected int health;
    protected int defence;
    protected int xpGiven;

    public Monster(String monsterName, String monsterClass){
        this.monsterName = monsterName;
        this.monsterClass = monsterClass;
    }

    public String getMonsterName(){
        return this.monsterName;
    }

    public void setMonsterName(){
        this.monsterName = monsterName;
    }

    public String getMonsterClass(){
        return this.monsterClass;
    }

    public void setMonsterClass(){
        this.monsterClass = monsterClass;
    }
    
    public int getAttack(){
        return this.attack;
    }

    public int getHealth(){
        return this.health;
    }

    public int getDefence(){
        return this.defence;
    }

    public int getXpGiven(){
        return this.xpGiven;
    }
    public void setNewHealth(int newHealth){
        this.health = newHealth;
    }
}