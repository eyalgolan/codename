package Players;

import Maps.Board;
import Maps.Turn;
import Players.Player;

public interface State {
    boolean doAction(Player player, Board game_board, Turn turn);
    String toString();
}
