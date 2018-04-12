public class LinkedList<T> implements Queue<T>,Stack<T>{
    private Node<T> first;
    private Node<T> last;
    private int size;

    public LinkedList() {
        first = null;
        last = null;
        size = 0;
    }

    private void addLast(T data) { //Agrega un elemento al final
        Node<T> n = new Node<>(data);
        if (isEmpty()) {
            n.next = first;
            first = n;
            last = n;
            size++;
        } else {
            last.next = n;
            last = n;
            last.next = null;
            size++;
        }
    }

    @Override
    public void enqueue(T elem) {
        addLast(elem);
    }

    @Override
    public void dequeue() { //Saca el primer elemento
        if (first.next == null) {
            last = null;
            size--;
        }
        first = first.next;
        size--;
    }

    @Override
    public int size() { //Devuelve el tamaño
        return size;
    }

    @Override
    public T peek() { //Devuelve sin remover el primer elemento
        return first.data;
    }

    public boolean isEmpty(){ //Se fija si la lista esta vacia
        return first == null;
    }

    public void remove(T elem){ //Saca el elemento de la lista
        Node<T> currentNode = first;
        Node<T> previousNode = null;
        while(currentNode != null){
            if(elem.equals(currentNode.data)){ //Encontro el elemento en la lista.
                if(previousNode  == null) {
                    first = currentNode.next;
                }
                else {
                    previousNode.next = currentNode.next;
                }
                size--;
            }
            else {
                previousNode = currentNode;
            }
            currentNode = currentNode.next;
        }
    }

    private class Node<T> {
        private T data;
        private Node<T> next;

        public Node(T data){
            this.data=data;
        }
    }

    @Override
    public void push(T element) {

    }

    @Override
    public T pop() {
        return null;
    }

}
