package Ej3;

public class Heap<T>{
    Node<T>[] elements = new Node[20];
    int index;

    void enqueue(T elem,double priority){
       if (elements[0] == null){
           elements[0] = new Node(elem, priority, null);
           index++;
            return;
       }if (elements.length == index){
           elements = newArray(elements);
       }if (index<elements.length){
            elements[index] = new Node<>(elem,priority,elements[(index-1)/2]);
            upCompare(elements[index]);
            index++;
            return;
       }

    }

    T dequeue(){
       T aux = (T)elements[0];
       swap(elements[0],elements[index - 1]);
       elements[index-1] = null;
       downCompare(elements[0],0);
       return aux;
    }

    private void downCompare(Node<T> element, int newIndex) {
        int left = index*2 + 1;
        int right = index*2 + 2;

        if ((elements[right] != null) && (elements[left] != null)){
            if (elements[right].priority < elements[left].priority){
                if (elements[right].priority < element.priority){
                    swap(elements[right],element);
                    downCompare(elements[right], right);
                }
            }
            if (elements[left].priority<element.priority){
                swap(elements[left],element);
                downCompare(elements[left], left);
            }

        }
        else if (elements[left] != null){
            if (elements[left].priority<element.priority) {
                swap(elements[left], element);
                downCompare(elements[left], left);
            }

        }

    }

    private void upCompare(Node<T> element) {
        if (element.priority < element.father.priority){
            swap(element,element.father);
            upCompare(element.father);
        }

    }


    private void swap(Node<T> element, Node father) {
        T elementAux = (T)father.elem;
        double priorityAux = father.priority;

        element.father.elem = element.elem;
        element.father.priority = element.priority;
        element.priority = priorityAux;
        element.elem = elementAux;

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
        Node father, left, right;

        public Node(T elem, double priority, Node father) {
            this.elem = elem;
            this.priority = priority;
            this.father = father;
        }
    }
}
