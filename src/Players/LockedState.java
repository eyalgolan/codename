package Players;

import Maps.Board;
import Maps.Turn;
import UI.UIbase;

public class LockedState implements State {

    public boolean doAction(Player player, Board game_board, Turn turn,UIbase console) {
        console.print(player.name + " is now locked. " +
                           "Role: " + player.getRole() + ". " +
                           "Group: " + player.getGroupColor());
        player.setState(this);
        return true;
    }

    @Override
    public String toString(){
        return "Locked state";
    }
}