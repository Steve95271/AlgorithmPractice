import java.util.Scanner;

public class ExchangeBottles {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextInt()) { // 注意 while 处理多个 case
            int num = in.nextInt();
            if (num == 0) {
                break;
            }
            int result = 0;
            int remainder = 0;
            int remainderSum = 0;

            while (num > 2) {
                if ((num + remainder) % 3 == 0) {
                    num = num / 3;
                    result = result + num;
                    // 重制reaminder
                    remainder = 0;
                    remainderSum = 0;
                } else {
                    if (num % 3 != 0) {
                        remainder = num % 3; // 1
                        remainderSum = remainderSum + remainder;
                        num = num - remainder;
                    }
                    num = num / 3; // 1
                    result = result + num;
                }
            }

            if (num == 2) {
                result = result + num;
            } else if ((num + remainder) == 2 || remainder == 2) {
                result = result + 1;
            }

            if (remainderSum % 3 == 0) {
                result = result + (remainderSum / 3);
            }


            System.out.println("Remainder: " + remainder);
            System.out.println("Remainder sum: " + remainderSum);
            System.out.println("Result: " + result);
        }
    }
}
