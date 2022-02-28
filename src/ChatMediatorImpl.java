import java.util.ArrayList;
import java.util.List;
public class ChatMediatorImpl implements ChatMediator {
    private final List<Player> players;
    public ChatMediatorImpl(){
        this.players=new ArrayList<>();
    }
    @Override
    public void addPlayer(Player player){
        this.players.add(player);
    }
    @Override
    public void sendMessage(String msg, Player player) {
        for(Player p : this.players){
            //message should not be received by the user sending it
            if(p != player){
                p.receive(msg);
            }
        }
    }
}