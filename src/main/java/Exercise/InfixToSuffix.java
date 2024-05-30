package Exercise;

import java.util.LinkedList;

/**
 * 中缀表达式转后缀表达式
 */
public class InfixToSuffix {
    /*
        把中缀表达式“4 + 3 * 2”转成后缀表达式“
        +*
        432*+

        思路：
        - 遇到非运算符，拼接字符串
        - 遇到 “+ - * /” Operator
            1. Operator的优先级比栈顶高，入栈
            2. 否则把栈中优先级较高(>=)的运算符都出栈之后，才把operator入栈
        - 当遍历完字符串，把栈的运算符全部弹出来拼接到字符串中
        - 带括号()
            1. 左括号，直接入栈，优先级为0
            2. 右括号，while != 左括号，不断pop出来拼接
     */

    public static void main(String[] args) {
//        System.out.println(infixToSuffix("4+3*2"));
//        System.out.println(infixToSuffix("4+3*2-1"));
//        System.out.println(infixToSuffix("4-3/2"));
//        System.out.println(infixToSuffix("4*3+2"));
        System.out.println(infixToSuffix("(4+3)*2"));
    }

    public static String infixToSuffix(String infixExpr) {
        //Stack for operator
        LinkedList<Character> stack = new LinkedList<>();
        //String builder for building suffix expression
        StringBuilder stringBuilder = new StringBuilder(infixExpr.length());

        for (int i = 0; i < infixExpr.length(); i++) {
            char c = infixExpr.charAt(i);
            switch (c) {
                case '+', '-', '*', '/' -> {
                    if (stack.isEmpty()) {
                        stack.push(c);
                    } else if (priority(c) > stack.peek()) { //当字符串中的运算符的优先级大于栈顶的运算符才进栈
                        stack.push(c);
                    } else {
                        //如果栈中的运算符的优先级 >= c，要先全部出栈并拼接到字符串中
                        //当栈不为空才不断循环
                        while (!stack.isEmpty() && priority(stack.peek()) >= priority(c)) {
                            stringBuilder.append(stack.pop());
                        }
                        //遍历完，当前运算符才入栈
                        stack.push(c);
                    }
                }
                case '(' -> {
                    stack.push(c);
                }
                case ')' -> {
                    while (stack.peek() != '(') {
                        stringBuilder.append(stack.pop());
                    }
                    stack.pop();
                }
                //当遇到非运算符（即系数字），直接拼接
                default -> stringBuilder.append(c);
            }
        }

        while (!stack.isEmpty()) {
            stringBuilder.append(stack.pop());
        }

        return stringBuilder.toString();
    }

    /**
     * 判断运算符的优先级。
     * @param c 运算符
     * @return 加和减返回1，乘和除返回2
     */
    public static int priority(char c) {
        switch (c) {
            case '+', '-' -> {
                return 1;
            }
            case '*', '/' -> {
                return 2;
            }
            case '(' -> {
                return 0;
            }
            default -> throw new IllegalArgumentException("非法运算符：" + c);
        }
    }
}
