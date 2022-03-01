import java.util.Arrays;
import java.util.List;

public class GameRunner {
    private Board game_board;
    private Turn turn;
    private boolean gameNotOver;
    private ChatMediator mediator;
    private List<Player> playerList;

    public GameRunner() {
        this.gameNotOver = true;
        this.game_board = Board.getInstance();
        this.turn = new Turn();
        System.out.println("\n~*~*~*~*~*~*~*~*~*~GAME BOARD~*~*~*~*~*~*~*~*~*~\n");
        game_board.getNameMap().printMap();
        System.out.println("\n\n\n");
        System.out.println("\n~*~*~*~*~*~*~*~*~*~SPY MASTER CARD~*~*~*~*~*~*~*~*~*~\n");
        game_board.getMapCard().printMap();

        System.out.println("\n\n\n");
        System.out.println("\n~*~*~*~*~*~*~*~*~*~eyal's main~*~*~*~*~*~*~*~*~*~\n");

        // eyal's main
        this.mediator = new ChatMediatorImpl();
        Player player1 = new PlayerImpl(mediator, "Ofir", new SpymasterRole(), "RED");
        Player player2 = new PlayerImpl(mediator, "Eyal", new SpymasterRole(), "BLUE");
        Player player3 = new PlayerImpl(mediator, "Guy", new RegularPlayerRole(), "RED");
        Player player4 = new PlayerImpl(mediator, "Roi", new RegularPlayerRole(), "BLUE");

        playerList = Arrays.asList(player1, player2, player3, player4);

        for(Player p : playerList) {
            mediator.addPlayer(p);
        }
        player1.send("Hey everyone, lets start?");
    }

    public void handleRegularPlayer(String playerInput, String playerGroup) {
        String[] playerAction = playerInput.split("#");
        for(String action: playerAction) {
            String[] wordLocation = action.split(",");
            int wordRow = Integer.parseInt(wordLocation[0]);
            int wordColumn = Integer.parseInt(wordLocation[1]);
            String locationColor = game_board.getMapCard().getMapCardSpot()[wordRow][wordColumn].getColor().toString();
            if (locationColor.equals(playerGroup)) {
                if (playerGroup.equals("BLUE")) {
                    this.turn.setBlueGroupScore(this.turn.getBlueGroupScore() + 1);
                    this.game_board.getResultCardPile().draw("BLUE");
                } else if (playerGroup.equals("RED")) {
                    this.turn.setRedGroupScore(this.turn.getRedGroupScore() + 1);
                    this.game_board.getResultCardPile().draw("RED");
                }
            } else if (locationColor.equals("BLACK")) {
                this.game_board.getResultCardPile().draw("BLACK");
                if (playerGroup.equals("BLUE")) {
                    this.turn.setBlueGroupScore(-1);
                } else if (playerGroup.equals("RED")) {
                    this.turn.setRedGroupScore(-1);
                }
                this.gameNotOver = false;
            }
            else {
                this.game_board.getResultCardPile().draw("GRAY");
            }
        }
    }
    public void handlePlayerActions(Player player) {
        String playerGroup = player.getGroupColor();
        String playerInput = player.getRole().doRole();
        if (player.getRole() instanceof RegularPlayerRole) {
            handleRegularPlayer(playerInput, playerGroup);
        }
    }
    public void gameLoop() {
        while (this.gameNotOver) {
            for(Player player : playerList) {
                handlePlayerActions(player);
            }
            this.turn.printTurnStatistics();
            this.turn.incrementTurnNumber();
        }
    }

    public static void main(String[] args) {
        GameRunner game = new GameRunner();
        game.gameLoop();
    }
    // check the turn and give permission to player - update Turn
    // get input from chat -
    //  if spymaster - 1) get input of clue
    //                 2) check clue valid - if it does publish it on chat and update Turn to the player on his team
    //                                       if it doesn't - get another input (loop until valid)
    //  if player -    1) get input of guess
    //                 2) check if guess is correct
 }
