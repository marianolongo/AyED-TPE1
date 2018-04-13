package Ej2;

public class Stack<T> {
    Node first;

    public Stack() {
        first = null;
    }

    void push(T element){
        if(element != null) {
            if (first == null) {
                first = new Node(element, null);
            } else {
                Node previous = first;
                first = new Node(element, previous);
            }
        }
    }
    T pop(){
        if(isEmpty()){
            throw new RuntimeException("Is Empty");
        }
        Node previous = first;
        first = first.next;
        return previous.elem;
    }
    T peek(){
        return first.elem;
    }
    boolean isEmpty(){
        return first == null;
    }

    private class Node{
        T elem;
        Node next;

        public Node(T elem, Node next) {
            this.elem = elem;
            this.next = next;
        }
    }
}
