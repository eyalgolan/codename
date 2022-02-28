import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ResultCardPile implements AbstractCardPile {
    List<AbstractResultCard> resultCards;
    AbstractFactory resultCardFactory;

    public ResultCardPile() {
        this.resultCards = new ArrayList<AbstractResultCard>();
        this.resultCardFactory = new ResultCardFactory();
    }
    public AbstractCard draw(String cardType) {
        for(AbstractResultCard card: resultCards) {
            if (Objects.equals(card.getClassName(), cardType)) {
                card.useCard();
                return (AbstractCard) card;
            }
        }
        return null;
    }
}
