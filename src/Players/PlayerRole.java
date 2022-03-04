package Players;

import Maps.Board;
import Maps.Turn;

public interface PlayerRole {
    boolean doRole(Player player, Board game_board, Turn turn);
    String toString();
}
