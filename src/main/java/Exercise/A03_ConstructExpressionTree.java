package Exercise;

import DataStructure.BinaryTree.TreeNode;

import java.util.LinkedList;

public class A03_ConstructExpressionTree {

    public static void main(String[] args) {
        String[] tokens = {"2", "1", "-", "3", "*"};
        TreeNode<String> expressionTree = constructByReversePolishNotation(tokens);
        postOrder(expressionTree);
    }

    /**
     * 后缀表达式构建表达式树
     * @param tokens 后缀表达式字符串数组
     * @return 构建好的树的根节点
     */
    public static TreeNode<String> constructByReversePolishNotation(String[] tokens) {
        LinkedList<TreeNode<String>> stack = new LinkedList<>();
        for (String token : tokens) {
            switch (token) {
                case "+", "-", "*", "/" -> {
                    TreeNode<String> right = stack.pop();
                    TreeNode<String> left = stack.pop();
                    TreeNode<String> parent = new TreeNode<>(token);

                    //建立节点关系
                    parent.left = left;
                    parent.right = right;

                    //入栈
                    stack.push(parent);
                }
                //遇到数字
                default -> {
                    stack.push(new TreeNode<String>(token));
                }
            }
        }

        return stack.peek();
    }

    private static void postOrder(TreeNode<String> root) {
        LinkedList<TreeNode<String>> stack = new LinkedList<>();
        TreeNode<String> current = root;
        TreeNode<String> pop = null;

        while (current != null || !stack.isEmpty()) {
            if (current != null) {
                stack.push(current);
                current = current.left;
            } else {
                TreeNode<String> peek = stack.peek();
                if (peek.right == null || peek.right.equals(pop)) {
                    pop = stack.pop();
                    System.out.print(pop + "");
                } else {
                    current = peek.right;
                }
            }
        }
    }

}
