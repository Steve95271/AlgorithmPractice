package Algorithms.GreedyAlgorithms.CoinChangeProblems;

public class CoinChangeI_Greedy {
    public static void main(String[] args) {
        System.out.println(change(new int[]{5, 2}, 18));
    }

    /*
    * coins = [5, 2, 1]
    * amount = 14
    *
    * - 贪心：每次都拿减去剩余金额不为零的最大面值硬币
    *
    * 14 - 5 = 9
    * 9 - 5 = 4
    * 4 - 2 = 2
    * 4 - 2 = 0
    *
    * coins = [5, 2]
    * amount = 18
    * 18 - 5 = 13
    * 13 - 5 = 8
    * 8 - 5 = 3
    * 3 - 2 = 1
    * */
    private static int change(int[] coins, int amount) {
        int remainder = amount;
        int index = 0;
        int numberOfCoins = 0;

        while (remainder > 0 && index < coins.length) {
            if (remainder - coins[index] >= 0) {
               remainder = remainder - coins[index];
               numberOfCoins++;
            } else {
                index++;
            }
        }

        if (remainder == 0) {
            return numberOfCoins;
        } else {
            return -1;
        }
    }
}
