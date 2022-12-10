package DesignPatterns.Interpreter;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

interface Element1 {
    public int eval();
}

class Integer1 implements Element1 {
    public int value;
    public Integer1(int value) {
        this.value = value;
    }

    @Override
    public int eval() {
        return value;
    }
}


class BinaryOperation1 implements Element1 {
    enum Type {
        ADDITION,
        SUBTRACTION
    }

    public Type type;
    // element can be both BinaryOperation or Integer
    public Element1 left, right;
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
class ExpressionHolder {

    static Map<Character, String> variables = new HashMap<>();


    public enum Type {
        PLUS,
        MINUS,
        INTEGER,
        VARIABLE,
    }

    static class Token1 {
        Type type;
        String text;

        public Token1(Type type, String text) {
            this.type = type;
            this.text = text;
        }

        @Override
        public String toString() {
            return text;
        }
    }


    /* This function returns the tokens which are different symbols and operations along with integral value present in the expression String */
    public static List<Token1> lexing(String expression) {
        List<Token1> tokens = new ArrayList<>();
        for(int i = 0; i < expression.length(); i++) {
            switch(expression.charAt(i)) {
                case '+':
                    tokens.add(new Token1(Type.PLUS, "+"));
                    break;
                case '-':
                    tokens.add(new Token1(Type.MINUS, "-"));
                    break;
                default:
                    boolean isDigit = Character.isDigit(expression.charAt(i));
                    StringBuilder sb = new StringBuilder(""+expression.charAt(i));
                    for(int j = i+1; j < expression.length(); j++) {
                        if(Character.isDigit(expression.charAt(j)) == isDigit && expression.charAt(j) != '+' && expression.charAt(j) != '-') {
                            sb.append(expression.charAt(j));
                            i++;
                        }
                        else {
                            break;
                        }
                    }
                    tokens.add(new Token1(isDigit ? Type.INTEGER : Type.VARIABLE, sb.toString()));
                    break;
            }
        }
        return tokens;
    }

    public static Element1 parsing(String expression) {
        // in this case we have to do check for next operation instead of rightParenthesis as we have done in previous tutorial
        BinaryOperation1 binaryOperation = new BinaryOperation1();
        boolean haveLHS = false;
        boolean haveOccured = false;
        for(Token1 token: lexing(expression)) {
            switch(token.type) {
                case INTEGER:
                    Integer1 integer = new Integer1(java.lang.Integer.parseInt(token.text));
                    if(!haveLHS) {
                        binaryOperation.left = integer;
                        haveLHS = true;
                    }
                    else {
                        binaryOperation.right = integer;
                    }
                    break;

                case PLUS:
                    if(haveOccured) {
                        binaryOperation.left = new Integer1(binaryOperation.eval());
                        binaryOperation.type = BinaryOperation1.Type.ADDITION;
                    }
                    else {
                        binaryOperation.type = BinaryOperation1.Type.ADDITION;
                        haveOccured = true;
                    }

                    break;
                case MINUS:
                    if(haveOccured) {
                        binaryOperation.left = new Integer1(binaryOperation.eval());
                        binaryOperation.type = BinaryOperation1.Type.SUBTRACTION;
                    }
                    else {
                        binaryOperation.type = BinaryOperation1.Type.SUBTRACTION;
                        haveOccured = true;
                    }
                    break;
                case VARIABLE:
                    if(token.text.length() > 1 || !variables.containsKey(token.text.charAt(0))) {
                        return new Integer1(0);
                    }
                    if(!haveLHS) {
                        binaryOperation.left = new Integer1(java.lang.Integer.parseInt(variables.get(token.text.charAt(0))));
                        haveLHS = true;
                    }
                    else {
                        binaryOperation.right = new Integer1(java.lang.Integer.parseInt(variables.get(token.text.charAt(0))));
                    }

            }
        }
        return binaryOperation;
    }
}
public class Main {
    public static void main(String[] args) {
        ExpressionHolder.variables.put('x', "3");
         List<ExpressionHolder.Token1> list = new ExpressionHolder().lexing("1+2+3+x-4+21");
         System.out.println(list.stream().map(t -> t.toString()).collect(Collectors.joining("\t")));

         Element1 parsed = ExpressionHolder.parsing("1+2+3+x-4+21");
        System.out.println("1+2+3+x+45+21" + " = " + parsed.eval());
    }
}