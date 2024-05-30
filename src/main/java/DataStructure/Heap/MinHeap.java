package DataStructure.Heap;

public class MinHeap {

    private int[] array;
    private int size;

    public MinHeap(int capacity) {
        this.array = new int[capacity];
    }

    public boolean offer(int element) {
        if (size == array.length) {
            return false;
        }
        up(element);
        size++;
        return true;
    }

    public void replace(int element) {
        array[0] = element;
        down(0);
    }

    public boolean isFull() {
        return size == array.length;
    }

    /**
     * 把较小的值换上去
     * @param element 新元素
     */
    private void up(int element) {
        // 获取添加元素的索引值
        int child = size;

        while (child > 0) {
            // 计算父节点的索引值
            int parent = (child - 1) / 2;
            // 对比新添元素的值和父节点的值
            if (element < array[parent]) {
                // 小的换上去，大的换下来
                array[child] = array[parent];
            } else { // 如果新元素比父节点大，推出循环
                break;
            }
            // 每次换位置后，更新child的值
            child = parent;
        }

        array[child] = element;
    }

    private void down(int parent) {
        int left = parent * 2 + 1;
        int right = parent * 2 + 2;
        int min = parent;

        if (left < size && array[left] < array[min]) {
            min = left;
        }

        if (right < size && array[right] < array[min]) {
            min = right;
        }

        if (min != parent) {
            swap(min, parent);
            down(min);
        }
    }

    private void swap(int a, int b) {
        int temp = array[a];
        array[a] = array[b];
        array[b] = temp;
    }

    public int peek() {
        return array[0];
    }

}
