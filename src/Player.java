public abstract class Player {
    protected ChatMediator mediator;
    protected String name;
    private PlayerRole role;
    private String groupColor;
    public Player(ChatMediator med, String name, PlayerRole role, String groupColor){
        this.mediator=med;
        this.name=name;
        this.role = role;
        this.groupColor = groupColor;
    }

    public PlayerRole getRole() {
        return role;
    }

    public String getGroupColor() {
        return groupColor;
    }

    public abstract void send(String msg);
    public abstract void receive(String msg);
}