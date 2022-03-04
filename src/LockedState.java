public class LockedState implements State {

    public boolean doAction(Player player, Board game_board, Turn turn) {
        System.out.println(player.name + " is now locked. " +
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