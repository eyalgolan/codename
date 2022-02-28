public class NameCard implements AbstractCard {
    protected String word;
    public NameCard(String word) {
        this.word = word;
    }

    public String getWord (){ return this.word; }
}
