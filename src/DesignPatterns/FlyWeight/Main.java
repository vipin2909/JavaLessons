package DesignPatterns.FlyWeight;


import java.util.ArrayList;
import java.util.List;

class FormatText {
    private String plainText;
    private boolean[] capitalizeBool;

    public FormatText(String plainText) {
        this.plainText = plainText;
        capitalizeBool = new boolean[plainText.length()];
    }

    public void capitalize(int start, int end) {
        for(int i = start; i <= end; ++i) {
            capitalizeBool[i] = true;
        }
    }
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < plainText.length(); ++i) {
            char c = plainText.charAt(i);
            sb.append(capitalizeBool[i] ? Character.toUpperCase(c): c);

        }
        return sb.toString();
    }
}

class BetterFormattedText {

    private String plainText;
    private List<TextRange> formatting = new ArrayList<>();

    public BetterFormattedText(String plainText) {
        this.plainText = plainText;
    }

    public TextRange getRange(int start, int end) {
        TextRange range = new TextRange(start, end);
        formatting.add(range);
        return range;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < plainText.length(); ++i) {
            char c = plainText.charAt(i);
            for(TextRange range: formatting) {
                if(range.covers(i) && range.capitalize) {
                    c = Character.toUpperCase(c);
                }
            }
            sb.append(c);
        }
        return sb.toString();
    }
    public class TextRange {
        public int start, end;
        public boolean capitalize, bold, italic;

        public TextRange(int start, int end) {
            this.start = start;
            this.end = end;
        }

        public boolean covers(int position) {
            return position >= start && position <= end;
        }



    }
}
public class Main {
    public static void main(String[] args) {
        FormatText ft = new FormatText("This is a brave new world");
        ft.capitalize(10, 15);
        System.out.println(ft);

        BetterFormattedText bft = new BetterFormattedText("Make Americs Great Again");
        bft.getRange(13, 18).capitalize = true;
        System.out.println(bft);

    }
}