package Cards;

public interface AbstractFactory {
    public AbstractResultCard createCard(String cardType, String color);
}
