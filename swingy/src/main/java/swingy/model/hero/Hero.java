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
    private String name;
    private String charClass;
    protected int xp = 0;
    protected int lvl = 1;
    protected int hp = 100;
    protected int atk = 0;
    protected int def = 0;

    public Hero(String name, String charClass){
        this.name = name;
        this.charClass = charClass;
    }

    public int getXp(){
        return this.xp;
    }
    
    public int getLvl(){
        return this.lvl;
    }
    
    public int getHp(){
        return this.hp;
    }

    public int getAtk(){
        return this.atk;
    }
    
    public int getDef(){
        return this.def;
    }
}