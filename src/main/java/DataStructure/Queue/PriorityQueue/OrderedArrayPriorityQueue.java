package DataStructure.Queue.PriorityQueue;

import DataStructure.Queue.Priority;
import DataStructure.Queue.Queue;

public class OrderedArrayPriorityQueue<E extends Priority> implements Queue<E> {
    Priority[] array;
    int size = 0;

    public OrderedArrayPriorityQueue(int capacity) {
        array = new Priority[capacity];
    }

    @Override
    public boolean offer(E value) {
        if (isFull()) return false;
        insert(value);
        size++;
        return true;
    }

    private void insert(E value){
        int i = size - 1;
        while (i >= 0 && array[i].priority() > value.priority()) {
            array[i + 1] = array[i];
            i--;
        }
        array[i + 1] = value;
    }

    @Override
    public E poll() {
        if (isEmpty()) return null;
        E value = (E) array[size - 1];
        array[--size] = null;
        return value;
    }

    @Override
    public E peek() {
        if (isEmpty()) return null;
        return (E) array[size - 1];
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
