package Exercise;

public class LeetCode1008_ConstructBSTfromPreorderTraversal {
    public TreeNode bstFromPreorder(int[] preorder) {
        //构建根节点
        TreeNode root = new TreeNode(preorder[0]);

        for (int i = 1; i < preorder.length; i++) {
            buildTree(root, preorder[i]);
        }

        return root;

    }

    private void buildTree(TreeNode node, int val) {
        //值比节点小，并且左边有位置
        if (val < node.val && node.left == null) {
            //新增节点在左边
            node.left = new TreeNode(val);
            return;
        }
        //值比节点大，并且右边有位置
        if (val > node.val && node.right == null) {
            //新增节点在右边
            node.right = new TreeNode(val);
            return;
        }

        //上面条件不成立，说明节点的左右两边没有空位，应该继续往下找空位
        if (val < node.val) {
            buildTree(node.left, val);
        }
        if (val > node.val) {
            buildTree(node.right, val);
        }
    }
}
