public class BystanderCard implements AbstractResultCard{
    protected boolean isUsed;
    public BystanderCard(){
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
