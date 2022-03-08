package Players;

import Maps.Board;
import Maps.Turn;
import UI.UIbase;

public class PlayingState implements State {

    public boolean doAction(Player player, Board game_board, Turn turn, UIbase console) {
        console.print(player.name + " is now playing." +
                           "\nRole: " + player.getRole() +
                           "\nGroup: " + player.getGroupColor());
        player.setState(this);
        return handlePlayerActions(player, game_board, turn, console);
    }

    @Override
    public String toString() {
        return "Playing state";
    }


    public boolean handlePlayerActions(Player player, Board game_board, Turn turn, UIbase console) {
        return player.getRole().doRole(player,game_board,turn,console);
    }
}