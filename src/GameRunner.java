public class GameRunner {

    public static void main(String[] args) {
        ChatMediator mediator = new ChatMediatorImpl();
        Player player1 = new PlayerImpl(mediator, "Pankaj");
        Player player2 = new PlayerImpl(mediator, "Lisa");
        Player player3 = new PlayerImpl(mediator, "Saurabh");
        Player player4 = new PlayerImpl(mediator, "David");
        mediator.addPlayer(player1);
        mediator.addPlayer(player2);
        mediator.addPlayer(player3);
        mediator.addPlayer(player4);
        player1.send("Hi All");
    }
}
