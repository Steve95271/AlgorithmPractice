package BinaryTree;

import java.util.LinkedList;

/**
 * 根据后缀表达式构建表达式树
 */
public class ExpressionTree {

    /*
        中缀表达式           (2-1)*3
        后缀（逆波兰）表达式   21-3*

        1.遇到数字入栈
        2.遇到运算符, 出栈两次, 与当前节点建立父子关系, 当前节点入栈

        栈
        |   |
        |   |
        |   |
        _____

        表达式树
            *
           / \
          -   3
         / \
        2   1

        21-3*
     */

    public TreeNode constructExpressionTree(String[] tokens){
        LinkedList<TreeNode> stack = new LinkedList<>();
        for (String element : tokens) {
            switch(element){
                //运算符
                case "+", "-", "*", "/" ->{
                    TreeNode right = stack.pop();
                    TreeNode left = stack.pop();
                    TreeNode parent = new TreeNode<>(element);
                    parent.left = left;
                    parent.right = right;
                    stack.push(parent);
                }
                //数字
                default ->{
                    stack.push(new TreeNode<>(element));
                }
            }
        }

        return stack.peek();
    }
}
