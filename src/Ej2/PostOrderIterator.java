package Ej2;

import Ej1.Queue;
import Ej2.BinarySearchTree;
import Ej2.Iterator;

public class PostOrderIterator<T extends Comparable> implements Iterator<T> {
    private Stack<BinarySearchTree<T>> linkedStack = new Stack<>();
    private Queue<T> linkedQueue = new Queue<>();

    public  PostOrderIterator(BinarySearchTree<T> binarySearchTree) {
        Stack<T> aux = new Stack<>();
        linkedStack.push(binarySearchTree);
        while (!linkedStack.isEmpty()) {
            BinarySearchTree<T> current = linkedStack.pop();
            aux.push(current.getRoot().elem);
            if (!current.getLeft().isEmpty()) {
                linkedStack.push(current.getLeft());
            }

            if (!current.getRight().isEmpty()) {
                linkedStack.push(current.getRight());
            }
        }

        while (!aux.isEmpty()) {
            linkedQueue.enqueue(aux.pop());
        }
    }
        @Override
        public T next() {
            return linkedQueue.dequeue();
        }

        @Override
        public boolean hasNext() {
            return !linkedQueue.isEmpty();
        }
}
