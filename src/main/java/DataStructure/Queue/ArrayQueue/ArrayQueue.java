package DataStructure.Queue.ArrayQueue;

import DataStructure.Queue.Queue;

import java.util.Iterator;

public class ArrayQueue<E> implements Queue<E>, Iterable<E>{
    private E[] array;
    private int head = 0;
    private int tail = 0;

    @SuppressWarnings("all") //抑制警告
    public ArrayQueue(int capacity) {
        //由于tail指针不存储数据，所以数组的容量需要在期望的容量上加一。
        array = (E[]) new Object[capacity + 1];
    }

    @Override
    public boolean offer(E value) {
        if (isFull()) {
            return false;
        }
        array[tail] = value;
        //添加之后，tail的索引加一，但是要主要，需要套用公式去算索引，避免越界
        //(cur + step) % array.length
        tail = (tail + 1) % array.length;
        return true;
    }

    @Override
    public E poll() {
        if (isEmpty()) {
            return null;
        }
        E value = array[head];
        head = (head + 1) % array.length; //避免越界
        return value;
    }

    @Override
    public E peek() {
        if (isEmpty()) {
            return null;
        }
        return array[head];
    }

    @Override
    public boolean isEmpty() {
        //头指针跟尾指针指向同一个索引，说明数组为空。
        return head == tail;
    }

    @Override
    public boolean isFull() {
        return (tail + 1) % array.length == head;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            int p = head;
            @Override
            public boolean hasNext() {
                return p != tail;
            }

            @Override
            public E next() {
                E value = array[p];
                p = (p + 1) % array.length;
                return value;
            }
        };
    }
}
