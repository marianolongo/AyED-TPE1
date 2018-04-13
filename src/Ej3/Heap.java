package Ej3;

public class Heap<T extends Comparable>{
    private HeapNode root;

    public Heap() {
        root = null;
    }

    public void enqueue(T elem, double priority){
        if(isEmpty()){
            root.elem = elem;
        }

    }

    public T dequeue(){
        T aux = root.elem;
        if(isEmpty()){
            return null;
        }
        if(root.left.elem == null || root.right.elem == null){
            return root.elem;
        }
        if(root.left.compareNode(root.right)> 0){
            swapLeft(root.left);
        }else {
            swapRight(root.right);
        }
        return aux;
}

    private void swapRight(HeapNode right) {
        HeapNode aux = right.father;
        right.father = right;
        root.right = aux;
    }

    private void swapLeft(HeapNode left) {
        HeapNode aux = left.father;
        left.father = left;
        root.left = aux;
    }

    public boolean isEmpty(){
        return root == null;
    }

    private class HeapNode{
        private T elem;
        private HeapNode left, right, father;
        private int nodePriority;

        public HeapNode(T elem, HeapNode left, HeapNode right, HeapNode father, int priority) {
            this.elem = elem;
            this.left = left;
            this.right = right;
            this.father = father;
            this.nodePriority = priority;
        }

        public int compareNode(HeapNode nodeToCompare){ //Compara los nodos, si este nodo tiene mayor probabilidad, entonces el resultado es > 0
            return nodeToCompare.nodePriority - this.nodePriority;
        }
    }
}
