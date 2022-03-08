package Players;

import UI.UIbase;

public interface ChatMediator {
    void sendMessage(String msg, Player user, UIbase console);
    void addPlayer(Player user);
}
