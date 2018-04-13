package Ej2;

import Ej1.Queue;

public class InOrderIterator<T extends Comparable> implements Iterator<T> {

    private Stack<BinarySearchTree<T>> linkedStack = new Stack<>();
    private Queue<T> linkedQueue = new Queue<>();

    public InOrderIterator(BinarySearchTree<T> binarySearchTree) {
        while (!(linkedStack.isEmpty()) || !(binarySearchTree.isEmpty())){
            if(!(binarySearchTree.isEmpty())){
                linkedStack.push(binarySearchTree);
                binarySearchTree = binarySearchTree.getLeft();
            }else{
                binarySearchTree = linkedStack.pop();
                linkedQueue.enqueue(binarySearchTree.getRoot().elem);
                binarySearchTree = binarySearchTree.getRight();
            }
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
