public interface PriorityQueue<T> {
    void enqueue(T elem, double priority);
    T dequeue(T elem);
}