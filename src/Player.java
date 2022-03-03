public abstract class Player {
    protected ChatMediator mediator;
    protected String name;
    private PlayerRole role;
    private String groupColor;
    private State state;

    public Player(ChatMediator med, String name, PlayerRole role, String groupColor){
        this.mediator=med;
        this.name=name;
        this.role = role;
        this.groupColor = groupColor;
        this.state = null;
    }

    public PlayerRole getRole() {
        return role;
    }

    public String getGroupColor() {
        return groupColor;
    }

    public void setState(State state){
        this.state = state;
    }

    public State getState(){
        return state;
    }

    public abstract void send(String msg);
    public abstract void receive(String msg);
}