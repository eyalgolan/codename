import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Stack;

public class NameCardPile implements CardPile {
    private Stack<NameCard> nameCards;
    private static final Random rand = new Random();

    public NameCardPile(String configMapFileName) {

        this.nameCards = new Stack<NameCard>();

        ArrayList<String> names = LoadNameFile(configMapFileName);
        for (int i = 0; i < 25; i++){
            int index = ChoseRandomName(names);
            String name = names.get(index);
            names.remove(index); // remove that name from the list to make sure there is no duplicate words at the grid.
            this.nameCards.add(new NameCard(name));
        }
    }

    // load config file
    public ArrayList<String> LoadNameFile (String configMapFileName){
        ArrayList<String> names = new ArrayList<String>();
        try{
            for (String name : Files.readAllLines(Paths.get("C:\\Users\\obezra\\IdeaProjects\\codename\\src\\WordsTest.txt"))){ //TODO: configMapFileName
//            for (String name : Files.readAllLines(pathToFile)){ //TODO: configMapFileName
                names.add(name);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return names;
    }

    //chose random name TODO: make it real random
    public int ChoseRandomName(ArrayList<String> names){
        int index = rand.nextInt(names.size());
        return index;
    }

    public String drawNameCard() {
        NameCard card = (NameCard)draw();
        return card.getWord();
    }

    public AbstractCard draw() {
        NameCard card = nameCards.pop();
        return card;
    }
}
