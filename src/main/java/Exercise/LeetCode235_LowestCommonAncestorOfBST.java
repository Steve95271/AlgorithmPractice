package Exercise;

public class LeetCode235_LowestCommonAncestorOfBST {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode current = root;

        while (current.val > p.val && current.val > q.val || current.val < p.val && current.val < q.val) {
            // 只需要比较p和q其中一个节点就可以
            // 能够执行到这行代码，说明p和q时同时大于或者小于current的
            if (current.val < p.val) { // 在右边
                current = current.right;
            } else { // 在左边
                current = current.left;
            }
        }

        // 循环结束，找到最近公共祖先
        return current;
    }

}
