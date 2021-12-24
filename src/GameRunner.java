public class GameRunner {

    public static void main(String[] args) {
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
}
