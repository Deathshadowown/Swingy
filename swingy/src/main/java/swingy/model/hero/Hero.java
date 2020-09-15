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

public abstract class Hero{
    private String heroName;
    private String charClass;
    protected int xp = 0;
    protected int level = 1;
    protected int health = 100;
    protected int attack = 0;
    protected int defence = 0;

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
}