/**
 * 最大深度算法。
 * 这是递归解法的代码。
 */

package BinaryTree;

public class TreeMaxDepth {
    public static void main(String[] args) {
//        TreeNode root = new TreeNode(
//                new TreeNode(
//                            new TreeNode(
//                                    new TreeNode(4),
//                                    8,
//                                    new TreeNode(9)),
//                        2,
//                            new TreeNode(7)),
//                1,
//                            new TreeNode(new TreeNode(5),
//                        3,
//                        null)
//        );

        TreeNode root = new TreeNode(
                new TreeNode(new TreeNode(4), 2, null),
                1,
                new TreeNode(new TreeNode(5), 3, new TreeNode(6))
        );

        int result = maxDepth(root);

        System.out.println(result);
    }

    public static int maxDepth(TreeNode node){
        if (node == null){
            return 0;
        }

        if (node.left == null && node.right == null){
            return 1;
        }

        int depth1 = maxDepth(node.left);
        int depth2 = maxDepth(node.right);

        //通常情况下结果不用+1
        //这里+1只是因为leetcode的题库答案需要+1
        if (depth1 >= depth2){
            return depth1 + 1;
        }else {
            return depth2 + 1;
        }
    }
}
