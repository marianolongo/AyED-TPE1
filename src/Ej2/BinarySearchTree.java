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
        Stack<DoubleNode<T>> stack = new Stack<>();
        stack.push(root);
        return new Iterator<T>(){
            @Override
            public T next() {
                if(!hasNext()){
                    throw new RuntimeException("Next not available");
                }
                DoubleNode<T> node = stack.pop();
                stack.push(node.right);
                stack.push(node.left);
                return node.elem;
            }

            @Override
            public boolean hasNext() {
                return !stack.isEmpty();
            }
        };
    }

    public Iterator<T> inOrder(){
        Stack<DoubleNode<T>> stack = new Stack<>();

        return new Iterator<T>() {
            DoubleNode<T> current = root;
            @Override
            public T next() {
                if(!hasNext()){
                    throw new RuntimeException("Next not available");
                }
                while(current != null){
                    stack.push(current);
                    current = current.left;
                }
                DoubleNode<T> previous = stack.pop();
                current = previous.right;
                return previous.elem;
            }

            @Override
            public boolean hasNext() {
                return !stack.isEmpty() && current != null;
            }
        };
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
