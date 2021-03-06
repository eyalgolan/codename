package Maps;

import Cards.AbstractResultCard;
import Cards.NameCardPile;
import UI.UIbase;

public class NameMap{
    private NameCardPile nameCardPile;

    //array of spots (but show only location and colors)
    private NameMapSpot[][] grid;

    //constructor w params for random names and spots.
    public NameMap(NameCardPile nameCardPile){
        this.nameCardPile = nameCardPile;
        grid = InitMap();
    }

    // constructor with specific list of Spots
    public NameMap (NameMapSpot[][] grid){
        this.grid = grid;
    }

    public NameMapSpot[][] InitMap(){
        NameMapSpot[][] grid = new NameMapSpot[5][5];
        for (int i=0; i<grid.length; i++){
            for (int j=0; j<grid[i].length;j++){
                String name = nameCardPile.drawNameCard();
                grid[i][j] = new NameMapSpot(i,j,name);
            }
        }
        return grid;
    }

    public NameMapSpot[][] GetNameMapSpots (){
        return this.grid;
    }

    public void printMap(UIbase console){
//        String[][] array
        System.out.print("    |");
        for (int i = 0; i < grid[0].length; i++){
            System.out.print("    ");
            System.out.print(i+1);
            System.out.print("    |");
        }
        console.print("");
        for (int i = 0; i < grid.length; i++){
            System.out.print("----+");
            for (int j = 0; j < grid[0].length; j++){
                System.out.print("---------+");
            }
            console.print("");
            System.out.print("  " + (i + 1) + " |");
            for (int j = 0; j < grid[0].length; j++){
                if (grid[i][j].getContent().length() < 10){
                    int spaces = (9 - grid[i][j].getContent().length()) / 2;
                    for (int k = 0; k < spaces; k++){
                        System.out.print(" ");
                    }
                    System.out.print(grid[i][j].getContent());
                    for (int k = 0; k < (9 - grid[i][j].getContent().length()) - spaces; k++){
                        System.out.print(" ");
                    }
                }
                else{
                    System.out.print(grid[i][j].getContent().substring(0, 9));
                }
                System.out.print("|");
            }
            console.print("");
        }
    }

    public void setCardOnNameMap(int i, int j, AbstractResultCard card){
        this.grid[i][j] = new NameMapSpot(i,j,"X-"+card.getColor()+"-X");
    }

}
