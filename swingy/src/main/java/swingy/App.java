/* ************************************************************************** */
/*                                                                            */
/*                                                        :::      ::::::::   */
/*   App.java                                           :+:      :+:    :+:   */
/*                                                    +:+ +:+         +:+     */
/*   By: svan-nie <marvin@42.fr>                    +#+  +:+       +#+        */
/*                                                +#+#+#+#+#+   +#+           */
/*   Created: 2020/09/15 15:28:14 by svan-nie          #+#    #+#             */
/*   Updated: 2020/09/15 19:14:39 by svan-nie         ###   ########.fr       */
/*                                                                            */
/* ************************************************************************** */

package swingy;

import swingy.model.hero.CreateHero;
import swingy.model.hero.*;

public class App 
{
    // static CreateHero newHero = new CreateHero();
    public static void main( String[] args )
    {
        // String heroName = "Shadow";
        // String charClass = "Assassin"
        // Hero player = null;
        // player = CreateHero.hero();
        Assassin sin = new Assassin("Shadow");
        Hero player = null;
        player = CreateHero.newHero("shadow", "Assassin");
        System.out.println(player.getAttack());
        System.out.println(player.getHeroName());
        System.out.println(player.getCharClass());
        // System.out.println(player.getHealth());
        try {            
            if (args.length > 0 && args.length < 2) {
                if (args[0].toLowerCase().equals("Console")){
                    System.out.println( "You useing the Console");
                }else if (args[0].toLowerCase().equals("gui")){
                    System.out.println("You useing the GUI");
                }else{
                    System.out.println("Incorrect info given Please use Gui or Console");
                    System.exit(2);
                }
            }else{
                System.out.println("Please enter a valid command Gui or Console only");
                System.exit(2);
            }
        } catch (Exception e) {
            System.out.println("unexpected Error");
        }
    }
}
