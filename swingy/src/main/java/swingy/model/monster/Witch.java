/* ************************************************************************** */
/*                                                                            */
/*                                                        :::      ::::::::   */
/*   Witch.java                                         :+:      :+:    :+:   */
/*                                                    +:+ +:+         +:+     */
/*   By: svan-nie <marvin@42.fr>                    +#+  +:+       +#+        */
/*                                                +#+#+#+#+#+   +#+           */
/*   Created: 2020/09/21 21:35:04 by svan-nie          #+#    #+#             */
/*   Updated: 2020/09/21 21:35:04 by svan-nie         ###   ########.fr       */
/*                                                                            */
/* ************************************************************************** */

package swingy.model.monster;

public class Witch extends Monster{

    public Witch(String monsterName){
        super(monsterName, "Witch");
        this.attack = 7;
        this.hp = 100;
        this.defence = 6;
        this.xpGiven = 20;
    }
}