package DesignPatterns.Iterator;

// How Traversal of data structures happens and who makes it happen

//Motivation Iteration (traversal) is a core functionality of various data structures
// An Iterator is a class that facilitates the traversal
 // -> // keeps a reference to the current element
 // -> // knows how to move to a different element

// Java has Itertor<T> and Iterable<T>
// -> // Iterator<T> specifies the iterator API
// -> // A class needs to be Iterable in order to support for(Foo foo: List<Foo>) loops


// An Iterator is simply an object that facilitates the traversal of a data structure


import java.util.Iterator;
import java.util.Spliterator;
import java.util.function.Consumer;

class Node<T>
{
    public T value;
    public Node<T> left, right, parent;

    public Node(T value) {
        this.value = value;
    }

    public Node(T value, Node<T> left, Node<T> right) {
        this.value = value;
        this.left = left;
        this.right = right;
        left.parent = right.parent = this;
    }
}


class InOrderIterator<T> implements Iterator<T> {

    private Node<T> current, root;
    private boolean yieldedStart;

    public InOrderIterator(Node<T> root) {
        this.root = current = root;
        while(current.left != null) {
            current = current.left;
        }
    }


    private boolean hasRightMostParent(Node<T> node) {
        if(node.parent == null) return false; // this one is case for root node
        else {
            return (node == node.parent.left) || hasRightMostParent(node.parent);
        }
    }
    // current = new Node(10);
    // 10 = 10.parent.left == true // has the rightMostParen

    @Override
    public boolean hasNext() {
        return current.left != null || current.right != null || hasRightMostParent(current);
    }

    @Override
    public T next() {
        if(!yieldedStart) {
            yieldedStart = true;
            return current.value;
        }
        if(current.right != null) {
            current = current.right;
            while(current.left != null) {
                current = current.left;
            }
            return current.value;
        }
        else {
            Node<T> p = current.parent;
            while(p != null && current == p.right) {
                current = p;
                p = p.parent;
            }
            current = p;
            return current.value;
        }
    }
}

class BinaryTree<T> implements Iterable<T> {

    private Node<T> root;
    public BinaryTree(Node<T> root) {
        this.root = root;
    }

    @Override
    public Iterator<T> iterator() {
        return new InOrderIterator<>(root);
    }

    @Override
    public void forEach(Consumer<? super T> action) {
        for(T item: this)
            action.accept(item);
    }

    @Override
    public Spliterator<T> spliterator() {
        return Iterable.super.spliterator();
    }
}
public class TreeTraversal {
    public static void main(String[] args) {
        //     1
        //    / \
        //   2   3

        // 213

        Node<Integer> root = new Node<>(15, new Node<>(10), new Node<>(20));
//        root.left = new Node<>(10, new Node<>(8), new Node<>(12));
//        root.left.left = new Node<>(8);
//        root.left.right = new Node<>(12);
//        root.right.left = new Node<>(16);
//        root.right.right = new Node<>(24);
//
//        root.right = new Node<>(20, new Node<>(16), new Node<>(24));
        InOrderIterator<Integer> itr = new InOrderIterator<>(root);


//        System.out.println(root.left.value);

        System.out.println(itr.hasNext());
        while(itr.hasNext()) {
            System.out.print(""+itr.next()+",");
        }
        System.out.println();

        BinaryTree<Integer> tree = new BinaryTree<>(root);
        for(int n: tree) {
            System.out.print("" + n + ",");
        }
        System.out.println();
    }
}
