public class Queue<T> {
    private Node first;
    private Node last;
    private int size;

    public Queue() {
        first = null;
        last = null;
        size = 0;
    }

    public void enqueue(T data){
        if(first == null){
            first = new Node(data, null);
            last = first;
        }else {
            Node node = new Node(data, null);
            last.next = node;
            last = node;
        }
        size++;
    }

    public T peek(){
        return first.elem;
    }
    public T dequeue(){
        Node previous = first;
        first = first.next;
        size--;
        return previous.elem;
    }

    private class Node{
        T elem;
        Node next;

        public Node(T elem, Node next) {
            this.elem = elem;
            this.next = next;
        }
    }

    public int getSize(){
        return size;
    }

    public boolean isEmpty(){
        return first == null;
    }
}
