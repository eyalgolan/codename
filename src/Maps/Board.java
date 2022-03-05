package Maps;

import Cards.NameCardPile;
import Cards.ResultCardPile;

public class Board {
    // Singelton Class
    private static Board single_instance_board = null;
    private NameCardPile nameCardPile;
    private MapCard mapCard; //locations and colors
    private NameMap nameMap; //locations and names
    private ResultCardPile resultCardPile;
    private String PathToWords = "WordsTest.txt";

    //Constructor
    private Board()
    {
        this.nameCardPile = new NameCardPile(PathToWords);
        this.resultCardPile = new ResultCardPile();
        this.nameMap = new NameMap(nameCardPile);
        this.mapCard = new MapCard();
    }

    //Static method to create instance of singelton Maps.Board class
    public static Board getInstance()
    {
        if(single_instance_board == null){
            single_instance_board = new Board();
        }
        return single_instance_board;
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
