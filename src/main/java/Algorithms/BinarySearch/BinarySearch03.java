package Algorithms.BinarySearch;

public class BinarySearch03 {

    public static void main(String[] args) {
        int[] arr = {12, 19, 21, 42, 56, 59, 136, 241, 539, 9527, 10086, 43961, 43962};

        /*System.out.println(binarySearch(arr, 42));
        System.out.println(binarySearch(arr, 136));
        System.out.println(binarySearch(arr, 9527));
        System.out.println(binarySearch(arr, 43961));
        System.out.println(binarySearch(arr, 14));*/

        binarySearch2(arr, 42);
    }


    public static int binarySearch(int[] arr, int target) {
        int leftPointer = 0; // 初始左指针为数组最左边
        int rightPointer = arr.length - 1; // 初始右指针为数组最右边
        int middlePointer; // 定义中间指针，后面会在循环中用到

        //当左边指针小于或者等于右边的指针时循环查找目标
        while (leftPointer <= rightPointer) {
            //更新中间索引
            middlePointer = (leftPointer + rightPointer) / 2;

            if (target < arr[middlePointer]) { // 目标小于中间值，说明目标在中间值的左边
                rightPointer = middlePointer - 1; // 右边指针移动到中间指针并缩小右边的范围
            } else if (target > arr[middlePointer]) { // 目标大于中间值，目标在中间指针的右边
                leftPointer = middlePointer + 1; // 左边指针移动到中间指针并缩小左边的范围
            } else { //当目标即不小于也不大于中指针指向的值时，目标找到
                return middlePointer; //返回中指针索引
            }
        }

        //循环结束，找不到
        return -1;
    }

    /**
     * 这个版本减少了循环内的比较次数。
     * 使用了左闭右开的思想，left可能指向要寻找的target，但是right仅仅表示范围的边界。
     * 因此right减left等于1的时候，目标就可能找到了。这里也只是可能，因为循环只是缩小范围。
     * 当它们两个指针相减少于1时说明right指针跑到左边去了，意味着没有找到。
     */
    public static int binarySearch2(int[] arr, int target) {
        int left = 0;
        int right = arr.length;

        while (1 < right - left) {
            int middle = (left + right) >>> 1;

            if (target < arr[middle]) {
                right = middle;
            } else {
                left = middle;
            }
        }

        if (arr[left] == target) {
            return left;
        } else {
            return -1;
        }
    }

    /**
     * 这个方法能够应对数组中有重复数字的情况。
     * 找到并返回在最左边的目标
     *
     * @param nums   有序数组
     * @param target 插入的数字
     * @return 重复数字中最左的元素
     */
    public static int binarySearchLeftMost(int[] nums, int target) {

        int leftPointer = 0;
        int rightPointer = nums.length - 1;
        int middlePointer;

        while (leftPointer <= rightPointer) {
            //更新中间索引
            middlePointer = (leftPointer + rightPointer) >>> 1; // Unsigned shift right operation
            if (target <= nums[middlePointer]) { //目标小于等于中间值，右指针移到中间再减一
                rightPointer = middlePointer - 1;
            } else { //目标大于中间值，左指针移到中间再加一
                leftPointer = middlePointer + 1;
            }
        }

        return leftPointer;
    }

}
