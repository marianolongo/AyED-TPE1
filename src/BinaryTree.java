public class BinaryTree<T> {
    DoubleNode<T> root;

    public BinaryTree(){
        root = null;
    }
    public BinaryTree(T o){
        root = new DoubleNode <T>(o);
    }
    public BinaryTree(T o, BinaryTree<T> tleft, BinaryTree<T> tright){
        root = new DoubleNode<T>(o,tleft.root, tright.root);
    }

    public void printLevelOrder(DoubleNode<T> root) {
        // Base Case
        if(root == null)
            return;

        // Create an empty queue for level order transversal
        LinkedList<DoubleNode> linkedList = new LinkedList<DoubleNode>();

        // Enqueue Root and initialize height
        linkedList.enqueue(root);

        while(true)
        {
            // nodeCount (queue size) indicates number of nodes
            // at current level.
            int nodeCount = linkedList.size();
            if(nodeCount == 0)
                break;

            // Dequeue all nodes of current level and Enqueue all
            // nodes of next level
            while(nodeCount > 0){
                DoubleNode<T> node = linkedList.peek();
                if(node.elem != null) {
                    System.out.println(node.elem);
                }

                linkedList.remove(node);
                if(node.left != null)
                    linkedList.enqueue(node.left);
                if(node.right != null)
                    linkedList.enqueue(node.right);
                nodeCount--;

            }
            System.out.println();
        }
    }

    public DoubleNode<T> getNode(){
        return root;
    }

}
