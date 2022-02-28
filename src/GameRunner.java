public class GameRunner {

    public static void main(String[] args) {
        Board game_board = Board.getInstance();
        Chat chatroom = new Chat();
        Turn turn = new Turn();
        System.out.println("check");
    }
    // check the turn and give permission to player - update Turn
    // get input from chat -
    //  if spymaster - 1) get input of clue
    //                 2) check clue valid - if it does publish it on chat and update Turn to the player on his team
    //                                       if it doesn't - get another input (loop until valid)
    //  if player -    1) get input of guess
    //                 2) check if guess is correct
 }
