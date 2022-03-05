package Cards;

public interface AbstractFactory {
    AbstractResultCard createCard(String cardType, String color);
}
