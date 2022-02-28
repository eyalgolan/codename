import java.util.List;

public class GameRunner {
    private Board game_board;
    private Turn turn;
    private boolean gameNotOver;
    private ChatMediator mediator;
    private List<Player> playerList;
    public GameRunner() {
        Board game_board = Board.getInstance();
        //Turn turn = new Turn();
        System.out.println("\n~*~*~*~*~*~*~*~*~*~GAME BOARD~*~*~*~*~*~*~*~*~*~\n");
        game_board.getNameMap().printMap();
        System.out.println("\n\n\n");
        System.out.println("\n~*~*~*~*~*~*~*~*~*~SPY MASTER CARD~*~*~*~*~*~*~*~*~*~\n");
        game_board.getMapCard().printMap();

        System.out.println("\n\n\n");
        System.out.println("\n~*~*~*~*~*~*~*~*~*~eyal's main~*~*~*~*~*~*~*~*~*~\n");

        // eyal's main
        ChatMediator mediator = new ChatMediatorImpl();
        Player player1 = new PlayerImpl(mediator, "Ofir", new SpymasterRole());
        Player player2 = new PlayerImpl(mediator, "Eyal", new SpymasterRole());
        Player player3 = new PlayerImpl(mediator, "Guy", new RegularPlayerRole());
        Player player4 = new PlayerImpl(mediator, "Roi", new RegularPlayerRole());

        playerList = Arrays.asList(player1, player2, player3, player4);

        for(Player p : playerList) {
            mediator.addPlayer(p);
        }
        player1.send("Hey everyone, lets start?");
    }
    public void gameLoop() {
//        while (this.gameNotOver) {
//
//        }
//        }
    }
    // check the turn and give permission to player - update Turn
    // get input from chat -
    //  if spymaster - 1) get input of clue
    //                 2) check clue valid - if it does publish it on chat and update Turn to the player on his team
    //                                       if it doesn't - get another input (loop until valid)
    //  if player -    1) get input of guess
    //                 2) check if guess is correct
 }
