import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MapCardSpot extends Spot{
    static int NUM_OF_PARTICIPATES = 2; //TODO: ADD MORE PARTICIPATES?
    public enum Colors {
        BLUE,RED,GRAY,BLACK; // TODO: ADD MORE COLORS?
        private static final Random rand = new Random();
        public static Colors randomColorForSpot(List<Colors> ColorChoices){
            //TODO : change random to real random
            return ColorChoices.get(rand.nextInt(ColorChoices.size()));
        }
    };
    private final Colors color;
    // constructor
    public MapCardSpot(int x, int y,Colors color) {
        super(x, y);
        this.color = color;
    }

    public Colors getColor(){
        return this.color;
    }

}
