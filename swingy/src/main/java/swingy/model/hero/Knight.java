/* ************************************************************************** */
/*                                                                            */
/*                                                        :::      ::::::::   */
/*   Knight.java                                        :+:      :+:    :+:   */
/*                                                    +:+ +:+         +:+     */
/*   By: svan-nie <marvin@42.fr>                    +#+  +:+       +#+        */
/*                                                +#+#+#+#+#+   +#+           */
/*   Created: 2020/09/15 15:31:40 by svan-nie          #+#    #+#             */
/*   Updated: 2020/09/15 15:31:40 by svan-nie         ###   ########.fr       */
/*                                                                            */
/* ************************************************************************** */

package swingy.model.hero;

import swingy.model.items.Weapon;
import swingy.model.items.Armour;
import swingy.model.items.Helm;

public class Knight extends Hero{

    public Knight(String heroName){
        super(heroName, "Knight");
        this.attack = 4;
        this.defence = 7;
        this.health = 100;
        this.weapon = new Weapon("Default");
        this.armour = new Armour("Default");
        this.helm = new Helm("Default");
    }
}