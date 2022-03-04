package Cards;

public class ColorCard implements AbstractResultCard{
    protected String color;
    protected boolean isUsed;
    public ColorCard(String color){
        this.color=color;
        this.isUsed=false;
    }

    @Override
    public String getColor() {
        return color;
    }

    @Override
    public void useCard() {
        this.isUsed=true;
    }

    @Override
    public boolean isUsed() {
        return isUsed;
    }
}
