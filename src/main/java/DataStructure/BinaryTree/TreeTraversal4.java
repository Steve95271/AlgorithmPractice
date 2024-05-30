/**
 * Tree traversal 4. This is not a recursion implementation.
 * This version can handel three different order traversal.
 *
 */
package DataStructure.BinaryTree;

import java.util.LinkedList;

public class TreeTraversal4 {
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
                if (peek.right == null) {
                    System.out.println("in order: " + peek.val);
                    pop = stack.pop();
                }
                //This means right node is finished traversal
                else if (peek.right == pop) {
                    pop = stack.pop();
                }
                //Right node is waiting for traversal
                else {
                    System.out.println("in order: " + peek.val);
                    current = peek.right;
                }
            }
        }
    }
}
