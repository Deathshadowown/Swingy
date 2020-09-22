/* ************************************************************************** */
/*                                                                            */
/*                                                        :::      ::::::::   */
/*   Ogre.java                                          :+:      :+:    :+:   */
/*                                                    +:+ +:+         +:+     */
/*   By: svan-nie <marvin@42.fr>                    +#+  +:+       +#+        */
/*                                                +#+#+#+#+#+   +#+           */
/*   Created: 2020/09/21 21:35:00 by svan-nie          #+#    #+#             */
/*   Updated: 2020/09/21 21:35:00 by svan-nie         ###   ########.fr       */
/*                                                                            */
/* ************************************************************************** */

package swingy.model.monster;

public class Ogre extends Monster{

    public Ogre(String monsterName){
        super("Ogre", "Ogre");
        this.attack = 8;
        this.health = 100;
        this.defence = 7;
        this.xpGiven = 250;
    }
}