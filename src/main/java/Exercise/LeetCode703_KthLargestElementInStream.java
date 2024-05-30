package Exercise;

import DataStructure.Heap.MinHeap;

public class LeetCode703_KthLargestElementInStream {

    /*
        Design a class to find the kth largest element in a stream.
        Note that it is the kth largest element in the sorted order, not the kth distinct element.

        Implement KthLargest class:

        KthLargest(int k, int[] nums) Initializes the object with the integer k and the stream of integers nums.
        int add(int val) Appends the integer val to the stream and returns
        the element representing the kth largest element in the stream.


        Example 1:

        Input
        ["KthLargest", "add", "add", "add", "add", "add"]
        [[3, [4, 5, 8, 2]], [3], [5], [10], [9], [4]]
        Output
        [null, 4, 5, 5, 8, 8]

        Explanation
        KthLargest kthLargest = new KthLargest(3, [4, 5, 8, 2]);
        kthLargest.add(3);   // return 4
        kthLargest.add(5);   // return 5
        kthLargest.add(10);  // return 5
        kthLargest.add(9);   // return 8
        kthLargest.add(4);   // return 8


        Constraints:

        1 <= k <= 104
        0 <= nums.length <= 104
        -104 <= nums[i] <= 104
        -104 <= val <= 104
        At most 104 calls will be made to add.
        It is guaranteed that there will be at least k elements
        in the array when you search for the kth element.
     */

    /*
       解题思路：数组小顶堆解法
       1. 使用题目中传过来的K创建小顶堆的数组大小，使得这个小顶堆最多只能存入K个元素
       2. 创建小顶堆后再把题目中传过来的数组的元素添加到堆中，添加完成后，堆顶元素就是第K大元素
       3. 为了应对题目中还会添加新元素的需求，在添加新元素时，使用小顶堆的replace方法加入新的元素。
          细节：新加入的元素如果比堆顶元素更小，应该忽略掉（因为我们需要的是第K大的元素）。
     */

    private MinHeap heap;

    public LeetCode703_KthLargestElementInStream(int k, int[] nums) {
        //用 k 作为容量创建小顶堆
        heap = new MinHeap(k);

        for (int num : nums) {
            add(num);
        }
    }

    public int add(int val) {
        //防止传过来的是空数组，先把数组放满
        if (!heap.isFull()) {
            heap.offer(val);
        } else if (heap.peek() < val){ //检查新添元素比堆顶元素要大时才加进去
            heap.replace(val);
        }
        return heap.peek();
    }

}
