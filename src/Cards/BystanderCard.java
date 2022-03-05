package Cards;

public class BystanderCard implements AbstractResultCard{
    public static String color = "GRAY";
    protected boolean isUsed;
    public BystanderCard() {
        this.isUsed = false;
    }
    @Override
    public void useCard() {
        this.isUsed=true;
    }

    @Override
    public String getColor() {
        return this.color;
    }

    @Override
    public boolean isUsed() {
        return isUsed;
    }
}
