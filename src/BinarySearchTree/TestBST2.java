package BinarySearchTree;

public class TestBST2 {
    public static void main(String[] args) {
        BSTree2.BSTNode<Integer> n1 = new BSTree2.BSTNode<Integer>(1, "Alice");
        BSTree2.BSTNode<Integer> n2 = new BSTree2.BSTNode<Integer>(2, "Bob", n1, null);
        BSTree2.BSTNode<Integer> n4 = new BSTree2.BSTNode<Integer>(4, "David");
        BSTree2.BSTNode<Integer> n3 = new BSTree2.BSTNode<Integer>(3, "Cane", n2, n4);
        BSTree2.BSTNode<Integer> n6 = new BSTree2.BSTNode<Integer>(6, "Franco");
        BSTree2.BSTNode<Integer> n7 = new BSTree2.BSTNode<Integer>(7, "George", n6, null);
        BSTree2.BSTNode<Integer> n9 = new BSTree2.BSTNode<Integer>(9, "Ilsa");
        BSTree2.BSTNode<Integer> n8 = new BSTree2.BSTNode<Integer>(8, "Hysen", n7, n9);
        BSTree2.BSTNode<Integer> root = new BSTree2.BSTNode<Integer>(5, "Elise", n3, n8);

        BSTree2 tree = new BSTree2();
        tree.root = root;

        Object result = tree.get(3);

        System.out.println(result);


    }
}
