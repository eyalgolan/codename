public class Board {
    //Singelton Class
    private static Board singel_instance_board = null;
    private CardPile; //TODO
    private MapCard; //
    private Map; //TODO
    public String s;

    //Constructor
    private Board()
    {
        s = "Some Description of the board - might need to delete..";
    }

    //Static method to create instance of singelton Board class
    public static Board getInstance()
    {
        if(singel_instance_board == null){
            singel_instance_board = new Board();
        }
        return singel_instance_board;
    }
}
