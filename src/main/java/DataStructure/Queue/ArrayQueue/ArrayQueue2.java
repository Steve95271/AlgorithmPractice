package DataStructure.Queue.ArrayQueue;

import DataStructure.Queue.Queue;

import java.util.Iterator;

/**
 * 这个版本引入了size去判断空，判断满
 * @param <E>
 */
public class ArrayQueue2<E> implements Queue<E>, Iterable<E>{
    private E[] array;
    private int head = 0;
    private int tail = 0;
    private int size = 0;

    @SuppressWarnings("all") //抑制警告
    public ArrayQueue2(int capacity) {

        array = (E[]) new Object[capacity];
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
        size++;
        return true;
    }

    @Override
    public E poll() {
        if (isEmpty()) {
            return null;
        }
        E value = array[head];
        //原本头索引的元素被删除，所以索引要前移一位。
        head = (head + 1) % array.length; //避免越界
        size--;
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
        return size == 0;
    }

    @Override
    public boolean isFull() {
        return size == array.length;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            int p = head;
            int count = 0;
            @Override
            public boolean hasNext() {
                //当count小于size的时候不断循环
                //当等于的时候退出循环
                return count < size;
            }

            @Override
            public E next() {
                E value = array[p];
                p = (p + 1) % array.length;
                count++;
                return value;
            }
        };
    }
}
