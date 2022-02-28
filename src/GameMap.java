import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

public class GameMap {
    //TODO : DELETE THIS FILE AND EXTEND NAMEMAP WITH THE OBSERVER AND ALL THAT.
    //array of spots (but show only location and colors)
    private GameMapSpot[][] grid = new GameMapSpot[5][5];

    //constructor w params for random names and spots.
    public GameMap(NameMap nameMap,MapCard mapCard){
        MapCardSpot[][] mapCardSpots = mapCard.GetMapCardSpot();
        NameMapSpot[][] nameMapSpots = nameMap.GetNameMapSpots();
        for (int i=0; i<this.grid.length; i++){
            for (int j=0; j<this.grid[i].length;j++){
                this.grid[i][j] = new GameMapSpot(i,j,nameMapSpots[i][j].getName(),mapCardSpots[i][j].getColor());
            }
        }
    }

}
