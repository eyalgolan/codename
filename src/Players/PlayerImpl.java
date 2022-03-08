package Players;

import UI.UIbase;

public class PlayerImpl extends Player {
    public PlayerImpl(ChatMediator med, String name, PlayerRole role, String groupColor) {
        super(med, name, role, groupColor);
    }
    @Override
    public void send(String msg, UIbase console){
        console.print(this.name+": Sending Message="+msg);
        mediator.sendMessage(msg, this,console);
    }
    @Override
    public void receive(String msg, UIbase console) {
        console.print(this.name+": Received Message:" + msg);
    }
}