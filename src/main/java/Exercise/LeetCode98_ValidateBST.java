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

    public static void main(String[] args) {
        // Test Case 1: Valid BST - Standard balanced tree
        //       2
        //      / \
        //     1   3
        TreeNode test1 = new TreeNode(2,
                new TreeNode(1),
                new TreeNode(3));
        LeetCode98_ValidateBST solution1 = new LeetCode98_ValidateBST();
        System.out.println("Test 1 - Valid BST (balanced): " + solution1.isValidBST(test1)); // Expected: true

        // Test Case 2: Invalid BST - Right child violation
        //       5
        //      / \
        //     1   4
        //        / \
        //       3   6
        TreeNode test2 = new TreeNode(5,
                new TreeNode(1),
                new TreeNode(4,
                        new TreeNode(3),
                        new TreeNode(6)));
        LeetCode98_ValidateBST solution2 = new LeetCode98_ValidateBST();
        System.out.println("Test 2 - Invalid BST (right child < root): " + solution2.isValidBST(test2)); // Expected: false

        // Test Case 3: Valid BST - Left-skewed tree
        //       5
        //      /
        //     3
        //    /
        //   1
        TreeNode test3 = new TreeNode(5,
                new TreeNode(3,
                        new TreeNode(1),
                        null),
                null);
        LeetCode98_ValidateBST solution3 = new LeetCode98_ValidateBST();
        System.out.println("Test 3 - Valid BST (left-skewed): " + solution3.isValidBST(test3)); // Expected: true

        // Test Case 4: Invalid BST - Duplicate values
        //       2
        //      / \
        //     2   3
        TreeNode test4 = new TreeNode(2,
                new TreeNode(2),
                new TreeNode(3));
        LeetCode98_ValidateBST solution4 = new LeetCode98_ValidateBST();
        System.out.println("Test 4 - Invalid BST (duplicate values): " + solution4.isValidBST(test4)); // Expected: false

        // Test Case 5: Valid BST - Larger tree with negative values
        //         10
        //        /  \
        //      -5    15
        //     /  \     \
        //   -10   0    20
        TreeNode test5 = new TreeNode(10,
                new TreeNode(-5,
                        new TreeNode(-10),
                        new TreeNode(0)),
                new TreeNode(15,
                        null,
                        new TreeNode(20)));
        LeetCode98_ValidateBST solution5 = new LeetCode98_ValidateBST();
        System.out.println("Test 5 - Valid BST (with negative values): " + solution5.isValidBST(test5)); // Expected: true
    }

}
