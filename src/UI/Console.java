package UI;

public class Console implements UIbase{
    ConsoleAdapter adapter;

    public Console(){
        this.adapter = new ConsoleAdapter();
    }

    public ConsoleAdapter getAdapter() {
        return adapter;
    }

    public void setAdapter(ConsoleAdapter adapter) {
        this.adapter = adapter;
    }

    public void print(String txt){
        adapter.printToScreen(txt);
    }
}
