package Maps;

public class Turn {
    private int turnNumber;
    private int blueGroupScore;
    private int redGroupScore;

    public Turn() {
        this.turnNumber = 1;
        this.blueGroupScore = 0;
        this.redGroupScore = 0;
    }

    public int getTurnNumber() {
        return turnNumber;
    }

    public int getBlueGroupScore() {
        return blueGroupScore;
    }

    public int getRedGroupScore() {
        return redGroupScore;
    }

    public void incrementTurnNumber() {
        this.turnNumber++;
    }

    public void setBlueGroupScore(int blueGroupScore) {
        this.blueGroupScore = blueGroupScore;
    }

    public void setRedGroupScore(int redGroupScore) {
        this.redGroupScore = redGroupScore;
    }

    public void printTurnStatistics() {
        System.out.println("~*~*~*~*~*~*~*~*~*~ Maps.Turn " + this.turnNumber + " ~*~*~*~*~*~*~*~*~*~");
        System.out.println("Blue group score: " + this.blueGroupScore);
        System.out.println("Red group score: " + this.redGroupScore);
        System.out.println("~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~");
    }

    public void printWhoWon() {
        if (this.blueGroupScore > this.redGroupScore) {
            System.out.println("~*~*~*~*~*~*~*~*~*~");
            System.out.println("The blue group won!");
            System.out.println("~*~*~*~*~*~*~*~*~*~");
        }
        else if (this.redGroupScore > this.blueGroupScore) {
            System.out.println("~*~*~*~*~*~*~*~*~*~");
            System.out.println("The red group won!");
            System.out.println("~*~*~*~*~*~*~*~*~*~");
        }
        else {
            System.out.println("~*~*~*~*~*~*~*~*~*~");
            System.out.println("It's a draw!");
            System.out.println("~*~*~*~*~*~*~*~*~*~");
        }
    }

    public void printSuddenDeath(String groupColor) {
        System.out.println("~*~*~*~*~*~*~*~*~*~");
        System.out.println("The " + groupColor + " group lost.");
        System.out.println("~*~*~*~*~*~*~*~*~*~");
    }
}
