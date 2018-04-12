public class InOrderIterator<T extends Comparable> implements Iterator<T> {

    private LinkedList<BinarySearchTree<T>> linkedStack = new LinkedList<>();
    private LinkedList<T> linkedQueue = new LinkedList<>();

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
        LinkedList<T> aux = linkedQueue;
        aux.dequeue();
        return aux.peek();
    }

    @Override
    public boolean hasNext() {
        return !linkedStack.isEmpty();
    }
}
