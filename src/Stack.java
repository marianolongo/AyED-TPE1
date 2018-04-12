public class Stack<T> {
    Node first;

    public Stack() {
        first = null;
    }

    void push(T element){
        Node previous = first;
        first = new Node(element, previous);
    }
    T pop(){
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

    public static void main(String[] args) {
        Stack stack = new Stack();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.println("dsadsa");
    }
}
