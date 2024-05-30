package DataStructure.Queue.ArrayQueue;

import DataStructure.Queue.Queue;

import java.util.Iterator;

/**
 * Array Queue的第三种实现方式：
 * 在这个版本中head和tail不直接代表索引
 * head和tail是自增的整数，想要获取索引，需要通过莫余数组长度获得
 * @param <E>
 */
public class ArrayQueue3<E> implements Queue<E>, Iterable<E>{
    private int head = 0;
    private int tail = 0;
    private final E[] array;
    private int capacity;

    public ArrayQueue3(int capacity) {
        array = (E[]) new Object[capacity];
    }

    @Override
    public boolean offer(E value) {
        if (isFull()) {
            return false;
        }
        array[tail % array.length] = value;
        tail++;
        return true;
    }

    @Override
    public E poll() {
        if (isEmpty()) {
            return null;
        }
        E value = array[head % array.length];
        head++; //自增，头指针向前移动了一位，相当于移除头部元素
        return value;
    }

    @Override
    public E peek() {
        if (isEmpty()) return null;
        return array[head % array.length];
    }

    @Override
    public boolean isEmpty() {
        return head == tail;
    }

    @Override
    public boolean isFull() {
        return tail - head == array.length;
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
                E value = array[p % array.length];
                p++;
                return value;
            }
        };
    }
}
