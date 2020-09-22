/* ************************************************************************** */
/*                                                                            */
/*                                                        :::      ::::::::   */
/*   Helm.java                                          :+:      :+:    :+:   */
/*                                                    +:+ +:+         +:+     */
/*   By: svan-nie <marvin@42.fr>                    +#+  +:+       +#+        */
/*                                                +#+#+#+#+#+   +#+           */
/*   Created: 2020/09/21 23:28:29 by svan-nie          #+#    #+#             */
/*   Updated: 2020/09/21 23:28:29 by svan-nie         ###   ########.fr       */
/*                                                                            */
/* ************************************************************************** */

package swingy.model.items;

public class Helm extends Items{
    
    public Helm(String itemName){
        super(itemName);
        if (itemName.equals("Default")){
            this.itemHealth = 0;
        }else if (itemName.equals("Bronze Helm")){
            this.itemHealth = 20;
        }else if (itemName.equals("Iron Helm")){
            this.itemHealth = 40;
        }else if (itemName.equals("Silver Helm")){
            this.itemHealth = 60;
        }else if (itemName.equals("Dragon Helm")){
            this.itemHealth = 100;
        }
    }
}