import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ResultCardPile implements AbstractCardPile {
    List<AbstractResultCard> resultCards;
    AbstractFactory resultCardFactory;

    public ResultCardPile() {
        this.resultCards = new ArrayList<>();
        this.resultCardFactory = new ResultCardFactory();

        addCards("Color", "RED", 9);
        addCards("Color", "BLUE", 8);
        addCards("Bystander", "GREY", 7);
        addCards("Assassin", "BLACK", 1);
    }

    public void addCards(String cardType, String cardColor, int amount) {
        for(int i = 0 ; i < amount ; i++) {
            this.resultCards.add(this.resultCardFactory.createCard(cardType, cardColor));
        }
    }

    public AbstractResultCard draw(String cardType) {
        for(AbstractResultCard card: resultCards) {
            if (Objects.equals(card.getColor(), cardType) && !card.isUsed()) {
                card.useCard();
                return card;
            }
        }
        return null;
    }
}
