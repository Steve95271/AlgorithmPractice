package Exercise;

import java.util.PriorityQueue;

public class LeetCode215_KthLargestNumber {


    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(k);

        // 先把前K个元素加进去min heap
        for (int i = 0; i < k; i++) {
            minHeap.offer(nums[i]);
        }

        // 把剩下的元素比堆顶大的元素替换掉
        // 最后等数组遍历完后，小顶堆的堆顶元素就是第k大的元素
        for (int i = k; i < nums.length; i++) {
            // 比较第i个元素和堆顶元素
            if (nums[i] > minHeap.peek()) {
                // 比堆顶元素大，替换掉
                minHeap.poll();
                minHeap.offer(nums[i]);
            }
        }

        return minHeap.peek();

    }

    public static void main(String[] args) {
        int[] nums = {3,2,1,5,6,4};

        int kthLargest = new LeetCode215_KthLargestNumber().findKthLargest(nums, 2);

        System.out.println(kthLargest);

    }
}
