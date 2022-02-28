public class Spot {
    private int location_x;
    private int location_y;

    // constructor
    public Spot(int x, int y) {
        this.location_x = x;
        this.location_y = y;
    }

    public int getLocation_x(){
        return  this.location_x;
    }
    public int getLocation_y(){
        return this.location_y;
    }

}
