public interface State {
    boolean doAction(Player player, Board game_board, Turn turn);
    String toString();
}
