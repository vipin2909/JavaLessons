package DesignPatterns.Momento;


// Mementos are used to roll back states
// A Memento is simply a token/handle class with (typically) no functions of its own
// A Memento is not required to expose directly the state(s) to which it reverts the system
// can be used to implement undo/redo
import java.util.ArrayList;
import java.util.List;

class Token {
    public int value = 0;
    public Token(int value) {
        this.value = value;
    }
}

class Memento1 {
    public List<Token> tokens = new ArrayList<>();
}

// example TokenMachine one.addToken(10);
// TokenMachine one.addToken(20);
// Memento (one->30);

// TokenMachine two -> addToken(50);
// Memento.add.tokens(two(value=50));
class TokenMachine {
    public List<Token> tokens = new ArrayList<>();
    public Memento1 addToken(int value) {
        tokens.add(new Token(value));
        return snapshot();
    }
    public Memento1 addToken(Token token) {
       tokens.add(token);
       return snapshot();
    }

    public void revert(Memento1 m) {
        this.tokens = m.tokens;
    }

    public Memento1 snapshot() {
        Memento1 memento = new Memento1();
        tokens.forEach(t -> memento.tokens.add(new Token(t.value)));
        return memento;
    }
}
public class Exercise {


    public static void main(String[] args) {
        TokenMachine tokenMachine = new TokenMachine();
        Token one = new Token(10);
        Token two = new Token(20);
        Token three = new Token(30);

        tokenMachine.addToken(one);
        tokenMachine.addToken(two);
        tokenMachine.addToken(three);

        tokenMachine.addToken(1);
        tokenMachine.addToken(2);
        tokenMachine.addToken(3);

        for (Token token : tokenMachine.tokens) {
            System.out.print(token.value+"\t");
        }
        System.out.println("\n"+tokenMachine.tokens.size());
    }

}