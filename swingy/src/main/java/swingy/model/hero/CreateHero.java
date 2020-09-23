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
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import java.util.Scanner;

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
    public static Hero loadHero(String heroName, String charClass){
        try {
            String fullSaveFile = null;
            File saveGameFile = new File("SaveGame.txt");
            boolean exists = saveGameFile.exists();
            if (!exists)
			{
                System.out.println("Error: Missing file " + saveGameFile);
				System.exit(2);
			}
            Scanner scan = new Scanner(saveGameFile);
            while(scan.hasNextLine())
            {
                fullSaveFile = scan.nextLine();
            }
            String[] newString = fullSaveFile.split("[,]", 0);
            charClass = newString[1];
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
        } catch (Exception e) {
            //TODO: handle exception
        }
        return null;
    }
}