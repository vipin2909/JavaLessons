package DesignPatterns.composite;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Spliterator;
import java.util.function.Consumer;


// composite design pattern means similar behavior for single
// and composite objects means single and composition of objects
// behaves in an uniform manner

interface SomeNeurons extends Iterable<Neuron> {
    default void connectTo(SomeNeurons other) {
        if(this == other) {
            return;
        }
        for(Neuron from: this) {
            for(Neuron to: other) {
                from.out.add(to);
                to.in.add(from);
            }
        }
    }
}
class Neuron implements SomeNeurons {
    public ArrayList<Neuron> in = new ArrayList<>(), out = new ArrayList<>();

    @Override
    public Spliterator<Neuron> spliterator() {
        return Collections.singleton(this).spliterator();
    }
    public Iterator<Neuron> iterator() {
        return Collections.singleton(this).iterator();
    }
    @Override
    public void forEach(Consumer<? super Neuron> action) {
        action.accept(this);
    }

//    static int count = 0;

//    public void connectTo(Neuron other) {
//        out.add(other);
//        other.in.add(this);
//    }
//
//    @Override
//    public String toString() {
//        return "THIS IS NEURON ONE " + (count++);
//    }
}

class NeuronLayer extends ArrayList<Neuron> implements SomeNeurons {

}
public class Demo {
    public static void main(String[] args) {
        Neuron neuron = new Neuron();
        Neuron neuron2 = new Neuron();

        NeuronLayer neuronLayer = new NeuronLayer();
        NeuronLayer neuronLayer2 = new NeuronLayer();

        neuron.connectTo(neuron2);
        neuron.connectTo(neuronLayer);
        neuronLayer.connectTo(neuron);
        neuronLayer.connectTo(neuronLayer2);


//        System.out.println(neuron.out.get(0).hashCode());
//        System.out.println(neuron2.in.get(0).out.get(0).in.get(0).out.get(0).in.get(0).out.get(0).hashCode());
//        System.out.println(neuron.out);
    }
}