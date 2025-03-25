package DataStructure.Heap;

import java.util.Arrays;

/**
 * 大顶堆实现
 */
public class MaxHeap {

    private int[] array;
    private int size;

    public MaxHeap(int capacity) {
        array = new int[capacity];
    }

    public MaxHeap(int[] array) {
        this.array = array;
        this.size = array.length;
        heapify();
    }

    /**
     * 查看堆顶元素
     * @return 堆顶元素
     */
    public int peek() {
        return array[0];
    }

    /**
     * 删除堆顶元素
     * @return 堆顶元素
     */
    public int poll() {
        int top = array[0];
        swap(0, size - 1);
        size--;
        down(0);
        return top;
    }

    /**
     * 删除指定索引的元素
     * @param index 要删除的元素的索引
     * @return 被删除的元素
     */
    public int poll(int index) {
        int deleted = array[index];
        swap(index, size - 1);
        size--;
        down(index);
        return deleted;
    }

    /**
     * 替换堆顶元素
     * @param element 新元素
     */
    public void replace(int element) {
        array[0] = element;
        down(0);
    }

    public boolean offer(int element) {
        if (size == array.length) {
            return false;
        }
        up(element);
        size++;
        return true;
    }

    public void sort() {
        while (size > 0) {
            swap(0, size - 1);
            size--;
            down(0);
        }
    }

    /*
        私有方法分割线 ----------------------------------------------------------
     */

    /**
     * 上浮方法，添加新元素时使用
     * @param element
     */
    private void up(int element) {
        // child的索引值在尾部
        int child = size;
        while (child > 0) {
            // 计算父节点的索引
            int parent = (child - 1) / 2;
            // 对比新增元素和父节点的值
            if (element > array[parent]) { // 如果新增元素的值大于父节点的值就要交换位置
                // 把较大的换上去
                array[child] = array[parent];
            } else { //如果新增元素的值没有比它的父节点的值大，则推出循环
                break;
            }
            child = parent;
        }

        array[child] = element;
    }

    /**
     * 建堆
     */
    private void heapify(){
        //找到最后一个非叶子节点，计算索引值的公式size / 2-1
        for (int i = size / 2 - 1; i >= 0 ; i--) {
            down(i);
        }
    }

    /**
     * 下潜方法
     * @param parent 需要下潜的元素
     */
    private void down(int parent) {
        // 左子节点索引值
        int left = parent * 2 + 1;
        // 右子节点索引值
        int right = parent * 2 + 2;
        // 元素值更大的索引
        // 刚开始先用传过来的parent作为初始值
        int max = parent;

        // 如果左子节点的索引值是有效的，并且左子节点的值大于父节点的值，则交换位置
        if(left < size && array[left] > array[max]) {
            max = left;
        }

        // 如果右子节点的索引值是有效的，并且右子节点的值大于父节点的值，则交换位置
        if (right < size && array[right] > array[max]) {
            max = right;
        }

        //找到了更大的子节点
        if (max != parent) {
            swap(max, parent);
            //递归调用，继续下潜
            down(max);
        }
    }

    /**
     * 交换两个索引的元素
     * @param a 元素A
     * @param b 元素B
     */
    private void swap(int a, int b) {
        int temp = array[a];
        array[a] = array[b];
        array[b] = temp;
    }

    public void print() {
        System.out.println(Arrays.toString(array));
    }

    public static void main(String[] args) {
/*        MaxHeap maxHeap = new MaxHeap(10);
        maxHeap.print();

        boolean flag = true;
        Scanner scanner = new Scanner(System.in);

        while (flag) {
            System.out.print("Input number: ");
            String line = scanner.nextLine();
            if (line.equals("exit")) {
                flag = false;
            } else {
                int number = 0;
                try {
                    number = Integer.parseInt(line);
                    System.out.println(maxHeap.offer(number));
                } catch (NumberFormatException e) {
                    System.out.println("False to add");
                    System.out.println(e);
                }
            }
            maxHeap.print();
        }*/

        int[] array = {2, 4, 1, 7, 3, 6, 5, 8};
        MaxHeap maxHeap = new MaxHeap(array);
        System.out.println(Arrays.toString(array));
        maxHeap.sort();
        System.out.println(Arrays.toString(array));
    }

}
