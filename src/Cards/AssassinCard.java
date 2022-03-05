package Cards;

public class AssassinCard implements AbstractResultCard{
    public static String color = "BLACK";
    protected boolean isUsed;
    public AssassinCard(){
        this.isUsed=false;
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
