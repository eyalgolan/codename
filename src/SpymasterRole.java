import java.util.Scanner;

public class SpymasterRole implements PlayerRole {
    @Override
    public boolean doRole(Player player, Board game_board, Turn turn) {
        System.out.println("\n~*~*~*~*~*~*~*~*~*~SPY MASTER CARD~*~*~*~*~*~*~*~*~*~\n");
        game_board.getMapCard().printMap();
        System.out.println("\n\n\n");
        System.out.println("\n~*~*~*~*~*~*~*~*~*~GAME BOARD~*~*~*~*~*~*~*~*~*~\n");
        game_board.getNameMap().printMap();
        System.out.println("\n\n\n");
        String playerGroup = player.getGroupColor();
        Scanner sc = new Scanner(System.in);
        System.out.println("Give a hint to your team players");
        String playerInput = sc.nextLine();
        player.send(playerInput);
        return true;
    }

    @Override
    public String toString() {
        return "Spymaster";
    }
}
