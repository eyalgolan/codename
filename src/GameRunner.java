import java.util.Arrays;
import java.util.List;

public class GameRunner {
    private Board game_board;
    private Turn turn;
    private boolean gameNotOver;
    private ChatMediator mediator;
    private List<Player> playerList;

    //states
    private State playState;
    private State notPlayState;

    //current
    private String currentTeamPlay;
    private PlayerRole currentRolePlay;

    public GameRunner() {
        //states
        this.playState = new PlayState();
        this.notPlayState = new NotPlayState();

        this.gameNotOver = true;
        this.game_board = Board.getInstance();
        this.turn = new Turn();

        System.out.println("\n~*~*~*~*~*~*~*~*~*~eyal's main~*~*~*~*~*~*~*~*~*~\n");

        // eyal's main
        this.mediator = new ChatMediatorImpl();
        Player player1 = new PlayerImpl(mediator, "Ofir", new SpymasterRole(), "RED");
        Player player2 = new PlayerImpl(mediator, "Eyal", new SpymasterRole(), "BLUE");
        Player player3 = new PlayerImpl(mediator, "Guy", new RegularPlayerRole(), "RED");
        Player player4 = new PlayerImpl(mediator, "Roi", new RegularPlayerRole(), "BLUE");

        playerList = Arrays.asList(player1, player2, player3, player4);

        for(Player p : playerList) {
            gameNotOver = notPlayState.doAction(p,game_board,turn);
            mediator.addPlayer(p);
        }
        player1.send("Hey everyone, lets start?");
    }

    public void gameLoop() {
        while (this.gameNotOver) {
            for(Player player : playerList) {
                currentTeamPlay = player.getGroupColor();
                currentRolePlay = player.getRole();
                System.out.println("Turn : " + player.name + ",Team: " + currentTeamPlay+",Role: "+currentRolePlay);
                gameNotOver = playState.doAction(player,game_board,turn);
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
