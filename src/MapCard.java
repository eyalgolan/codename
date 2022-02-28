import java.io.IOException;
import java.lang.reflect.Array;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class MapCard {
    //array of spots (but show only location and colors)
    private MapCardSpot[][] grid = new MapCardSpot[5][5];
    private int numOfBlue = 0 , numOfRed = 0, numOfGray = 0, numOfBlack = 0;

    //constructor without params for random colors and spots.
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
        for (int i=0; i<grid.length; i++){
            for (int j=0; j<grid[i].length;j++){
                MapCardSpot.Colors color = ChoseRandomColor();
                grid[i][j] = new MapCardSpot(i,j,color);
            }
        }
        return grid;
    }

    public MapCardSpot.Colors ChoseRandomColor(){
        List<MapCardSpot.Colors> ColorChoices = new ArrayList<MapCardSpot.Colors>();
        MapCardSpot.Colors color;
        //
        //NUM_OF_PARTICIPATE
        //TODO: check if more enum needed and how many colors at the map from each!
        int chose = 2;
        if (numOfBlack<1){
            ColorChoices.add(MapCardSpot.Colors.BLACK);
        }
        if (numOfBlue<8){
            ColorChoices.add(MapCardSpot.Colors.BLUE);
        }
        if(numOfRed<9){
            ColorChoices.add(MapCardSpot.Colors.RED);
        }
        if(numOfGray<7){
            ColorChoices.add(MapCardSpot.Colors.GRAY);
        }
        color = MapCardSpot.Colors.randomColorForSpot(ColorChoices);
        //TODO: CHANGE THE COUNTERS HERE!
        return color;
    }

    public MapCardSpot[][] GetMapCardSpot(){
        return this.grid;
    }
}
