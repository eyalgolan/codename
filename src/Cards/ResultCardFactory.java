package Cards;

public class ResultCardFactory implements AbstractFactory{
    //use getCard method to get object of type shape
    @Override
    public AbstractResultCard createCard(String cardType, String color){
        if(cardType == null){
            return null;
        }
        if(cardType.equalsIgnoreCase("Assassin")){
            return new AssassinCard();

        } else if(cardType.equalsIgnoreCase("Bystander")){
            return new BystanderCard();

        } else if(cardType.equalsIgnoreCase("Color")){
            return new ColorCard(color);
        }

        return null;
    }
}
