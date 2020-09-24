/* ************************************************************************** */
/*                                                                            */
/*                                                        :::      ::::::::   */
/*   Items.java                                         :+:      :+:    :+:   */
/*                                                    +:+ +:+         +:+     */
/*   By: svan-nie <marvin@42.fr>                    +#+  +:+       +#+        */
/*                                                +#+#+#+#+#+   +#+           */
/*   Created: 2020/09/15 15:28:26 by svan-nie          #+#    #+#             */
/*   Updated: 2020/09/15 15:28:26 by svan-nie         ###   ########.fr       */
/*                                                                            */
/* ************************************************************************** */

package swingy.model.items;

public class Items{
    private String itemName = null;
    protected int itemAttack;
    protected int itemDefence;
    protected int itemHealth;

    public Items(String itemName){
        this.itemName = itemName;
    }

    public String getItemName(){
        return this.itemName;
    }

    public int getItemAttack(){
        return this.itemAttack;
    }
    
    public void setItemWeapon(String weaponName){
        this.itemName = weaponName;
    }

    public int getItemDefence(){
        return this.itemDefence;
    }
    
    public int getItemHealth(){
        return this.itemHealth;
    }
}