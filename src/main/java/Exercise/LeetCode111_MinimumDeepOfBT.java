package Exercise;

import DataStructure.BinaryTree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class LeetCode111_MinimumDeepOfBT {

    private int recursion(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftDeep = recursion(root.left);
        int rightDeep = recursion(root.right);

        if (leftDeep == 0) {
            return rightDeep + 1;
        }
        if (rightDeep == 0) {
            return leftDeep + 1;
        }

        return Integer.min(leftDeep, rightDeep) + 1;
    }

    private int levelOrderSolution(TreeNode root) {
        if (root == null) {
            return 0;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int level = 0;

        while (!queue.isEmpty()) {
            level++;
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();

                if (node.left == null && node.right == null) {
                    return level;
                }
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
        }

        return level;
    }



}
