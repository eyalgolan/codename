import Maps.*;
import Players.*;

import java.util.Arrays;
import java.util.List;

public class GameRunner {
    private Board gameBoard;
    private Turn turn;
    private boolean gameNotOver;
    private ChatMediator mediator;
    private List<Player> playerList;

    //states
    private State playingState;
    private State lockedState;

    //current
    private String currentTeamPlay;
    private PlayerRole currentRolePlay;

    public GameRunner() {
        //states
        this.playingState = new PlayingState();
        this.lockedState = new LockedState();

        this.gameNotOver = true;
        this.gameBoard = Board.getInstance();
        this.turn = new Turn();


        // eyal's main
        setupPlayers();
        this.playerList.get(0).send("Hey everyone, lets start?");
    }

    public void setupPlayers() {
        this.mediator = new ChatMediatorImpl();
        Player player1 = new PlayerImpl(mediator, "Ofir", new SpymasterRole(), "RED");
        Player player2 = new PlayerImpl(mediator, "Eyal", new SpymasterRole(), "BLUE");
        Player player3 = new PlayerImpl(mediator, "Guy", new RegularPlayerRole(), "RED");
        Player player4 = new PlayerImpl(mediator, "Roi", new RegularPlayerRole(), "BLUE");
        this.playerList = Arrays.asList(player1, player2, player3, player4);
        for(Player p : playerList) {
            gameNotOver = lockedState.doAction(p, gameBoard,turn);
            mediator.addPlayer(p);
        }
    }
    public void printWhoIsPlaying(Player player) {
        System.out.println("~*~*~*~*~*~*~*~*~*~");
        System.out.println("Maps.Turn : " + player.getName() +
                "\nTeam: " + currentTeamPlay +
                "\nRole: " + currentRolePlay);
        System.out.println("~*~*~*~*~*~*~*~*~*~");
    }
    public void gameLoop() {
        while (this.gameNotOver) {
            for(Player player : playerList) {
                currentTeamPlay = player.getGroupColor();
                currentRolePlay = player.getRole();
                printWhoIsPlaying(player);
                gameNotOver = playingState.doAction(player, gameBoard, turn);
                lockedState.doAction(player, gameBoard, turn);
            }
            this.turn.printTurnStatistics();
            this.turn.incrementTurnNumber();
        }
    }

    public static void main(String[] args) {
        GameRunner game = new GameRunner();
        game.gameLoop();
    }
    // check the turn and give permission to player - update Maps.Turn
    // get input from chat -
    //  if spymaster - 1) get input of clue
    //                 2) check clue valid - if it does publish it on chat and update Maps.Turn to the player on his team
    //                                       if it doesn't - get another input (loop until valid)
    //  if player -    1) get input of guess
    //                 2) check if guess is correct
 }
