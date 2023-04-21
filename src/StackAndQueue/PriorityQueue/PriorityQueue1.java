package StackAndQueue.PriorityQueue;

import StackAndQueue.Priority;

public class PriorityQueue1<E extends Priority>{
    Priority[] array;
    int size;

    public PriorityQueue1(int capacity){
        array = new Priority[capacity];
    }

    public E peek(){
        if(isEmpty()){
            return null;
        }

        int max = selectMax();

        return (E)array[max];
    }

    public E poll(){
        if(isEmpty()){
            return null;
        }

        int max = selectMax();
        E e = (E)array[max];
        remove(max);
        return e;
    }

    public void remove(int index){
        if(index < size -1){
            //移动数组
            System.arraycopy(array, index + 1, array, index, size - 1 - index);
        }
        size--;
    }

    public boolean addElement(E e){
        if(isFull()){
            return false;
        }

        array[size] = e; //在size的这个索引上添加数据
        size++; //添加完数据后增加size

        return true;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public boolean isFull(){
        return size == array.length;
    }

    private int selectMax(){
        int max = 0;
        for (int i = 0; i < size; i++) {
            if (array[i].priority() > array[max].priority()){
                max = i;
            }
        }
        return max;
    }
}
