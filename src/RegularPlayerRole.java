import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class RegularPlayerRole implements PlayerRole{
    @Override
    public boolean doRole(Player player, Board game_board, Turn turn) {
        System.out.println("\n~*~*~*~*~*~*~*~*~*~GAME BOARD~*~*~*~*~*~*~*~*~*~\n");
        game_board.getNameMap().printMap();
        System.out.println("\n\n\n");

        String playerGroup = player.getGroupColor();
        Scanner sc= new Scanner(System.in);
        System.out.print("Enter the row, column location of each word you choose, " +
                "in the following format: row,column#row,column");
        String playerInput = sc.nextLine();
        player.send(playerInput);
        return handleRegularPlayer(playerInput, playerGroup, game_board, turn);
    }

    private boolean handleRegularPlayer(String playerInput, String playerGroup,Board game_board, Turn turn) {

        String[] playerAction = playerInput.split("#");
        for (String action : playerAction) {
            String[] wordLocation = action.split(",");
            int wordRow = Integer.parseInt(wordLocation[0]);
            int wordColumn = Integer.parseInt(wordLocation[1]);
            String locationColor = game_board.getMapCard().getMapCardSpot()[wordRow-1][wordColumn-1].getColor().toString();
            if (locationColor.equals(playerGroup)) {
                if (playerGroup.equals("BLUE")) {
                    turn.setBlueGroupScore(turn.getBlueGroupScore() + 1);
                    game_board.getResultCardPile().draw("BLUE");
                } else if (playerGroup.equals("RED")) {
                    turn.setRedGroupScore(turn.getRedGroupScore() + 1);
                    game_board.getResultCardPile().draw("RED");
                }
            } else if (locationColor.equals("BLACK")) {
                game_board.getResultCardPile().draw("BLACK");
                if (playerGroup.equals("BLUE")) {
                    turn.setBlueGroupScore(-1);
                } else if (playerGroup.equals("RED")) {
                    turn.setRedGroupScore(-1);
                }
                return false; //gameNotOver = false
            } else {
                game_board.getResultCardPile().draw("GRAY");
            }
        }
        return true;
    }

}
