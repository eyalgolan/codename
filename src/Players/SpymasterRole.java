package Players;

import Maps.Board;
import Maps.Turn;
import UI.UIbase;

import java.util.Scanner;

public class SpymasterRole implements PlayerRole {
    @Override
    public boolean doRole(Player player, Board game_board, Turn turn, UIbase console) {
        console.print("\n~*~*~*~*~*~*~*~*~*~SPY MASTER CARD~*~*~*~*~*~*~*~*~*~\n");
        game_board.getMapCard().printMap(console);
        console.print("\n\n\n");
        console.print("\n~*~*~*~*~*~*~*~*~*~GAME BOARD~*~*~*~*~*~*~*~*~*~\n");
        game_board.getNameMap().printMap(console);
        console.print("\n\n\n");
        String playerGroup = player.getGroupColor();
        Scanner sc = new Scanner(System.in);
        console.print("Give a hint to your team players");
        String playerInput = sc.nextLine();
        player.send(playerInput, console);
        return true;
    }

    @Override
    public String toString() {
        return "Spymaster";
    }
}
