/* ************************************************************************** */
/*                                                                            */
/*                                                        :::      ::::::::   */
/*   Dragon.java                                        :+:      :+:    :+:   */
/*                                                    +:+ +:+         +:+     */
/*   By: svan-nie <marvin@42.fr>                    +#+  +:+       +#+        */
/*                                                +#+#+#+#+#+   +#+           */
/*   Created: 2020/09/21 21:34:19 by svan-nie          #+#    #+#             */
/*   Updated: 2020/09/21 21:34:19 by svan-nie         ###   ########.fr       */
/*                                                                            */
/* ************************************************************************** */

package swingy.model.monster;

public class Dragon extends Monster{

    public Dragon(String monsterName){
        super("Dragon", "Dragon");
        this.attack = 5;
        this.health = 100;
        this.defence = 5;
        this.xpGiven = 150;
    }
}