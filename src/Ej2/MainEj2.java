package Ej2;

public class MainEj2 {

    public static void main(String[] args) {
        BinarySearchTree<Integer> myTree = new BinarySearchTree<>();
        myTree.insert(1);
        myTree.insert(3);
        myTree.insert(5);
        myTree.insert(2);
        myTree.insert(4);
        myTree.insert(6);
        System.out.println("PreOrder");
        System.out.println();
        Iterator preOrder = myTree.preOrder();
        while(preOrder.hasNext()){
            System.out.println(preOrder.next());
        }
        System.out.println();
        System.out.println("InOrder");
        System.out.println();

        Iterator inOrder = myTree.inOrder();
        while(inOrder.hasNext()){
            System.out.println(inOrder.next());
        }

        System.out.println();
        System.out.println("PostOrder");
        System.out.println();

        Iterator postOrder = myTree.postOrder();
        while(postOrder.hasNext()){
            System.out.println(postOrder.next());
        }
    }
}
