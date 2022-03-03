public class PlayState implements State {

    public boolean doAction(Player player, Board game_board, Turn turn) {
        System.out.println(player.name + " is in Play state," + "Role: " + player.getRole() + " , " + player.getGroupColor());
        player.setState(this);
        return handlePlayerActions(player, game_board, turn);
    }

    public String toString() {
        return "Play State";
    }


    public boolean handlePlayerActions(Player player, Board game_board, Turn turn) {
        return player.getRole().doRole(player,game_board,turn);
    }

}