public class PreOrderIterator<T extends Comparable> implements Iterator<T>{
    private Stack<BinarySearchTree<T>> linkedStack = new Stack<>();
    private Queue<T> linkedQueue = new Queue<>();


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
        return linkedQueue.dequeue();
    }

    @Override
    public boolean hasNext() {
        return !linkedQueue.isEmpty();
    }
}
