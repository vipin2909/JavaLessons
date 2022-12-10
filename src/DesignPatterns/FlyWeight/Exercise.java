package DesignPatterns.FlyWeight;


import java.util.ArrayList;
import java.util.List;

// try to play with code first and then start to write notes about it
class Sentence {
    private String plainText;
    private List<WordToken> wordTokenList = new ArrayList<>();
    public Sentence(String plainText) {
        this.plainText = plainText;
    }
    public WordToken getWord(int index) {
       WordToken wordToken = new WordToken(index);
       wordTokenList.add(wordToken);
       return wordToken;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        int count = 0;
        for(String arr: plainText.split(" ")) {
            String str = arr;
            for(WordToken token: wordTokenList) {
                if(token.covers(count) && token.capitalize) {
                    str = arr.toUpperCase();
                }
            }
            count+=1;
            sb.append(str);
            sb.append(" ");
        }
        return sb.toString().trim();
    }

    public class WordToken {
        public boolean capitalize;

        public int index;
        public WordToken(int index) {
            this.index = index;
        }
        public boolean covers(int index) {
            return this.index == index;
        }
    }


}
public class Exercise {
    public static void main(String[] args) {
        var sentence = new Sentence("hello world");
        sentence.getWord(1).capitalize = true;
        System.out.println(sentence);
    }
}
