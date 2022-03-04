import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class MapCard {
    // array of spots (but show only location and colors)
    private MapCardSpot[][] grid = new MapCardSpot[5][5];
    private int numOfBlue = 0 , numOfRed = 0, numOfGray = 0, numOfBlack = 0;

    // constructor without params for random colors and spots.
    public MapCard(){
        grid = InitMapCard();
    }

    // constructor with specific list of Spots
    public MapCard (MapCardSpot[][] grid){
        this.grid = grid;
    }

    // constructor with config file
    public MapCard (String configMapFileName){
        ArrayList<String> names = new ArrayList<String>();
        try{
            for (String name : Files.readAllLines(Paths.get(configMapFileName))){
                names.add(name);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public MapCardSpot[][] InitMapCard(){
        MapCardSpot[][] grid = new MapCardSpot[5][5];
        for (int i = 0 ; i < grid.length ; i++){
            for (int j = 0 ; j < grid[i].length ; j++){
                MapCardSpot.Colors color = ChoseRandomColor();
                grid[i][j] = new MapCardSpot(i, j, color);
            }
        }
        return grid;
    }

    public MapCardSpot.Colors ChoseRandomColor(){
        List<MapCardSpot.Colors> ColorChoices = new ArrayList<MapCardSpot.Colors>();
        MapCardSpot.Colors color;
        //TODO: check if more enum needed and how many colors at the map from each!
        if (numOfBlack < 1){
            ColorChoices.add(MapCardSpot.Colors.BLACK);
        }
        if (numOfBlue < 8){
            ColorChoices.add(MapCardSpot.Colors.BLUE);
        }
        if(numOfRed < 9){
            ColorChoices.add(MapCardSpot.Colors.RED);
        }
        if(numOfGray < 7){
            ColorChoices.add(MapCardSpot.Colors.GRAY);
        }
        color = MapCardSpot.Colors.randomColorForSpot(ColorChoices);
        switch (color){
            case BLACK -> numOfBlack++;
            case BLUE -> numOfBlue++;
            case RED -> numOfRed++;
            case GRAY -> numOfGray++;
        }
        return color;
    }

    //from interface MAP TODO: crate common interface
    public MapCardSpot[][] getMapCardSpot(){
        return this.grid;
    }

    public void printMap(){
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
}

