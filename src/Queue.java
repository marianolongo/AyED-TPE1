public interface Queue<T> {

    void enqueue(T elem);
    void dequeue();
    int size();
    T peek();
    boolean isEmpty();
}
