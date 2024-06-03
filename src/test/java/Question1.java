import java.util.LinkedList;
import java.util.Scanner;

public class Question1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        LinkedList stack = new LinkedList<>();
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNext()) { // 注意 while 处理多个 case
            String a = in.next();
            int num = 0;
            try {
                num = Integer.parseInt(a);

                if (stack.peek() == null) {
                    stack.push(num);
                    continue;
                }

                Object peek = stack.peek();

                if (peek.equals("+") || peek.equals("-") || peek.equals("*")) {
                    stack.push(num);
                    // 运算符后加进来一个数字，开始清空栈
                    StringBuilder stringBuilder = new StringBuilder();
                    while (!stack.isEmpty()) {
                        Object last = stack.pollLast();
                        stringBuilder.append(last);
                    }

                    System.out.println(stringBuilder);
                } else {
                    stack.push(num);
                }
            } catch (NumberFormatException e) {
                if (a.equals("+") || a.equals("-") || a.equals("*")) {
                    Object peek = stack.peek();
                    if (peek.equals("+") || peek.equals("-") || peek.equals("*")) {
                        return;
                    } else {
                        stack.push(a);
                    }
                } else {
                    return;
                }
            }
        }
    }
}
