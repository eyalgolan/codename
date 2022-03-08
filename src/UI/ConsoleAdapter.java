package UI;

public class ConsoleAdapter implements UIadapter{
    @Override
    public void printToScreen(String txt) {
        System.out.println(txt);
    }
}
