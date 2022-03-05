package Players;

import Maps.Board;
import Maps.Turn;

public interface State {
    boolean doAction(Player player, Board game_board, Turn turn);
    String toString();
}
