package Exercise;

public class LeetCode938_RangeSumOfBST {

    /*
    Given the root node of a binary search tree and two integers low and high,
    return the sum of values of all nodes with a value in the inclusive range [low, high].

                            10
                          /    \
                         5      15
                        / \        \
                       3   7        18

    Input: root = [10,5,15,3,7,null,18], low = 7, high = 15
    Output: 32
    Explanation: Nodes 7, 10, and 15 are in the range [7, 15]. 7 + 10 + 15 = 32.
     */

    public int rangeSumBST(TreeNode root, int low, int high) {

        /*
        如果在范围内，就递归调用方法，把左子树和右子树传递过去，并把返回的值累加起来。
        当值小于low时，应该返回右子树。
        当值大于high时，应该返回左子树。
         */

        if (root == null) {
            return 0;
        }

        if (root.val < low) {
            return rangeSumBST(root.right, low, high);
        }

        if (root.val > high) {
            return rangeSumBST(root.left, low, high);
        }

        return root.val + rangeSumBST(root.left, low, high) + rangeSumBST(root.right, low, high);
    }

}
