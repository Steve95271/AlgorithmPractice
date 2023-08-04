package BinaryTree;

import java.util.LinkedList;
import java.util.Queue;

public class TreeMinDepth {

    /**
     * 后序遍历法
     * @param node 传入树的根节点
     * @return 返回最小深度
     */
    public int minDepth(TreeNode node) {
        if(node == null){
            return 0;
        }

        int leftDepth = minDepth(node.left);
        int rightDepth = minDepth(node.right);


        //右子树为空，返回左子树的深度+1
        if (rightDepth == 0){
            return leftDepth + 1;
        }

        //当左子树为空，返回右子树的深度+1
        if (leftDepth == 0){
            return rightDepth + 1;
        }

        return Integer.min(leftDepth,rightDepth) + 1;

    }


    /*
    层序遍历，遇到的第一个叶子节点所在层就是最小深度
 */
    public int minDepth2(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int depth = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            depth ++;
            for (int i = 0; i < size; i++) {
                TreeNode poll = queue.poll();
                if (poll.left == null && poll.right == null) {
                    return depth;
                }
                if (poll.left != null) {
                    queue.offer(poll.left);
                }
                if (poll.right != null) {
                    queue.offer(poll.right);
                }
            }
        }
        return depth;
    }
}


