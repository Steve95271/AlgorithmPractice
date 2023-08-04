/**
 * Tree traversal 2. This is not a recursion implementation.
 *
 */
package BinaryTree;

import java.util.LinkedList;

public class TreeTraversal2 {
    public static void main(String[] args) {
        /*     1
         *    / \
         *   2   3
         *  /   / \
         * 4   5   6   */

        TreeNode<Integer> root = new TreeNode<Integer>(
                new TreeNode<Integer>(new TreeNode<Integer>(4), 2, null),
                1,
                new TreeNode<Integer>(new TreeNode<Integer>(5), 3, new TreeNode<Integer>(6))
        );


        preOrder(root);

    }

    private static void preOrder(TreeNode<Integer> root){
        LinkedList<TreeNode<Integer>> stack = new LinkedList<>();
        TreeNode<Integer> currentNode = root;

        while(currentNode != null || !stack.isEmpty()){
            //Go left until the end
            if(currentNode != null) {
                System.out.print(currentNode.val + " ");
                stack.push(currentNode);
                currentNode = currentNode.left;
            }
            //Reach the end of the left child then come back
            else {
                TreeNode<Integer> pop = stack.pop();

                //on the way back assign the right child to the root
                currentNode = pop.right;
            }
        }
    }
}
