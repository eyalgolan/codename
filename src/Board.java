import java.util.ArrayList;

public class Board {
    //Singelton Class
    private static Board singel_instance_board = null;
    private NameCardPile nameCardPile;
    private MapCard mapCard; //locations and colors
    private NameMap nameMap; //locations and names
    private ResultCardPile resultCardPile;
    public String s;
   // public GameMap gameMap; //location colors and name

    //Constructor
    private Board()
    {
        this.s = "Some Description of the board - might need to delete..";
        this.nameCardPile = new NameCardPile("WordsTest.txt"); //TODO: name of the file - how to chose what constructor we need to use (singelton)??
        this.resultCardPile = new ResultCardPile();
        this.nameMap = new NameMap(nameCardPile);
        this.mapCard = new MapCard();
     //   this.gameMap = new GameMap(this.nameMap,this.mapCard);
        //this.cardPile = new CardPile();
    }

    //Static method to create instance of singelton Board class
    public static Board getInstance()
    {
        if(singel_instance_board == null){
            singel_instance_board = new Board();
        }
        return singel_instance_board;
    }

    //getter nameMap (for all players)
    public NameMap getNameMap(){
        return this.nameMap;
    }

    //getter MapCard (only for masters)
    public MapCard getMapCard(){
        return this.mapCard;
    }

    public ResultCardPile getResultCardPile() {
        return this.resultCardPile;
    }
}
