package Ej2;

import Ej1.DoubleNode;

public class BinarySearchTree<T extends Comparable> {
    private DoubleNode<T> root;

    public BinarySearchTree() {
        root = null;
    }


    public void insert(T x) {
        root = insert(root, x);
    }

    private DoubleNode<T> insert(DoubleNode<T> node, T elemToInsert) {
        if (node == null) {
            node = new DoubleNode<T>(null);
            node.elem = elemToInsert;
        } else if (elemToInsert.compareTo(node.elem) < 0)
            node.left = insert(node.left, elemToInsert);
        else
            node.right = insert(node.right, elemToInsert);
        return node;
    }

    public boolean isEmpty() {
        return root == null;
    }

    public Iterator<T> preOrder() {
        return new PreOrderIterator<T>(this);
    }

    public Iterator<T> inOrder(){
        return new InOrderIterator<T>(this);
    }

    public Iterator<T> postOrder(){
        return new PostOrderIterator<T>(this);
    }

    public DoubleNode<T> getRoot() {
        return root;
    }

    public BinarySearchTree<T> getLeft() {
        BinarySearchTree<T> t = new BinarySearchTree<>();
        t.root = root.left;
        return t;
    }

    public BinarySearchTree<T> getRight() {
        BinarySearchTree<T> t = new BinarySearchTree<>();
        t.root = root.right;
        return t;
    }
}
