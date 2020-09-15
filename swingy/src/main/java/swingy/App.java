/* ************************************************************************** */
/*                                                                            */
/*                                                        :::      ::::::::   */
/*   App.java                                           :+:      :+:    :+:   */
/*                                                    +:+ +:+         +:+     */
/*   By: svan-nie <marvin@42.fr>                    +#+  +:+       +#+        */
/*                                                +#+#+#+#+#+   +#+           */
/*   Created: 2020/09/15 15:28:14 by svan-nie          #+#    #+#             */
/*   Updated: 2020/09/15 15:28:15 by svan-nie         ###   ########.fr       */
/*                                                                            */
/* ************************************************************************** */

package swingy;

public class App 
{
    public static void main( String[] args )
    {
        try {            
            if (args.length > 0 && args.length < 2) {
                if (args[0].equals("Console")){
                System.out.println( "You useing the Console");
                }else if (args[0].equals("Gui")){
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
