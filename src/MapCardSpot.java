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
        public String toString(){
            switch (this){
                case GRAY -> {
                    return ("GRAY");
                }
                case RED -> {
                    return ("RED");
                }
                case BLUE -> {
                    return ("BLUE");
                }
                case BLACK -> {
                    return ("BLACK");
                }
                default -> {return null;}
            }
        }
    };
    private final Colors color;
    // constructor
    public MapCardSpot(int x, int y,Colors color) {
        super(x, y);
        this.color = color;
    }

    public String getContent(){
        return this.color.toString();
    }

    public Colors getColor() {
        return color;
    }
}
