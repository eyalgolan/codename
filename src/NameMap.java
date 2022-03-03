import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Random;

public class NameMap {

    private static final Random rand = new Random();
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


    //from interface MAP TODO: crate common interface
    public NameMapSpot[][] GetNameMapSpots (){
        return this.grid;
    }

    public void printMap(){
//        String[][] array
        System.out.print("    |");
        for (int i = 0; i < grid[0].length; i++){
            System.out.print("    ");
            System.out.print(i+1);
            System.out.print("    |");
        }
        System.out.println();
        for (int i = 0; i < grid.length; i++){
            System.out.print("----+");
            for (int j = 0; j < grid[0].length; j++){
                System.out.print("---------+");
            }
            System.out.println();
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
            System.out.println();
        }
    }

    public void setCardOnNameMap(int i, int j, AbstractResultCard card){
        this.grid[i][j] = new NameMapSpot(i,j,"X-X-"+card.getColor()+"-X-X");
    }

}
