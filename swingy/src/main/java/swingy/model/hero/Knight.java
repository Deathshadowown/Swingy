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

public class Knight extends Hero{

    public Knight(String heroName){
        super(heroName, "Knight");
        this.attack = 4;
        this.defence = 7;
        this.health = 100;
    }
}