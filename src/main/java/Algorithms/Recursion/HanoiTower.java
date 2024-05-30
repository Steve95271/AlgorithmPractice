package Algorithms.Recursion;

import java.util.LinkedList;

/**
 * 递归求解汉诺塔
 * 时间复杂度为O(2^n)，指数级的时间复杂度
 */
public class HanoiTower {
    static LinkedList<Integer> source = new LinkedList<>();
    static LinkedList<Integer> intermediate = new LinkedList<>();
    static LinkedList<Integer> target = new LinkedList<>();

    static void move(int n, LinkedList<Integer> source, LinkedList<Integer> intermediate, LinkedList<Integer> target) {
        if (n == 0) {
            return;
        }

        //先把n - 1个盘子移动到中间的柱子
        move(n -1, source, target, intermediate);

        //当n等于1时，也就是只剩下一个圆盘时，只需要把它从原来的位置移动到目标位置
        //这一步是中间的步骤
        target.addLast(source.removeLast());
        print();

        //最后一步，在中间的盘子借助源柱子移动到目标柱子
        move(n - 1, intermediate, source, target);
    }

    private static void print() {
        System.out.println(source);
        System.out.println(intermediate);
        System.out.println(target);
        System.out.println("-----------");
    }

    private static void init(int n) {

        for (int i = n; i > 0 ; i--) {
            source.addLast(i);
        }

    }
    public static void main(String[] args) {
        init(25);
        print();
        move(25, source, intermediate, target);
        print();
    }
}
