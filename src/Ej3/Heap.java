package Ej3;

public class Heap<T>{
    Object[] elements = new Object[20];

    void enqueue(T elem,double priority){

    }

    private class Node{
        T elem;
        double priority;

        public Node(T elem, double priority) {
            this.elem = elem;
            this.priority = priority;
        }
    }
}
