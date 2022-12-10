package DesignPatterns.Interpreter;


// Textual input needs to be processed
// E.g turned into OOP structure

// Some Examples
// Programming language compilers, interpreters and IDEs
// HTML, XML and similar
// Numeric expression (3+4/5)
// Regular expression

// Turning Strings into OOP based structures in a
// complicated process

// Main Definition -> A Component that process structured text data.
// Does so by turning it into separate lexical tokens (Lexing) and then interpreting sequences
// of said tokens (parsing)


// Lexical Analyzer -> it is so called scanner. it takes the output of the
// preprocessor (which performs file inclusion and macro expansion)
//

/*
Syntax Analyzer -> it sometimes called parser. it constructs the parse tree
it takes all the tokens one by one and uses Context-Free Grammer to construct the parse tree


Semantic Analyzer -> it verifies parse tree, whether it is meaningful or not. it
further produces verified parse tree. it also does type checking, label checking,
and flow control checking
 */


import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


interface Element {
    int eval();
}

class Integer implements Element {
    private int value;

    public Integer(int value) {
        this.value = value;
    }
    @Override
    public int eval() {
        return value;
    }
}

class BinaryOperation implements Element {
    public enum Type {
        ADDITION,
        SUBTRACTION
    }
    public Type type;
    // element can be both binary operation or just a simple integer
    // and these calls could be possibly recursive
    public Element left, right;

    @Override
    public int eval() {
        switch(type) {
            case ADDITION:
                return left.eval() + right.eval();
            case SUBTRACTION:
                return left.eval() - right.eval();
            default:
                return 0;
        }
    }
}
class Token {
    public enum Type {
        INTEGER,
        PLUS,
        MINUS,
        LPAREN,
        RPAREN
    }

    public Type type;
    public String text;

    public Token(Type type, String text) {
        this.type = type;
        this.text = text;
    }
    @Override
    public String toString() {
        return "`" + text + "`";
    }

}
public class Lexing {
    static List<Token> lex(String input) {
        ArrayList<Token> result = new ArrayList<Token>();
        for(int i = 0; i < input.length(); i++) {
            switch(input.charAt(i)) {
                case '+':
                    result.add(new Token(Token.Type.PLUS, "+"));
                    break;
                case '-':
                    result.add(new Token(Token.Type.MINUS, "-"));
                    break;
                case '(':
                    result.add(new Token(Token.Type.LPAREN, "("));
                    break;
                case ')':
                    result.add(new Token(Token.Type.RPAREN, ")"));
                    break;
                default:
                    StringBuilder sb = new StringBuilder("" + input.charAt(i));
                    for(int j = i+1; j < input.length(); ++j) {
                        if(Character.isDigit(input.charAt(j))) {
                            sb.append(input.charAt(j));
                            ++i;
                        }
                        else {
                            result.add(new Token(Token.Type.INTEGER, sb.toString()));
                            break;
                        }
                    }
                    break;


            }
        }

        return result;

    }

    static Element parse(List<Token> tokens) {
        BinaryOperation result = new BinaryOperation();
        boolean haveLHS = false;
        for(int i = 0; i < tokens.size(); i++) {
            Token token = tokens.get(i);
            switch(token.type) {
                case INTEGER:
                    Integer integer = new Integer(java.lang.Integer.parseInt(token.text));
                    if(!haveLHS) {
                        result.left = integer;
                        haveLHS = true;
                    }
                    else {
                        result.right = integer;
                    }
                    break;
                case PLUS:
                    result.type = BinaryOperation.Type.ADDITION;
                    break;
                case MINUS:
                    result.type = BinaryOperation.Type.SUBTRACTION;
                    break;
                case LPAREN:
                    int j = 0; // location of right parenthesis
                    for(; j < tokens.size(); ++j) {
                        if (tokens.get(j).type == Token.Type.RPAREN) {
                            break;
                        }
                    }
                    List<Token> subexpression = tokens.stream().skip(i+1).limit(j-i-1).collect(Collectors.toList());
                    Element element = parse(subexpression);
                    if(!haveLHS) {
                        result.left = element;
                        haveLHS = true;
                    }
                    else {
                        result.right = element;
                    }
                    i = j;
                    break;
            }
        }
        return result;
    }
    public static void main(String[] args) {
        String input = "(13+4)-(12+1)";
        List<Token> tokens = lex(input);
        // List => "(" "13"

        System.out.println(tokens.stream().map(t -> t.toString()).collect(Collectors.joining("\t")));
        Element parsed = parse(tokens);
        System.out.println(input + " = " + parsed.eval());

    }
}