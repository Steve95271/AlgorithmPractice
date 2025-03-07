package DataStructure.Queue.PriorityQueue;

import DataStructure.Queue.Priority;
import DataStructure.Queue.Queue;

public class MaxHeapPriorityQueue<E extends Priority> implements Queue<E> {
    Priority[] array;
    int size = 0;

    public MaxHeapPriorityQueue(int capacity){
        array = new Priority[capacity];
    }

    @Override
    public boolean offer(E value) {
        if (isFull()) return false;

        int child = size + 1;
        int parent = (child - 1) / 2;
        while (child > 0 && value.priority() > array[parent].priority()) {
            array[child] = array[parent];
            child = parent;
            parent = (child - 1) / 2;
        }
        array[child] = value;
        return true;
    }

    @Override
    public E poll() {
        if (isEmpty()) return null;

        swap(0, size - 1);
        E value = (E) array[size - 1];
        array[size - 1] = null; // help GC
        size--;
        shiftDown(0);
        return value;
    }

    private void swap(int a , int b) {
        Priority temp = array[a];
        array[a] = array[b];
        array[b] = temp;
    }

    private void shiftDown(int parent) {
        //左chile的索引
        // Formula for calculate left chile
        // 2 * parent + 1
        int left = 2 * parent + 1;
        //右child的索引
        int right = left + 1;
        int max = parent;

        // left/right < size, means they have to in the range.
        if (left < size && array[left].priority() > array[max].priority()) {
            max = left;
        }

        if (right < size && array[right].priority() > array[max].priority()) {
            max = right;
        }

        // Only there are element prior to parent, then this if condition is true
        if (max != parent) {
            swap(max, parent);
            //递归调用
            shiftDown(max);
        }
    }

    @Override
    public E peek() {
        if (isEmpty()) return null;

        return (E) array[0];
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean isFull() {
        return size == array.length;
    }
}
