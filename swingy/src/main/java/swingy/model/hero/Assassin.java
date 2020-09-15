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

    public Assassin(String name, String charClass){
        super(name, charClass);
        this.atk = 7;
        this.def = 4;
        this.hp = 100;
    }
}