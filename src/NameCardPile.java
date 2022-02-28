import java.util.ArrayList;
import java.util.List;

public class NameCardPile implements CardPile {
    List<NameCard> nameCards;

    public NameCardPile() {
        this.nameCards = new ArrayList<>();
    }

    @Override
    public void doAction() {

    }

    public AbstractCard draw() {
        NameCard card = nameCards.get(0);
        nameCards.remove(0);
        return (AbstractCard) card;
    }
}
