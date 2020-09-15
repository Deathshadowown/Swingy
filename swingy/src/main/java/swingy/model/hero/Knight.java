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

    public Knight(String name, String charClass){
        super(name, charClass);
        this.atk = 4;
        this.def = 7;
        this.hp = 100;
    }
}