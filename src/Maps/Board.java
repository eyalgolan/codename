package Maps;

import Cards.NameCardPile;
import Cards.ResultCardPile;

public class Board {
    // Singelton Class
    private static Board singel_instance_board = null;
    private NameCardPile nameCardPile;
    private MapCard mapCard; //locations and colors
    private NameMap nameMap; //locations and names
    private ResultCardPile resultCardPile;
    public String s;

    //Constructor
    private Board()
    {
        this.nameCardPile = new NameCardPile("WordsTest.txt"); //TODO: name of the file - how to chose what constructor we need to use (singelton)??
        this.resultCardPile = new ResultCardPile();
        this.nameMap = new NameMap(nameCardPile);
        this.mapCard = new MapCard();
    }

    //Static method to create instance of singelton Maps.Board class
    public static Board getInstance()
    {
        if(singel_instance_board == null){
            singel_instance_board = new Board();
        }
        return singel_instance_board;
    }

    // getter nameMap (for all players)
    public NameMap getNameMap(){
        return this.nameMap;
    }

    // getter Maps.MapCard (only for masters)
    public MapCard getMapCard(){
        return this.mapCard;
    }

    public ResultCardPile getResultCardPile() {
        return this.resultCardPile;
    }
}
