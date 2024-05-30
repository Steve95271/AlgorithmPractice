package DataStructure.BinarySearchTree;

public class TestBST1 {
    public static void main(String[] args) {
        BSTNode n1 = new BSTNode(1, "Alice");
        BSTNode n2 = new BSTNode(2, "Bob", n1, null);
        BSTNode n4 = new BSTNode(4, "David");
        BSTNode n3 = new BSTNode(3, "Cane", n2, n4);

        BSTNode n6 = new BSTNode(6, "Franco");
        BSTNode n7 = new BSTNode(7, "George", n6, null);
        BSTNode n9 = new BSTNode(9, "Ilsa");
        BSTNode n8 = new BSTNode(8, "Hysen", n7, n9);

        BSTNode root = new BSTNode(5, "Elise", n3, n8);

        BSTree tree = new BSTree();
        tree.root = root;

        System.out.println(tree.isValid(root));




    }
}
