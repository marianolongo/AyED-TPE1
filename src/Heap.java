public class Heap<T> extends BinaryTree<T> implements PriorityQueue<T>{
    DoubleNode<T> father;
    public Heap() {
        root = null;
    }

    public Heap(T o) {
        super(o);
    }

    public Heap(T o, BinaryTree<T> tleft, BinaryTree<T> tright) {
        super(o, tleft, tright);
    }
     public void enqueue(T elem, double priority){

    }

    public T dequeue(T elem){
        return null;
    }
}
