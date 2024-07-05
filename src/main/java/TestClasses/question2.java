package TestClasses;

import java.util.List;

public class question2 {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    private List<Integer> recursion(TreeNode node) {
        if (node == null) return null;

        System.out.println(node.val);
        recursion(node.left);
        recursion(node.right);

        return null;
    }
}
