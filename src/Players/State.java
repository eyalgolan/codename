package Players;

import Maps.Board;
import Maps.Turn;
import UI.UIbase;

public interface State {
    boolean doAction(Player player, Board game_board, Turn turn, UIbase console);
    String toString();
}
