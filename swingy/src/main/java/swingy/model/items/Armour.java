/* ************************************************************************** */
/*                                                                            */
/*                                                        :::      ::::::::   */
/*   Armour.java                                        :+:      :+:    :+:   */
/*                                                    +:+ +:+         +:+     */
/*   By: svan-nie <marvin@42.fr>                    +#+  +:+       +#+        */
/*                                                +#+#+#+#+#+   +#+           */
/*   Created: 2020/09/15 15:28:19 by svan-nie          #+#    #+#             */
/*   Updated: 2020/09/15 15:28:19 by svan-nie         ###   ########.fr       */
/*                                                                            */
/* ************************************************************************** */

package swingy.model.items;

public class Armour extends Items{

    public Armour(String itemName){
        super(itemName);
        if (itemName.equals("Default")){
            this.itemDefence = 0;
        }else if(itemName.equals("Bronze Armour")){
            this.itemDefence = 2;
        }else if (itemName.equals("Iron Armour")){
            this.itemDefence = 4;
        }else if (itemName.equals("Silver Armour")){
            this.itemDefence = 6;
        }else if (itemName.equals("Dragon Armour")){
            this.itemDefence = 13;
        }
    }
}