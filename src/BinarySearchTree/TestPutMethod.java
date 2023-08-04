package BinarySearchTree;

public class TestPutMethod {
    public static void main(String[] args) {
        BSTree tree = new BSTree();

        tree.put(4, "4");
        tree.put(2, "2");
        tree.put(6, "6");
        tree.put(1, "1");
        tree.put(3, "3");
        tree.put(5, "5");
        tree.put(7, "7");

        tree.inOrderTraversal(tree.root);

    }
}
