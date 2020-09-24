/* ************************************************************************** */
/*                                                                            */
/*                                                        :::      ::::::::   */
/*   Map.java                                           :+:      :+:    :+:   */
/*                                                    +:+ +:+         +:+     */
/*   By: svan-nie <marvin@42.fr>                    +#+  +:+       +#+        */
/*                                                +#+#+#+#+#+   +#+           */
/*   Created: 2020/09/18 14:49:11 by svan-nie          #+#    #+#             */
/*   Updated: 2020/09/18 14:49:11 by svan-nie         ###   ########.fr       */
/*                                                                            */
/* ************************************************************************** */

package swingy.model;

public class Map{

    private char map[][];
    private int mapSize;

    public void generateMap(int playerLevel) {
		map = null;
		mapSize = (playerLevel - 1) * 5 + 10 - (playerLevel % 2);
		map = new char[mapSize][mapSize];
        int i = 0;
        int j = 0;
        while (i < mapSize)
        {
            while (j < mapSize)
            {
                map[i][j] = 'O';
                j++;
            }
            j = 0;
            i++;
        }
    }

    public void printMap(char map[][]){
        int i = 0;
        int j = 0;
        while (i < map.length)
        {
            while (j < map[i].length)
            {
                System.out.print(map[i][j]+" ");
                j++;
            }
            System.out.println();
            j = 0;
            i++;
        }
    }

    public char[][] getMap()
    {
        return map;
    }

    public int getMapSize()
    {
        return mapSize;
    }
    
    public void addPlayerToMap() {
		map[(int) Math.ceil(mapSize / 2)][(int) Math.ceil(mapSize / 2)] = 'P';
    }

    public void addLoadedPlayerToMap(int[] playerLocation){
        map[playerLocation[0]][playerLocation[1]] = 'P';
    }

    public void addMonstersToMap(){
        int i = 0;
        int j = 0;
        int count = 0;
        String postion = null;
        int count2 = 2;
        int counting2 = 0;
        while (i < map.length)
        {
            while(j < map[i].length)
            {
                postion = String.valueOf(map[i][j]);
                if (postion.equals("P"))
                {
                    break ;
                }
                if (count == count2){
                    if (counting2 == 1){
                        count2--;
                    }else if (count2 == 0){
                        count2++;
                    }
                    map[i][j] = 'E';
                    count = 0;
                }
                count++;
                j++;
            }
            j = 0;
            i++;
        }
    }
}