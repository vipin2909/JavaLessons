package DesignPatterns.Template;


// A high-level blueprint for an algorithm to be
// completed by inheritors

// Algorithms can be decomposed into common parts + specifics
// Strategy pattern does this through composition
// -> High-level algorithm uses an interface
// -> Concrete implementations implement the interface
// Template Method does have the same thing through inheritance
// -> Overall algorithm makes use of abstract Member
// -> Inheritors override the abstract members
// -> Parent template method invoked

// Template Method -> Allows us to define the skeleton of the algorithm
// with concrete implementations defined in subclass


// in strategy we use interface
// but in Template we use Abstract class
// and use Inheritance

abstract class Game {
    protected int currentPlayer;
    protected final int numberOfPlayers;

    public Game(int numberOfPlayers) {
        this.numberOfPlayers = numberOfPlayers;
    }

    public void run() {
        start();
        while (!haveWinner()) {
            takeTurn();

        }
        System.out.println("Player " + getWinningPlayer() + " wins");
    }

    protected abstract int getWinningPlayer();
    protected abstract void takeTurn();
    protected abstract boolean haveWinner();
    protected abstract void start();
}

class Chess extends Game {

    private int maxTurns = 10;
    private int turn = 1;

    public Chess(int numberOfPlayers) {
        super(numberOfPlayers);
    }
    @Override
    public int getWinningPlayer() {
        return currentPlayer;
    }
    @Override
    public void takeTurn() {
        System.out.println("Turn " + (turn++) + " taken by player " + currentPlayer);
        currentPlayer = (currentPlayer + 1) % numberOfPlayers;
    }
    @Override
    public boolean haveWinner() {
        return turn == maxTurns;
    }

    public void start() {
        System.out.println("Starting a game of chess");
    }

}
public class Main {
    public static void main(String[] args) {
        Chess chess = new Chess(2);
        chess.run();
    }
}
