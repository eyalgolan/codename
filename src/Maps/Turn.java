package Maps;

import UI.UIbase;

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

    public void printTurnStatistics(UIbase console) {
        console.print("~*~*~*~*~*~*~*~*~*~ Maps.Turn " + this.turnNumber + " ~*~*~*~*~*~*~*~*~*~");
        console.print("Blue group score: " + this.blueGroupScore);
        console.print("Red group score: " + this.redGroupScore);
        console.print("~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~");
    }

    public void printWhoWon(UIbase console) {
        if (this.blueGroupScore > this.redGroupScore) {
            console.print("~*~*~*~*~*~*~*~*~*~");
            console.print("The blue group won!");
            console.print("~*~*~*~*~*~*~*~*~*~");
        }
        else if (this.redGroupScore > this.blueGroupScore) {
            console.print("~*~*~*~*~*~*~*~*~*~");
            console.print("The red group won!");
            console.print("~*~*~*~*~*~*~*~*~*~");
        }
        else {
            console.print("~*~*~*~*~*~*~*~*~*~");
            console.print("It's a draw!");
            console.print("~*~*~*~*~*~*~*~*~*~");
        }
    }

    public void printSuddenDeath(String groupColor, UIbase console) {
        console.print("~*~*~*~*~*~*~*~*~*~");
        console.print("The " + groupColor + " group lost.");
        console.print("~*~*~*~*~*~*~*~*~*~");
    }
}
