package Exercise;

import DataStructure.BinaryTree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class LeetCode104_MaxDeep {

    int recursionMaxDeep(TreeNode node) {
        if (node == null) {
            return 0;
        }

        int leftDeep = recursionMaxDeep(node.left);
        int rightDeep = recursionMaxDeep(node.right);
        return Integer.max(leftDeep, rightDeep) + 1;
    }

    /*
        栈的最大高度是最大深度
     */
    int postOrderSolution(TreeNode node) {
        TreeNode currentNode = node;
        LinkedList<TreeNode> stack = new LinkedList<>();
        TreeNode pop = null;
        int max = 0;

        while(currentNode != null || !stack.isEmpty()) {
            if (currentNode != null) {
                stack.push(currentNode);
                int size = stack.size();
                if (size > max) {
                    max = size;
                }
                currentNode = currentNode.left;
            } else {
                TreeNode peek = stack.peek();
                if (peek.right == null || peek.right.equals(pop)) {
                    pop = stack.pop();
                } else {
                    currentNode = peek.right;
                }
            }
        }

        return max;
    }

    /*
        用层序遍历找出最大深度
     */
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
