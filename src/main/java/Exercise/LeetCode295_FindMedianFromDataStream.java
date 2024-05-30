package Exercise;

import java.util.Comparator;
import java.util.PriorityQueue;

public class LeetCode295_FindMedianFromDataStream {

    /*
        大小顶堆解法
     */

    // 创建一个大顶堆，一个小顶堆
    // 大顶堆在左边，小顶堆在右边
    PriorityQueue<Integer> left = new PriorityQueue<>(new Comparator<Integer>() { // 重写比较器，让建树规则变成大顶堆
        @Override
        public int compare(Integer o1, Integer o2) {
            return o2 - o1;
        }
    });
    PriorityQueue<Integer> right = new PriorityQueue<>();

    public LeetCode295_FindMedianFromDataStream() {
    }



    /*
        为了确保两边数据量平衡
            - 两边个数一样时，新元素家在左边
            - 两边个数不一样时，新元素加在右边

        并不是随便一个数就能够加入的，要让左边的任意一个元素小于或者等于右边的任意一个元素
            - 元素要加到左边时，先把新元素加到右边（小顶堆），再弹出堆顶元素（最小的），加在左边
            - 元素要加到右边时，先把新元素加到左边（大顶堆），在弹出堆顶元素（最大的），加在右边
     */
    public void addNum(int num) {
        if (left.size() == right.size()) { // 元素个数一样，加到左边的大顶堆
            right.add(num);
            Integer element = right.poll();
            left.add(element);
        } else {
            left.add(num);
            Integer element = left.poll();
            right.add(element);
        }

        System.out.println(left + " -- " + right);
    }

    public double findMedian() {
        if (left.size() == right.size()) { //数据是偶数个，求中间两个数的平均值
            return (left.peek() + right.peek()) / 2.0;
        } else {
            return left.poll();
        }
    }

    public static void main(String[] args) {
        LeetCode295_FindMedianFromDataStream median = new LeetCode295_FindMedianFromDataStream();

        median.addNum(1);
        median.addNum(2);
        median.addNum(3);
        median.addNum(4);
        median.addNum(5);
        System.out.println(median.findMedian());


    }

}
