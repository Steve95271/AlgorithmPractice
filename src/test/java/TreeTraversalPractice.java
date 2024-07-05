import Exercise.TreeNode;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;

public class TreeTraversalPractice {
    /*     10
     *    /  \
     *   5    15
     *  / \     \
     * 3   7     18   */

    private final TreeNode root = new TreeNode(
            10,
            new TreeNode(5,
                    new TreeNode(3),
                    new TreeNode(7)),
            new TreeNode(15,
                    null,
                    new TreeNode(18))
    );

    @Test
    public void testPreorder() {
        preorder(root);
    }

    @Test
    public void testInorder() {
        inorder(root);
    }

    private void preorder(TreeNode node) {
        LinkedList<TreeNode> stack = new LinkedList<>();
        TreeNode current = node;

        while (current != null || !stack.isEmpty()) {
            if (current != null) {
                System.out.println(current.val);
                stack.push(current);
                current = current.left;
            } else {
                TreeNode pop = stack.pop();
                current = pop.right;
            }
        }
    }

    private void inorder(TreeNode node) {
        LinkedList<TreeNode> stack = new LinkedList<>();
        TreeNode current = node;

        while (current != null || !stack.isEmpty()) {
            if (current != null) {
                stack.push(current);
                current = current.left;
            } else {
                TreeNode pop = stack.pop();
                System.out.println(pop.val);
                current = pop.right;
            }
        }
    }

}
