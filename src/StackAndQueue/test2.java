package StackAndQueue;

import java.util.Arrays;

public class test2 {
    public static void main(String[] args) {
        Integer[ ] a = {4, 8, 15, 16, 23, 42};
        String[ ] s = {"Jack", "Kate", "Hurley", "Jin", "Michael"};
        System.out.println("a = " + Arrays.toString(a));
        System.out.println("s = " + Arrays.toString(s));
        System.out.println("Reversing...");

        //reverse array a
        LinkedStack.reverse(a);

        //reverse array s
        LinkedStack.reverse(s);

        System.out.println("a = " + Arrays.toString(a));
        System.out.println("s = " + Arrays.toString(s));

        boolean check = LinkedStack.isMatched("{([<>])}");

        System.out.println(check);
    }
}
