public class NotPlayState implements State {

    public boolean doAction(Player player, Board game_board, Turn turn) {
        System.out.println(player.name + " is in NotPlay state,"+"Role: "+player.getRole() +" , "+ player.getGroupColor());
        player.setState(this);
        return true;
    }

    public String toString(){
        return "NotPlay State";
    }
}