public class AssassinCard implements AbstractResultCard{
    protected boolean isUsed;
    public AssassinCard(){
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
