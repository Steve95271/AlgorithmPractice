package Exercise;

import DataStructure.BinaryTree.TreeNode;

public class LeetCode226_InvertBinaryTree {

    private void recursion(TreeNode root) {
        if (root == null) {
            return;
        }

        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        recursion(root.left);
        recursion(root.right);
    }

}
