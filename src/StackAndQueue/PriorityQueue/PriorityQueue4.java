package StackAndQueue.PriorityQueue;

import StackAndQueue.Priority;

public class PriorityQueue4<E extends Priority> implements Queue<E>{
    private Priority[] array;

    private int size = 0;

    public PriorityQueue4(int capacity){
        array = new Priority[capacity];
    }

    @Override
    public boolean addElement(E element) {
        if (isFull()) return false;
        int child = size;
        int parent = (child - 1) / 2;

        // Update the comparison logic here
        while(child > 0 && array[parent].priority() > element.priority()){
            array[child] = array[parent];
            child = parent;
            parent = (child - 1) / 2;
        }
        size++;
        array[child] = element;
        return true;
    }

    @Override
    public E poll() {
        if (isEmpty()) return null;
        swap(0, size-1);
        Priority removedElement = array[size - 1];
        array[size - 1] = null;
        size--;

        //Place element to the right place
        place(0);

        return (E) removedElement;
    }

    private void place(int parent){
        int left = 2 * parent + 1;
        int right = left + 1;
        int min = parent;

        // Update the comparison logic here
        if(left < size && array[left].priority() < array[min].priority()) min = left;
        if(right < size && array[right].priority() < array[min].priority()) min = right;

        if(min != parent){
            swap(min, parent);
            place(min);
        }
    }

    private void swap(int index1, int index2){
        Priority temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }

    @Override
    public E peek() {
        if(isEmpty()) return null;
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
