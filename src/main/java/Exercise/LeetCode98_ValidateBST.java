package Exercise;


import java.util.LinkedList;

public class LeetCode98_ValidateBST {

    long prev = Long.MIN_VALUE;

    /**
     * 二叉搜索树的特性：左子树小于节点，右子树大于节点。
     * 使用中序遍历去遍历一颗合法的二叉搜索树会有升序的特性。
     * 因此，中序遍历时，当下一个节点小于上一个节点，即为不合法的二叉搜索树
     * @param root binary search tree' root
     * @return ture - is validated, false - not validate
     */

    public boolean isValidBST1(TreeNode root) {
        LinkedList<TreeNode> stack = new LinkedList<>();
        TreeNode currentNode = root;

        while(currentNode != null || !stack.isEmpty()) {
            if (currentNode != null) {
                stack.push(currentNode);
                currentNode = currentNode.left;
            } else {
                TreeNode pop = stack.pop();
                if (prev >= pop.val) {
                    return false;
                }
                prev = pop.val;
                currentNode = pop.right;
            }
        }

        return true;
    }

    /*
        递归求解。
        由于是多路递归，因此可以使用剪支去减少不必要的递归过程。

     */
    public boolean isValidBST(TreeNode root) {
        if (root == null) return true;

        boolean leftSide = isValidBST(root.left);

        // 剪支，减少递归次数
        if (leftSide == false) {
            return false;
        }

        // 上一个节点大于下一个节点，说明这不是一颗合法的二叉搜索树
        if (prev > root.val) {
            return false;
        }

        // 更新prev的值
        prev = root.val;

        return isValidBST(root.right);

    }

}
