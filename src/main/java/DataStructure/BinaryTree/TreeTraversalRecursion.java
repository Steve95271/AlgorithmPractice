package DataStructure.BinaryTree;

public class TreeTraversalRecursion {
    public static void main(String[] args) {
        /*     1
         *    / \
         *   2   3
         *  /   / \
         * 4   5   6   */

        TreeNode root = new TreeNode(
                new TreeNode(new TreeNode(4), 2, null),
                1,
                new TreeNode(new TreeNode(5), 3, new TreeNode(6))
        );

        System.out.println("----Pre Order----");
        preOrder(root);
        System.out.println("\n----In order----");
        inOrder(root);
        System.out.println("\n----Post order----");
        postOrder(root);
    }



    static void preOrder(TreeNode node){
        if (node == null) return;
        System.out.print(node.val + " ");
        preOrder(node.left);
        preOrder(node.right);
    }

    static void inOrder(TreeNode node){
        if (node == null) return;
        inOrder(node.left);
        System.out.print(node.val + " ");
        inOrder(node.right);
    }

    static void postOrder(TreeNode node){
        if (node == null) return;
        postOrder(node.left);
        postOrder(node.right);
        System.out.print(node.val + " ");
    }
}
