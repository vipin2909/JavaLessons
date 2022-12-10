import org.junit.Assert;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;

class ExpressionProcessor {

    public Map<Character, Integer> variables = new HashMap<>();
    BiFunction<Integer, Integer, Integer> addition = Integer::sum;
    BiFunction<Integer, Integer, Integer> subtraction = (a, b) -> a - b;
    BiFunction<Integer, Integer, Integer> identity = (a, b) -> b;


    public int calculate(String expression) {
        int result = 0;
        BiFunction<Integer, Integer, Integer> operation = identity;
        for (Token token : lex(expression)) {
            switch (token.type) {
                case INTEGER: {
                    result = operation.apply(result, Integer.parseInt(token.value));
                    break;
                }
                case PLUS:
                    operation = addition;
                    break;
                case MINUS:
                    operation = subtraction;
                    break;
                case VARIABLE: {
                    if (token.value.length() > 1 || !variables.containsKey(token.value.charAt(0))) {
                        return 0;
                    }
                    result = operation.apply(result, variables.get(token.value.charAt(0)));
                    break;
                }
            }
        }
        return result;
    }

    private List<Token> lex(String input) {
        List<Token> tokens = new ArrayList<>();
        for (int i = 0; i < input.length(); i++) {
            switch (input.charAt(i)) {
                case '+':
                    tokens.add(new Token(Type.PLUS, "+"));
                    break;
                case '-':
                    tokens.add(new Token(Type.MINUS, "-"));
                    break;
                default:
                    boolean isDigit = Character.isDigit(input.charAt(i));
                    StringBuilder sb = new StringBuilder("" + input.charAt(i));
                    for (int j = i + 1; j < input.length(); j++) {
                        if (Character.isDigit(input.charAt(j)) == isDigit) {
                            sb.append(input.charAt(j));
                            i++;
                        } else {
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
        VARIABLE
    }

    static class Token {
        Type type;
        String value;

        public Token(Type type, String value) {
            this.type = type;
            this.value = value;
        }
    }

}

public class Exercise {
    public static void main(String[] args) {
        Assert.assertEquals(4, new ExpressionProcessor().calculate("1+2+4-3"));
        System.out.println(new ExpressionProcessor().calculate("1+2+4-3"));
    }

}