package Cards;

public class BystanderCard implements AbstractResultCard{
    protected String color;
    protected boolean isUsed;
    public BystanderCard() {
        this.isUsed=false;
        this.color = "GRAY";
    }
    @Override
    public void useCard() {
        this.isUsed=true;
    }

    @Override
    public String getColor() {
        return color;
    }

    @Override
    public boolean isUsed() {
        return isUsed;
    }
}
