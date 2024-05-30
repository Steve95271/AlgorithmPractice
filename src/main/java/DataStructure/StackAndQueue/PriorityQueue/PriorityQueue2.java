package DataStructure.StackAndQueue.PriorityQueue;

import DataStructure.StackAndQueue.Priority;

public class PriorityQueue2<E extends Priority> {
    Priority[] array;
    int size;

    public PriorityQueue2(int capacity){
        array = new Priority[capacity];
    }

    public boolean addElement(E e){
        if (isFull()){
            return false;
        }
        insert(e);
        size++;
        return true;
    }

    private void insert(E e){
        int pointer = size - 1;
        while (pointer >= 0 && array[pointer].priority() > e.priority()) {
            array[pointer + 1] = array[pointer];
            pointer--;
        }
        array[pointer + 1] = e;
    }

    public E peek(){
        if (isEmpty()){
            return null;
        }

        return (E) array[size-1]; //Return the last element
    }

    public E poll(){
        if (isEmpty()){
            return null;
        }
        E e = (E) array[size-1];
        array[size-1] = null; //Help GC
        size--;
        return e;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public boolean isFull(){
        return size == array.length;
    }
}
