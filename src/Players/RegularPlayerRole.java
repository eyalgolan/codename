package Players;

import Cards.AssassinCard;
import Cards.BystanderCard;
import Cards.ColorCard;
import Maps.Board;
import Maps.Turn;

import java.util.Scanner;

public class RegularPlayerRole implements PlayerRole{
    @Override
    public boolean doRole(Player player, Board gameBoard, Turn turn) {
        System.out.println("\n~*~*~*~*~*~*~*~*~*~GAME BOARD~*~*~*~*~*~*~*~*~*~\n");
        gameBoard.getNameMap().printMap();
        System.out.println("\n\n\n");

        String playerGroup = player.getGroupColor();
        Scanner sc= new Scanner(System.in);
        System.out.print("Enter the row, column location of each word you choose, " +
                "in the following format: row,column#row,column");
        String playerInput = sc.nextLine();
        player.send(playerInput);
        return handleRegularPlayer(playerInput, playerGroup, gameBoard, turn);
    }

    private void makeMove(Turn turn, Board gameBoard, int wordRow, int wordColumn, String playerGroup) {
        if (playerGroup.equals("BLUE")) {
            turn.setBlueGroupScore(turn.getBlueGroupScore() + 1);
        } else if (playerGroup.equals("RED")) {
            turn.setRedGroupScore(turn.getRedGroupScore() + 1);
        }
        ColorCard colorCard = (ColorCard) gameBoard.getResultCardPile().draw(playerGroup);
        gameBoard.getNameMap().setCardOnNameMap(wordRow,wordColumn,colorCard);
    }

    private void makeMoveGray(Board gameBoard, int wordRow, int wordColumn) {
        BystanderCard card = (BystanderCard) gameBoard.getResultCardPile().draw(BystanderCard.color);
        gameBoard.getNameMap().setCardOnNameMap(wordRow,wordColumn,card);
    }
    private void makeMoveBlack(Turn turn, Board gameBoard, int wordRow, int wordColumn, String playerGroup) {
        AssassinCard card = (AssassinCard) gameBoard.getResultCardPile().draw(AssassinCard.color);
        gameBoard.getNameMap().setCardOnNameMap(wordRow,wordColumn,card);
        if (playerGroup.equals("BLUE")) {
            turn.setBlueGroupScore(-1);
            turn.printSuddenDeath(playerGroup);
        } else if (playerGroup.equals("RED")) {
            turn.setRedGroupScore(-1);
            turn.printSuddenDeath(playerGroup);
        }
    }

    private void makeOppositeMove(Turn turn, Board gameBoard, int wordRow, int wordColumn, String playerGroup) {
        if (playerGroup.equals("BLUE")) {
            makeMove(turn, gameBoard, wordRow, wordColumn, "RED");
        }
        else {
            makeMove(turn, gameBoard, wordRow, wordColumn, "BLUE");
        }
    }

    private boolean handleRegularPlayer(String playerInput, String playerGroup, Board gameBoard, Turn turn) {
        String[] playerAction = playerInput.split("#");
        boolean gameCanContinue = true;
        for (String action : playerAction) {
            String[] wordLocation = action.split(",");
            int wordRow = Integer.parseInt(wordLocation[0]) - 1;
            int wordColumn = Integer.parseInt(wordLocation[1]) - 1;
            String locationColor = gameBoard.getMapCard().getMapCardSpot()[wordRow][wordColumn].getColor();
            if (locationColor.equals(playerGroup)) {
                makeMove(turn, gameBoard, wordRow, wordColumn, playerGroup);
            } else if (locationColor.equals(AssassinCard.color)) {
                makeMoveBlack(turn, gameBoard, wordRow, wordColumn, playerGroup);
                gameCanContinue = false;
                break;
            } else if (locationColor.equals(BystanderCard.color)) {
                makeMoveGray(gameBoard, wordRow, wordColumn);
            }
            else {
                makeOppositeMove(turn, gameBoard, wordRow, wordColumn, playerGroup);
            }
        }
        return gameCanContinue;
    }

    @Override
    public String toString() {
        return "Regular player";
    }
}
