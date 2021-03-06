import Maps.*;
import Players.*;
import UI.Console;
import UI.GraphicUI;
import UI.UIbase;

import java.util.Arrays;
import java.util.List;

public class GameRunner {
    private Board gameBoard;
    private Turn turn;
    private boolean canGameContinue;
    private ChatMediator mediator;
    private List<Player> playerList;
    private Group[] playerGroups = new Group[2];
    private UIbase console = new Console();
    private UIbase graphicUI = new GraphicUI(); //not in use for now

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

        this.canGameContinue = true;
        this.gameBoard = Board.getInstance();
        this.turn = new Turn();

        setupPlayers();
        this.playerList.get(0).send("Hey everyone, lets start?", console);
    }

    public void setupPlayers() {
        this.mediator = new ChatMediatorImpl();
        Player player1 = new PlayerImpl(mediator, "Ofir", new SpymasterRole(), "RED");
        Player player2 = new PlayerImpl(mediator, "Eyal", new SpymasterRole(), "BLUE");
        Player player3 = new PlayerImpl(mediator, "Guy", new RegularPlayerRole(), "RED");
        Player player4 = new PlayerImpl(mediator, "Roi", new RegularPlayerRole(), "BLUE");
        this.playerList = Arrays.asList(player1, player2, player3, player4);
        for(Player p : playerList) {
            lockedState.doAction(p, gameBoard,turn,  console);
            mediator.addPlayer(p);
        }
        this.playerGroups[0] = new Group("RED", List.of(player1), List.of(player3));
        this.playerGroups[1] = new Group("BLUE", List.of(player2), List.of(player4));
    }
    public void printWhoIsPlaying(Player player) {
        console.print("~*~*~*~*~*~*~*~*~*~");
        console.print("Player: " + player.getName() +
                "\nTeam: " + currentTeamPlay +
                "\nRole: " + currentRolePlay);
        console.print("~*~*~*~*~*~*~*~*~*~");
    }

    public void runGroupSpyMasters(Group group) {
        for(Player spymaster : group.getSpyMasters()) {
            currentTeamPlay = spymaster.getGroupColor();
            currentRolePlay = spymaster.getRole();
            playingState.doAction(spymaster, gameBoard, turn, console);
            lockedState.doAction(spymaster, gameBoard, turn, console);
        }
    }

    public boolean runGroupRegularPlayers(Group group) {
        for(Player regularPlayer : group.getRegularPlayers()) {
            currentTeamPlay = regularPlayer.getGroupColor();
            currentRolePlay = regularPlayer.getRole();
            canGameContinue = playingState.doAction(regularPlayer, gameBoard, turn, console);
            lockedState.doAction(regularPlayer, gameBoard, turn, console);
            if (!canGameContinue) {break; }
        }
        return canGameContinue;
    }

    public void gameLoop() {
        while (this.canGameContinue) {
            for(Group group : playerGroups) {
                runGroupSpyMasters(group);
                if (!runGroupRegularPlayers(group)) { return; }
            }
            this.turn.printTurnStatistics( console);
            this.turn.incrementTurnNumber();
        }
        this.turn.printWhoWon( console);
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
