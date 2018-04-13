package Ej1;

public class DoubleNode<T>{
    public T elem;
    public DoubleNode <T> right, left;
    public DoubleNode(T o){
        elem = o;
    }

    public DoubleNode(T o, DoubleNode<T> left, DoubleNode<T> right){
        elem = o;
        this.right = right;
        this.left = left;
    }
    public DoubleNode(T elem, DoubleNode<T> right, DoubleNode<T> left, DoubleNode<T> father) {
        this.elem = elem;
        this.right = right;
        this.left = left;
    }
}
