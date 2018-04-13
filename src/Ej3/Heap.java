package Ej3;

public class Heap<T>{
    Node<T>[] elements = new Node[10];
    int index;

    public Heap() {
        index = 0;
    }

    void enqueue(T elem, double priority){
       if (elements[0] == null){
           elements[0] = new Node<>(elem, priority, null);
           index++;
            return;
       }if (elements.length == index){
           elements = newArray(elements);
       }if (index<elements.length){
            elements[index] = new Node<>(elem,priority,elements[(index-1)/2]);
            upCompare(elements[index]);
            index++;
       }

    }

    T dequeue(){
        if(elements[0] == null){
            throw new RuntimeException("Heap is empty");
        }
       T aux = elements[0].elem;
       Node<T> last = elements[index - 1];
       Node<T> elem = elements[0];
       swap(elem,last);
       elements[index - 1] = null;
       downCompare(elements[0],0);
       index--;
       return aux;
    }

    private void downCompare(Node<T> element, int newIndex) {
        int left = index * 2 + 1;
        int right = index *2 + 2;

        if ((left < elements.length && elements[right] != null) && ( right < elements.length && elements[left] != null)){
            if (elements[left].priority > elements[right].priority){
                if (elements[right].priority < element.priority){
                    swap(element,elements[right]);
                    downCompare(elements[right], right);
                }
            }
            if (elements[left].priority < element.priority){
                swap(element,elements[left]);
                downCompare(elements[left], left);
            }

        }
        else if (left < elements.length && elements[left] != null){
            if (elements[left].priority<element.priority) {
                swap(elements[left], element);
                downCompare(elements[left], left);
            }

        }
    }

    private void upCompare(Node<T> element) {
        if(element.father == null)
            return;
        if (element.priority < element.father.priority){
            swap(element,element.father);
            upCompare(element.father);
        }

    }


    private void swap(Node<T> element, Node<T> father) {
        double elementPriority  = element.priority;
        T elementValue = element.elem;

        element.elem = father.elem;
        element.priority = father.priority;
        father.priority = elementPriority;
        father.elem = elementValue;
    }


    private Node<T>[] newArray(Node<T>[] elements) {
        Node<T>[] newElements = new Node[elements.length*2];
        for (int i = 0; i <elements.length ; i++) {
            newElements[i] = elements[i];
        }
        return newElements;
    }

    private class Node<T>{
        T elem;
        double priority;
        Node<T> father;

        public Node(T elem, double priority, Node<T> father) {
            this.elem = elem;
            this.priority = priority;
            this.father = father;
        }
        @Override
        public String toString() {
            return "[ "+ elem + " ]";
        }
    }
}
