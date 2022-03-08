package UI;

public class GraphicUI implements UIbase{
    GraphicUIAdapter adapter;

    public GraphicUI(){
        this.adapter = new GraphicUIAdapter();
    }

    public GraphicUIAdapter getAdapter() {
        return adapter;
    }

    public void setAdapter(GraphicUIAdapter adapter) {
        this.adapter = adapter;
    }

    public void print(String txt){
        adapter.printToScreen(txt);
    }
}
