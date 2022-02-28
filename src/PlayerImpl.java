public class PlayerImpl extends Player {
    public PlayerImpl(ChatMediator med, String name, PlayerRole role) {
        super(med, name, role);
    }
    @Override
    public void send(String msg){
        System.out.println(this.name+": Sending Message="+msg);
        mediator.sendMessage(msg, this);
    }
    @Override
    public void receive(String msg) {
        System.out.println(this.name+": Received Message:"+msg);
    }
}