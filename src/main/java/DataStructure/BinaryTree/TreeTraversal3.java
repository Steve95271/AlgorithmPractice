/**
 * Tree traversal 3. This is not a recursion implementation.
 * Post order code.
 *
 */
package DataStructure.BinaryTree;

import java.util.Deque;
import java.util.LinkedList;

public class TreeTraversal3 {
    /*     1
     *    / \
     *   2   3
     *  /   / \
     * 4   5   6
     *
     * In order: 4 2 7 1 5 3 6
     * */
    private static final TreeNode<Integer> root = new TreeNode(
            new TreeNode(
                    new TreeNode(4),
                    2,
                    new TreeNode(7)),
            1,
            new TreeNode(
                    new TreeNode(5),
                    3,
                    new TreeNode(6))
    );

    private static void preOrderTraversal(TreeNode<Integer> root) {
        TreeNode<Integer> current = root;
        Deque<TreeNode<Integer>> stack = new LinkedList<>();

        while (current != null) {
            System.out.println(current.val);
            stack.push(current);
            current = current.left;

            while (current == null && !stack.isEmpty()) {
                TreeNode<Integer> pop = stack.pop();
                if (pop.right != null) {
                    current = pop.right;
                }
            }
        }
    }

    private static void inOrderTraversal(TreeNode<Integer> root) {
        TreeNode<Integer> current = root;
        Deque<TreeNode<Integer>> stack = new LinkedList<>();

        while (current != null) {
            stack.push(current);
            current = current.left;

            while (current == null && !stack.isEmpty()) {
                TreeNode<Integer> pop = stack.pop();
                System.out.println(pop.val);
                if (pop.right != null) {
                    current = pop.right;
                }
            }
        }
    }

    private static void postOrderTraversal(TreeNode<Integer> root) {
        /*      1
         *     / \
         *    2   3
         *  / \   / \
         * 4  7  5   6
         *
         * 后序遍历：
         *  - 顺序左右值
         *  - 遍历结果应该为: 4 7 2 5 6 3 1
         *
         * stack: Top <- [2 1] -> Bottom
         * peek = 2
         * pop = 7
         * result: 4
         **/
        TreeNode<Integer> current = root;
        Deque<TreeNode<Integer>> stack = new LinkedList<>();
        // 记录最近一次弹栈元素
        TreeNode<Integer> pop = null;
        while (current != null) {
            stack.push(current);
            current = current.left;

            while (current == null && !stack.isEmpty()) {
                TreeNode<Integer> peek = stack.peek();
                if (peek.right == null || peek.right == pop) {
                    pop = stack.pop();
                    System.out.println(pop.val);
                } else {
                    // 当堆顶元素还有右子节点，更新当前节点并打断内层循环让它进入外层循环的往左遍历
                    current = peek.right;
                    // 如果不打断内层循环，则无法遍历到左边的子节点
                    break;
                }
            }
        }
    }

    public static void main(String[] args) {
        //preOrderTraversal(root);
        postOrderTraversal(root);
    }

}
