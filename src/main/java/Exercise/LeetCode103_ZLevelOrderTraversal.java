package Exercise;

import DataStructure.StackAndQueue.Tree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 二叉树的锯齿形层序遍历
 * 给你二叉树的根节点 root ，返回其节点值的 锯齿形层序遍历 。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。
 */
public class LeetCode103_ZLevelOrderTraversal {
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
        //用于判断数据从左边添加还是右边添加
        //一开始先从左边开始添加
        //当一轮添加完成之后更新变量
        //达到交替添加的效果
        boolean leftToRight = true;
        while (!queue.isEmpty()) {
            LinkedList<Integer> level = new LinkedList<>();
            int count = 0;

            for (int i = 0; i < nodes; i++) {
                TreeNode n = queue.poll();

                if (n == null) {
                    break;
                }

                if (leftToRight) {
                    level.offerLast(n.val);
                } else {
                    level.offerFirst(n.val);
                }


                if (n.left != null) {
                    queue.offer(n.left);
                    count++;
                }

                if (n.right != null) {
                    queue.offer(n.right);
                    count++;
                }
            }

            //换边添加
            leftToRight = !leftToRight;
            //更新子节点数
            nodes = count;
            //把每层遍历到的数据加到list中
            result.add(level);
        }

        return result;
    }
}
