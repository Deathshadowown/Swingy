/* ************************************************************************** */
/*                                                                            */
/*                                                        :::      ::::::::   */
/*   Weapon.java                                        :+:      :+:    :+:   */
/*                                                    +:+ +:+         +:+     */
/*   By: svan-nie <marvin@42.fr>                    +#+  +:+       +#+        */
/*                                                +#+#+#+#+#+   +#+           */
/*   Created: 2020/09/15 15:28:28 by svan-nie          #+#    #+#             */
/*   Updated: 2020/09/15 15:28:28 by svan-nie         ###   ########.fr       */
/*                                                                            */
/* ************************************************************************** */

package swingy.model.items;

public class Weapon extends Items{

    public Weapon(String itemName){
        super(itemName);
        if (itemName.equals("Default")){
            this.itemAttack = 0;
        }else if (itemName.equals("Bronze sword")){
            this.itemAttack = 5;
        }else if (itemName.equals("Iron Sword")){
            this.itemAttack = 7;
        }else if (itemName.equals("Silver Sword")){
            this.itemAttack = 9;
        }else if (itemName.equals("Dragon Sword")){
            this.itemAttack = 15;
        }
    }
}