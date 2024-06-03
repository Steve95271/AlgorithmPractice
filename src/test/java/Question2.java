import java.util.Arrays;
import java.util.Scanner;

public class Question2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int task = 0;

        int max = 0;

        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextLine()) { // 注意 while 处理多个 case
            String s = in.nextLine();
            try {
                task = Integer.parseInt(s);
            } catch(NumberFormatException e) {
                String[] startAndEnd = s.split(" ");
                int day1 = Integer.parseInt(startAndEnd[0]);
                int day2 = Integer.parseInt(startAndEnd[1]);
                int taskADay = day2 - day1 + 1;
                if (taskADay > max) {
                    max = taskADay;
                }
            }

            /*if (in.hasNextInt()) {
                task = in.nextInt();
                System.out.println(task);
            } else {
                String startAndEnd = in.nextLine();
                String[] s = startAndEnd.split(" ");
                int day1 = Integer.parseInt(s[0]);
                int day2 = Integer.parseInt(s[1]);
                int taskADay = day2 - day1 + 1;
                if (taskADay > max) {
                    max = taskADay;
                }
                System.out.println(max);
            }*/

        }

        System.out.println(max);


    }
}
