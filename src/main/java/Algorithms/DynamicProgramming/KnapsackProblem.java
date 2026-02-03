package Algorithms.DynamicProgramming;

import java.util.Arrays;
import java.util.stream.IntStream;

public class KnapsackProblem {

    /*
        1. n个物品都是固体，有重量和价值
        2. 现在你要取走不超过 10克 的物品
        3. 每次可以不拿或全拿，问最高价值是多少

            编号 重量(g)  价值(元)                        简称
            1   4       1600           黄金一块   400    A
            2   8       2400           红宝石一粒 300    R
            3   5       30             白银一块         S
            0   1       10_000         钻石一粒          D
        1_001_630

        1_002_400
     */

    /*
      二维表格：
        - 行对应着物品的数量
        - 列对应着可以拿走的总克数

      算法思路：
        - 第一行尝试放入黄金、第二行尝试放入红宝石、第三行尝试放入白银...
        - 每一行尝试放入的物品是和物品的顺序对应
        - 从第二行开始，尝试放入物品时如果放得下：
            - 拿当前的物品的价值与上一行同一列的物品的进行比较，把价值较大的物品放入背包
            - 在有剩余空间的情况下还需要把放得进背包的最大价值的物品放入（从上一行选）

        - 注意：第一行要做特殊处理

        1   2   3   4   5   6   7   8   9   10
      0             a   a   a   a   a   a   a
      1             a               r   r
      2             a               r
      3 d               da          da  dr  dr

      if (放得下) {
        dp[i][j] = Max(dp[i - 1][j], Item)  // 这样不对，还要考虑有剩余空间的情况
        dp[i][j] = Max(dp[i - 1][j], Item + dp[i - 1][j - Item.weight]) // 在上一行找除去当前物品重量还可以放得下的物品可以用[j - Item.weight]的式子
      } else { 放不下
        // 放不下就直接把上一行的物品直接放进来
        dp[i][j] = dp[i - 1][j]
      }
     */

    static class Item {
        int index;
        String name;
        int weight;
        int value;

        public Item(int index, String name, int weight, int value) {
            this.index = index;
            this.name = name;
            this.weight = weight;
            this.value = value;
        }

        @Override
        public String toString() {
            return "Item(" + name + ")";
        }
    }

    public static void main(String[] args) {
        Item[] items = new Item[]{
                new Item(1, "黄金", 4, 1600),
                new Item(2, "宝石", 8, 2400),
                new Item(3, "白银", 5, 30),
                new Item(4, "钻石", 1, 10_000),
        };

        select(items, 10);
    }

    private static void select(Item[] items, int total) {
        // 初始化动态规划二维数组
        int dp[][] = new int[items.length][total + 1]; // total + 1 是要从一号索引开始来当作一克放入物品

        // 特殊处理第一行
        Item item0 = items[0];
        for (int column = 1; column < total + 1; column++) {
            if (item0.weight <= column) {
                dp[0][column] = item0.value;
            } else {
                dp[0][column] = 0;
            }
        }

        for (int row = 1; row < items.length; row++) {
            Item item = items[row];
            for (int column = 1; column < total + 1; column++) {
                if (item.weight <= column) {
                    dp[row][column] = Math.max(dp[row - 1][column], item.value + dp[row - 1][column - item.weight]);
                } else {
                    dp[row][column] = dp[row - 1][column];
                }
            }
        }

        print(dp);
    }

    static void print(int[][] dp) {
        System.out.println("   " + "-".repeat(63));
        Object[] array = IntStream.range(0, dp[0].length + 1).boxed().toArray();
        System.out.printf(("%5d ".repeat(dp[0].length)) + "%n", array);
        for (int[] d : dp) {
            array = Arrays.stream(d).boxed().toArray();
            System.out.printf(("%5d ".repeat(d.length)) + "%n", array);
        }
    }
}
