public class ColorCard implements AbstractResultCard{
    protected String color;
    protected boolean isUsed;
    public ColorCard(String color){
        this.color=color;
        this.isUsed=false;
    }
    @Override
    public String getClassName() {
        return this.getClass().getSimpleName();
    }

    @Override
    public void useCard() {
        this.isUsed=true;
    }
}
