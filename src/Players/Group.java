package Players;

import java.util.List;

public class Group {
    private String color;
    private List<Player> spyMasters;
    private List<Player> regularPlayers;

    public Group(String color, List<Player> spyMasters, List<Player> regularPlayers) {
        this.color = color;
        this.spyMasters = spyMasters;
        this.regularPlayers = regularPlayers;
    }

    public String getColor() {
        return color;
    }

    public List<Player> getRegularPlayers() {
        return regularPlayers;
    }

    public List<Player> getSpyMasters() {
        return spyMasters;
    }
}
