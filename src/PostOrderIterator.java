public class PostOrderIterator<T extends Comparable> implements Iterator<T> {
    private LinkedList<BinarySearchTree<T>> linkedStack = new LinkedList<>();
    private LinkedList<T> linkedQueue = new LinkedList<>();

    public  PostOrderIterator(BinarySearchTree<T> binarySearchTree) {
        LinkedList<T> aux = new LinkedList<>();
        linkedStack.push(binarySearchTree);
        while (!linkedStack.isEmpty()) {
            BinarySearchTree<T> current = linkedStack.pop();
            aux.push(current.getRoot().elem);

            if (current.getLeft().isEmpty() == false) {
                linkedStack.push(current.getLeft());
            }

            if (current.getRight().isEmpty() == false) {
                linkedStack.push(current.getRight());
            }
        }

        while (aux.isEmpty() == false) {
            linkedQueue.enqueue(aux.pop());
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
