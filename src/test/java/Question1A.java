import java.util.LinkedList;
import java.util.Scanner;

public class Question1A {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        LinkedList<Integer> stack = new LinkedList<>();
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNext()) { // 注意 while 处理多个 case
            String a = in.next();
            try {
                int num = Integer.parseInt(a);
                stack.push(num);
            } catch (NumberFormatException e) {
                if (a.equals("+") || a.equals("-") || a.equals("*")) {
                    if (a.equals("+")) {
                        int result = 0;
                        while (!stack.isEmpty()) {
                            int num = stack.pollLast();
                            result = result + num;
                        }
                        System.out.println(result);
                    } else if (a.equals("-")) {
                        int result = 0;
                        while (!stack.isEmpty()) {
                            int num = stack.pollLast();
                            result = result - num;
                        }
                        System.out.println(result);
                    } else if (a.equals("*")) {
                        int result = 0;
                        while (!stack.isEmpty()) {
                            int num = stack.pollLast();
                            result = result * num;
                        }
                        System.out.println(result);
                    }
                }
            }

            System.out.println(stack);

        }
    }
}
