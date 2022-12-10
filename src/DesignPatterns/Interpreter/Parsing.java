package DesignPatterns.Interpreter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;
import java.lang.Integer;

public class Parsing {
    public Map<Character, Integer> variables = new HashMap<>();
    BiFunction<Integer, Integer, Integer> addition = Integer::sum;
    BiFunction<Integer, Integer, Integer> subtraction = (a, b) -> a - b;
    BiFunction<Integer, Integer, Integer> identity = (a, b) -> b;

    private List<Token> lex(String expression) {
        List<Token> tokens = new ArrayList<>();
        for(int i = 0; i < expression.length(); i++) {
            switch(expression.charAt(i)) {
                case '+':
                    tokens.add(new Token(Type.PLUS, "+"));
                    break;
                case '-':
                    tokens.add(new Token(Type.MINUS, "-"));
                    break;
                default:
                    boolean isDigit = Character.isDigit(expression.charAt(i));
                    StringBuilder sb = new StringBuilder("" + expression.charAt(i));
                    for(int j = i+1; j < expression.length(); j++) {
                        if(Character.isDigit(expression.charAt(j)) == isDigit && expression.charAt(j) != '-' && expression.charAt(j) != '+') {
                            sb.append(expression.charAt(j));
                            i++;
                        }
                        else {
                            break;
                        }
                    }
                    tokens.add(new Token(isDigit ? Type.INTEGER : Type.VARIABLE, sb.toString()));
                    break;
            }
        }
        return tokens;
    }

    enum Type {
        INTEGER,
        PLUS,
        MINUS,
        VARIABLE,
    }

    static class Token {
        Type type;
        String text;
        public Token(Type type, String text) {
            this.type = type;
            this.text = text;
        }


    }
    public int calculate(String expression) {
        int result = 0;
        BiFunction<Integer, Integer, Integer> operation = identity;
        for(Token token: lex(expression)) {
            switch(token.type) {
                case INTEGER:
                    result = operation.apply(result, Integer.parseInt(token.text));
                    break;
                case PLUS:
                    operation = addition;
                    break;
                case MINUS:
                    operation = subtraction;
                    break;
                case VARIABLE:
                    if(token.text.length() > 1 || !variables.containsKey(token.text.charAt(0))) {
                        return 0;
                    }
                    result = operation.apply(result, variables.get(token.text.charAt(0)));
                    break;
            }



        }
        return result;
    }

    public static void main(String[] args) {
        Parsing parsing = new Parsing();
        parsing.variables.put('x', 20);
        String expression = "1-2+x-9";
        System.out.println("The value of the expression is\t" + parsing.calculate(expression));
//        for(Token token : parsing.lex(expression)) {
//            System.out.print(token.text+" ");
//        }
    }

}