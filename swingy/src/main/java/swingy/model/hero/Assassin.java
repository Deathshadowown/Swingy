/* ************************************************************************** */
/*                                                                            */
/*                                                        :::      ::::::::   */
/*   Assassin.Java                                      :+:      :+:    :+:   */
/*                                                    +:+ +:+         +:+     */
/*   By: svan-nie <marvin@42.fr>                    +#+  +:+       +#+        */
/*                                                +#+#+#+#+#+   +#+           */
/*   Created: 2020/09/15 15:30:15 by svan-nie          #+#    #+#             */
/*   Updated: 2020/09/15 15:30:15 by svan-nie         ###   ########.fr       */
/*                                                                            */
/* ************************************************************************** */

package swingy.model.hero;

import swingy.model.items.Weapon;
import swingy.model.items.Armour;
import swingy.model.items.Helm;

public class Assassin extends Hero{

    public Assassin(String heroName){
        super(heroName, "Assassin");
        this.attack = 7;
        this.defence = 4;
        this.health = 100;
        this.weapon = new Weapon("Default");
        this.armour = new Armour("Default");
        this.helm = new Helm("Default");
    }
}