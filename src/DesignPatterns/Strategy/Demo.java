package DesignPatterns.Strategy;

// System Behavior partially specified at runtime.


// Motivation

// Many algorithms can be decomposed into higher-and lower level parts
// Making tea can be decomposed into
// -> The process of making a hot beverage (boil water, pour into cup); and
// -> Tea-specific things (put teabag into water)
// The high level algorithm can then be reused for making coffee or chocolate
// -> Supported by beverage-specific strategy


// Strategy patterns Enables the exact behavior of a system
// to be either at run-time (dynamic) or compile-time (static).

// Also known as policy (esp. in c++ world);


import java.util.List;
import java.util.function.Supplier;

enum OutputFormat {
    MARKDOWN,
    HTML,
}

interface ListStrategy {
    default void start(StringBuilder sb) {}
    void addListItem(StringBuilder sb, String item);
    default void end(StringBuilder sb) {}
}

class MarkdownListStrategy implements ListStrategy {
    @Override
    public void addListItem(StringBuilder sb, String item) {
        sb.append(" * ").append(item).append(System.lineSeparator());
    }
}

class HtmlListStrategy implements ListStrategy {
    @Override
    public void start(StringBuilder sb) {
        sb.append("<ul>").append(System.lineSeparator());
    }

    @Override
    public void addListItem(StringBuilder sb, String item) {
        sb.append("  <li>").append(item).append("</li>").append(System.lineSeparator());
    }
    @Override
    public void end(StringBuilder sb) {
        sb.append("</ul>").append(System.lineSeparator());
    }
}

// we could have make TextProcessor generic
// and use TextProcessor like this

// TextProcessor<LS extends ListStrategy>
// Ls listStrategy;
class TextProcessor<LS extends ListStrategy> {
    private StringBuilder sb = new StringBuilder();
    private LS listStrategy;
    // the below one is used when calling static Strategy method
//    private ListStrategy listStrategy;
//    public TextProcessor(OutputFormat format) {
//        setOutputFormat(format);
//    }
//    public void setOutputFormat(OutputFormat format) {
//        switch(format) {
//            case MARKDOWN:
//                listStrategy = new MarkdownListStrategy();
//                break;
//            case HTML:
//                listStrategy = new HtmlListStrategy();
//                break;
//        }
//    }

    public TextProcessor(Supplier<? extends LS> ctor) {
        listStrategy = ctor.get();
        System.out.println(ctor.get().getClass().getName());
    }
    public void appendList(List<String> items) {
        listStrategy.start(sb);
        for(String item: items) {
            listStrategy.addListItem(sb,item);
        }
        listStrategy.end(sb);
    }

    public void clear() {
        sb.setLength(0);
    }
    @Override
    public String toString() {
        return sb.toString();
    }

}
public class Demo {
    public static void main(String[] args) {
        // the below commented code is used when dynamix strategy is being implemented
//        TextProcessor processor = new TextProcessor(OutputFormat.MARKDOWN);
//        processor.appendList(List.of("liberte", "egalite", "fraternite"));
//
//        System.out.println(processor);
//
//        // this is to clear Markup output format which
//        processor.clear();
//
//        // that's why we made this method public so that it can be accessed from outside of the class
//        processor.setOutputFormat(OutputFormat.HTML);
//        processor.appendList(List.of("inheritance", "encapsulation," + "polymorphism"));
//        System.out.println(processor);

        TextProcessor<MarkdownListStrategy> tp = new TextProcessor<>(MarkdownListStrategy::new);
        tp.appendList(List.of("alpha", "gamma", "beta"));
        System.out.println(tp);

        TextProcessor<HtmlListStrategy> tpHtml = new TextProcessor<>(HtmlListStrategy::new);
        tpHtml.appendList(List.of("Polymorphism", "Inheritance", "Encapsulation"));
        System.out.println(tpHtml);
    }
}


// good example strategy is partially commanding the runtime behavior