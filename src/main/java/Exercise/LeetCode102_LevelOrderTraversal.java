package Exercise;

import DataStructure.StackAndQueue.Tree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 队列实现的二叉树层序遍历
 */
public class LeetCode102_LevelOrderTraversal {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(
                new TreeNode(
                        new TreeNode(4),
                        2,
                        new TreeNode(5)
                ),
                1,
                new TreeNode(
                        new TreeNode(6),
                        3,
                        new TreeNode(7)
                )
        );

        TreeNode root2 = new TreeNode(new TreeNode(new TreeNode(new TreeNode(new TreeNode(5), 4, null), 3, null), 2, null), 1, null);

        List<List<Integer>> lists = levelOrder(root);

        for (List<Integer> list : lists) {
            System.out.println(list);
        }
    }

    public static List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }

        List<List<Integer>> result = new ArrayList<>();
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        //一开始只有一个节点
        int nodes = 1;
        while (!queue.isEmpty()) {
            List<Integer> level = new ArrayList<>();
            int count = 0;

            for (int i = 0; i < nodes; i++) {
                TreeNode n = queue.poll();

                if (n == null) {
                    break;
                }

                level.add(n.val);

                if (n.left != null) {
                    queue.offer(n.left);
                    count++;
                }

                if (n.right != null) {
                    queue.offer(n.right);
                    count++;
                }
            }

            //更新子节点数
            nodes = count;
            //把每层遍历到的数据加到list中
            result.add(level);
        }

        return result;
    }
}
