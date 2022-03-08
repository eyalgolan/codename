package Players;

import Maps.Board;
import Maps.Turn;
import UI.UIbase;

public interface PlayerRole {
    boolean doRole(Player player, Board game_board, Turn turn, UIbase console);
    String toString();
}
