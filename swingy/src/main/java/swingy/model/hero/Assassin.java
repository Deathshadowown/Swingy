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

public class Assassin extends Hero{

    public Assassin(String heroName){
        super(heroName, "Assassin");
        this.attack = 7;
        this.defence = 4;
        this.health = 100;
    }
}