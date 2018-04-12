public class PreOrderIterator<T extends Comparable> implements Iterator<T>{
    private LinkedList<BinarySearchTree<T>> linkedStack = new LinkedList<>();
    private LinkedList<T> linkedQueue = new LinkedList<>();


    public PreOrderIterator(BinarySearchTree<T> binaryTree) {
        linkedStack.push(binaryTree);
        while (!linkedStack.isEmpty()){
            BinarySearchTree<T> binarySearchTree = linkedStack.pop();
            linkedQueue.enqueue(binarySearchTree.getRoot().elem);
            if(!binarySearchTree.getRight().isEmpty()){
                linkedStack.push(binarySearchTree.getRight());
            }
            if(!binarySearchTree.getLeft().isEmpty()){
                linkedStack.push(binarySearchTree.getLeft());
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
