package Algorithms.GreedyAlgorithms.CoinChangeProblems;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.ListIterator;

public class CoinChangeII_NotGreedy {
    public static void main(String[] args) {
        int totalCombinations = change(new int[]{15, 10, 1}, 21);
        System.out.println("total combinations: " + totalCombinations);
    }

    public static int change(int[] coins, int amount) {
        return rec(0, coins, amount, new LinkedList<>(), true);
    }

    public static int rec(int index, int[] coins, int remainder, LinkedList<Integer> stack, boolean first) {
        if (!first) {
            stack.push(coins[index]);
        }

        int combinations = 0;
        // 情况1: 剩余金额 < 0，无解
        if (remainder < 0) {
            print("无解", stack);
        }
        // 情况2: 剩余金额 == 0，有解
        else if (remainder == 0) {
            print("有解", stack);
            combinations = 1;
        }
        // 情况3: 剩余金额 > 0，继续递归找零钱的组合
        else {
            /*
             * 递归情况:
             *  用例: Coins[15, 10, 1], Amount = 21
             *
             *  rec(coin = 15, remainder = 21) - **初次调用**
             *    for loop:
             *      rec(coin = 15, remainder = 6)
             *      rec(coin = 10, remainder = 11)
             *      rec(coin = 1, remainder = 20)
             * */
            for (int i = index; i < coins.length; i++) {
                combinations += rec(i, coins, remainder - coins[i], stack, false);
            }
        }

        if (!stack.isEmpty()) {
            stack.pop();
        }

        return combinations;

    }

    private static void print(String prompt, LinkedList<Integer> stack) {
        ArrayList<Integer> print = new ArrayList<>();
        ListIterator<Integer> iterator = stack.listIterator(stack.size());
        while (iterator.hasPrevious()) {
            print.add(iterator.previous());
        }
        System.out.println(prompt + print);
    }
}
