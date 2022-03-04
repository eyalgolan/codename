package Cards;

public class AssassinCard implements AbstractResultCard{
    protected String color;
    protected boolean isUsed;
    public AssassinCard(){
        this.isUsed=false;
        this.color = "BLACK";
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
