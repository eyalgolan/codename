public abstract class Player {
    protected ChatMediator mediator;
    protected String name;
    private PlayerRole role;
    public Player(ChatMediator med, String name, PlayerRole role){
        this.mediator=med;
        this.name=name;
        this.role = role;
    }
    public abstract void send(String msg);
    public abstract void receive(String msg);
}