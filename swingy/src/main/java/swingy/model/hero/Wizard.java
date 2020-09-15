/* ************************************************************************** */
/*                                                                            */
/*                                                        :::      ::::::::   */
/*   Wizard.java                                        :+:      :+:    :+:   */
/*                                                    +:+ +:+         +:+     */
/*   By: svan-nie <marvin@42.fr>                    +#+  +:+       +#+        */
/*                                                +#+#+#+#+#+   +#+           */
/*   Created: 2020/09/15 15:31:31 by svan-nie          #+#    #+#             */
/*   Updated: 2020/09/15 15:31:31 by svan-nie         ###   ########.fr       */
/*                                                                            */
/* ************************************************************************** */

package swingy.model.hero;

public class Wizard extends Hero{

    public Wizard(String name, String charClass){
        super(name, charClass);
        this.atk = 10;
        this.def = 2;
        this.hp = 100;
    }
}