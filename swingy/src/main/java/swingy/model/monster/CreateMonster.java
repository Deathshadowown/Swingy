/* ************************************************************************** */
/*                                                                            */
/*                                                        :::      ::::::::   */
/*   CreateMonster.java                                 :+:      :+:    :+:   */
/*                                                    +:+ +:+         +:+     */
/*   By: svan-nie <marvin@42.fr>                    +#+  +:+       +#+        */
/*                                                +#+#+#+#+#+   +#+           */
/*   Created: 2020/09/21 23:25:22 by svan-nie          #+#    #+#             */
/*   Updated: 2020/09/21 23:25:22 by svan-nie         ###   ########.fr       */
/*                                                                            */
/* ************************************************************************** */

package swingy.model.monster;

import swingy.model.monster.Monster;

public class CreateMonster{
    public static Monster newMonster(String monsterName, String monsterClass){
        switch (monsterClass) {
            case "Dragon":
                return (new Dragon(monsterName));
            case "Witch":
                return (new Witch(monsterName));
            case "Ogre":
                return (new Ogre(monsterName));
            default:
            return null;
        }
    }
}