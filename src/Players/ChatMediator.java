package Players;

public interface ChatMediator {
    void sendMessage(String msg, Player user);
    void addPlayer(Player user);
}
