public class PlayingState implements State {

    public boolean doAction(Player player, Board game_board, Turn turn) {
        System.out.println(player.name + " is now playing." +
                           "\nRole: " + player.getRole() +
                           "\nGroup: " + player.getGroupColor());
        player.setState(this);
        return handlePlayerActions(player, game_board, turn);
    }

    @Override
    public String toString() {
        return "Playing state";
    }


    public boolean handlePlayerActions(Player player, Board game_board, Turn turn) {
        return player.getRole().doRole(player,game_board,turn);
    }
}