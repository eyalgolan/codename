import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Random;

public class NameMap {

    private static final Random rand = new Random();

    //array of spots (but show only location and colors)
    private NameMapSpot[][] grid;

    //constructor w params for random names and spots.
    public NameMap(String configMapFileName){
        grid = InitMap(configMapFileName);
    }

    // constructor with specific list of Spots
    public NameMap (NameMapSpot[][] grid){
        this.grid = grid;
    }

    public NameMapSpot[][] InitMap(String configMapFileName){
        ArrayList<String> names = LoadNameFile(configMapFileName);
        NameMapSpot[][] grid = new NameMapSpot[5][5];
        for (int i=0; i<grid.length; i++){
            for (int j=0; j<grid[i].length;j++){
                int index = ChoseRandomName(names);
                String name = names.get(index);
                names.remove(index); // remove that name from the list to make sure there is no duplicate words at the grid.
                grid[i][j] = new NameMapSpot(i,j,name);
            }
        }
        return grid;
    }

    // load config file
    public ArrayList<String> LoadNameFile (String configMapFileName){
        ArrayList<String> names = new ArrayList<String>();
        try{
            for (String name : Files.readAllLines(Paths.get("C:\\Users\\obezra\\IdeaProjects\\codename\\src\\WordsTest.txt"))){ //TODO: configMapFileName
//            for (String name : Files.readAllLines(pathToFile)){ //TODO: configMapFileName
                names.add(name);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return names;
    }

    //chose random name TODO: make it real random
    public int ChoseRandomName(ArrayList<String> names){
        int index = rand.nextInt(names.size());
        return index;
    }

    public NameMapSpot[][] GetNameMapSpots (){
        return this.grid;
    }

}
