/**
 * Tree traversal 2. This is not a recursion implementation.
 */
package DataStructure.BinaryTree;

import java.util.LinkedList;

public class TreeTraversalNonRecur {

    public static void main(String[] args) {
        /*     1
         *    / \
         *   2   3
         *  /   / \
         * 4   5   6   */

        TreeNode<Integer> root = new TreeNode<Integer>(
                new TreeNode<Integer>(new TreeNode<Integer>(4), 2, new TreeNode<Integer>(7)),
                1,
                new TreeNode<Integer>(new TreeNode<Integer>(5), 3, new TreeNode<Integer>(6))
        );

        preOrder(root);
        System.out.println("\n-----------");
        inOrder(root);
        System.out.println("\n-----------");
        postOrder(root);

    }

    private static void traversal(TreeNode<Integer> node) {
        LinkedList<TreeNode<Integer>> stack = new LinkedList<>();
        TreeNode<Integer> currentNode = node;

        while (currentNode != null || !stack.isEmpty()) {
            if (currentNode != null) {
                //System.out.println("go: " + currentNode.val);
                stack.push(currentNode);
                currentNode = currentNode.left;
            } else {
                TreeNode<Integer> pop = stack.pop();
                if (pop.right != null) {
                    stack.push(pop.right);
                } else {
                    System.out.println("back: " + pop.val);
                }
                currentNode = pop.right;
            }
        }

    }

    private static void preOrder(TreeNode<Integer> node) {
        LinkedList<TreeNode<Integer>> stack = new LinkedList<>();
        TreeNode<Integer> currentNode = node;

        while (currentNode != null || !stack.isEmpty()) {
            if (currentNode != null) {
                System.out.print(currentNode.val + " ");
                stack.push(currentNode);
                currentNode = currentNode.left;
            } else {
                TreeNode<Integer> pop = stack.pop();
                currentNode = pop.right;
            }
        }
    }


    private static void inOrder(TreeNode<Integer> node) {
        LinkedList<TreeNode<Integer>> stack = new LinkedList<>();
        TreeNode<Integer> currentNode = node;

        while (currentNode != null || !stack.isEmpty()) {
            if (currentNode != null) {
                stack.push(currentNode);
                currentNode = currentNode.left;
            } else {
                TreeNode<Integer> pop = stack.pop();
                System.out.print(pop.val + " ");
                currentNode = pop.right;
            }
        }
    }

    private static void postOrder(TreeNode<Integer> node) {
        LinkedList<TreeNode<Integer>> stack = new LinkedList<>();
        TreeNode<Integer> currentNode = node;
        TreeNode<Integer> pop = null;

        while (currentNode != null || !stack.isEmpty()) {
            if (currentNode != null) {
                stack.push(currentNode);
                currentNode = currentNode.left;
            } else {
                TreeNode<Integer> peek = stack.peek();
                if (peek.right == null || peek.right.equals(pop)) {
                    pop = stack.pop();
                    System.out.print(pop.val + " ");
                } else {
                    currentNode = peek.right;
                }
            }
        }
    }

}
