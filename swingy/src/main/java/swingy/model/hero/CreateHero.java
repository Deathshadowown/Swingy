/* ************************************************************************** */
/*                                                                            */
/*                                                        :::      ::::::::   */
/*   CreateHero.java                                    :+:      :+:    :+:   */
/*                                                    +:+ +:+         +:+     */
/*   By: svan-nie <marvin@42.fr>                    +#+  +:+       +#+        */
/*                                                +#+#+#+#+#+   +#+           */
/*   Created: 2020/09/15 17:30:39 by svan-nie          #+#    #+#             */
/*   Updated: 2020/09/15 17:30:39 by svan-nie         ###   ########.fr       */
/*                                                                            */
/* ************************************************************************** */

package swingy.model.hero;

public class CreateHero{
    public static Hero newHero(String heroName, String charClass){
        switch (charClass) {
            case "Assassin":
                return (new Assassin(heroName));
            case "Knight":
                return (new Knight(heroName));
            case "Wizard":
                return (new Wizard(heroName));
            default:
            return null;
        }
    }
}