public class GameRunner {

    public static void main(String[] args) {
        // ofir's main
        Board game_board = Board.getInstance();
        Chat chatroom = new Chat();
        Turn turn = new Turn();
        System.out.println("check");
        
        // eyal's main
        ChatMediator mediator = new ChatMediatorImpl();
        Player player1 = new PlayerImpl(mediator, "Ofir");
        Player player2 = new PlayerImpl(mediator, "Eyal");
        Player player3 = new PlayerImpl(mediator, "Guy");
        Player player4 = new PlayerImpl(mediator, "Roi");
        mediator.addPlayer(player1);
        mediator.addPlayer(player2);
        mediator.addPlayer(player3);
        mediator.addPlayer(player4);
        player1.send("Hey everyone, lets start?");
    }
    // check the turn and give permission to player - update Turn
    // get input from chat -
    //  if spymaster - 1) get input of clue
    //                 2) check clue valid - if it does publish it on chat and update Turn to the player on his team
    //                                       if it doesn't - get another input (loop until valid)
    //  if player -    1) get input of guess
    //                 2) check if guess is correct
 }
