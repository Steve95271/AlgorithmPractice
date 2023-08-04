/**
 * Tree traversal 3. This is not a recursion implementation.
 * Post order code.
 *
 */
package BinaryTree;

import java.util.LinkedList;

public class TreeTraversal3 {
    public static void main(String[] args) {
        /*     1
         *    / \
         *   2   3
         *  /   / \
         * 4   5   6   */

        TreeNode root = new TreeNode(
                new TreeNode(new TreeNode(4), 2, new TreeNode(7)),
                1,
                new TreeNode(new TreeNode(5), 3, new TreeNode(6))
        );

        //Current node
        TreeNode current = root;

        //last node be pop
        TreeNode pop = null;

        //By using stack for remember the way back
        LinkedList <TreeNode> stack = new LinkedList<>();

        while(current != null || !stack.isEmpty()){
            if (current != null) {
                stack.push(current); //push to stack to remember the way back
                current = current.left;
            }else {
                TreeNode peek = stack.peek();
                if (peek.right == null || peek.right == pop) {
                    pop = stack.pop();
                    System.out.println("back: " + pop.val);
                }else {
                    current = peek.right;
                }
            }
        }
    }
}
