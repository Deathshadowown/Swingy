/* ************************************************************************** */
/*                                                                            */
/*                                                        :::      ::::::::   */
/*   App.java                                           :+:      :+:    :+:   */
/*                                                    +:+ +:+         +:+     */
/*   By: svan-nie <marvin@42.fr>                    +#+  +:+       +#+        */
/*                                                +#+#+#+#+#+   +#+           */
/*   Created: 2020/09/15 15:28:14 by svan-nie          #+#    #+#             */
/*   Updated: 2020/09/24 16:24:02 by svan-nie         ###   ########.fr       */
/*                                                                            */
/* ************************************************************************** */

package swingy;

import swingy.model.hero.CreateHero;
import swingy.model.hero.*;

import swingy.controller.GameController;

public class App 
{
    public static void main( String[] args )
    {
        byte interfaces = 0;
        try {            
            if (args.length > 0 && args.length < 2) {
                if (args[0].toLowerCase().equals("console")){
                    System.out.println( "You useing the Console");
                    interfaces = 1;
                }else if (args[0].toLowerCase().equals("gui")){
                    interfaces = 2;
                    System.out.println("You useing the GUI");
                }else{
                    System.out.println("Incorrect info given Please use Gui or Console");
                    System.exit(2);
                }
                new GameController(interfaces);
            }else{
                System.out.println("Please enter a valid command Gui or Console only");
                System.exit(2);
            }
        } catch (Exception e) {
            System.out.println("unexpected Error");
        }
    }
}
