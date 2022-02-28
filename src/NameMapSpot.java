public class NameMapSpot extends Spot{
    private String name;

    // constructor
    public NameMapSpot(int x, int y, String name) {
        super(x,y);
        this.name = name;
    }


    public String getName(){
        return this.name;
    }
}
