package DataStructure.Queue.PriorityQueue;

import DataStructure.Queue.Priority;
import DataStructure.Queue.Queue;

/**
 * 优先队列 - 无须数组实现
 * @param <E>
 */
public class NoOrderArrayPriorityQueue<E extends Priority> implements Queue<E> {

    private Priority[] array;
    private int size;

    public NoOrderArrayPriorityQueue(int capacity) {
        array = new Priority[capacity];
    }

    @Override
    public boolean offer(E value) {
        if (isFull()) return true;
        //这里的size是后++，意思是赋值以后size才会加一
        array[size++] = value;
        return true;
    }

    @Override
    public E poll() {
       if (isEmpty()) return null;
       //通过selectMax找到优先级最高的索引值
       int max = selectMax();
       //此时获得的就是优先级最高的元素
       E element = (E) array[max];
       remove(max);
       return element;
    }


    @Override
    public E peek() {
        if (isEmpty()) return null;
        return (E) array[selectMax()];
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean isFull() {
        return size == array.length;
    }

    //返回优先级最高的索引值
    private int selectMax() {
        int max = 0;
        for (int i = 0; i < size; i++) {
            if (array[i].priority() > array[max].priority()) {
                max = i;
            }
        }
        return max;
    }

    private void remove(int index) {
        if (index < size -1) {
            System.arraycopy(array, index + 1, array, index, size - 1 - index);
        }
        //size前--，意思是size减一之后再进行数组操作
        array[--size] = null; //help CG
    }
}
