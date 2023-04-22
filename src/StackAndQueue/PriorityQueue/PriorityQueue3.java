package StackAndQueue.PriorityQueue;

import StackAndQueue.Priority;

public class PriorityQueue3<E extends Priority> implements Queue<E>{
    private Priority[] array;

    private int size = 0;

    public PriorityQueue3(int capacity){
        array = new Priority[capacity];
    }

    @Override
    public boolean addElement(E element) {
        if (isFull()) return false;
        int child = size;
        int parent = (child - 1) / 2;

        /*
        Compare the child element and the parent element.
        Child element can't greater than the parent element in this case.
        If so, it needs to be change the position until the add element
        is not greater than it's parent
        */
        while(child > 0 && array[parent].priority() < element.priority()){
            array[child] = array[parent];
            child = parent;
            parent = (child - 1) / 2; //This is the formula to get the parent index if knowing the child index.
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
        array[size - 1] = null; // Help GC
        size--;

        //Place element to the right place
        place(0);

        return (E) removedElement;
    }

    private void place(int parent){
        //Get the left child index
        int left = 2 * parent + 1;
        //Get the right child index
        int right = left + 1;
        //Check the priority from parent
        int max = parent;

        //Compare the left and right child priority
        //At the same time, check the bound of left and right indexes, it may out of bound
        if(left < size && array[left].priority() > array[max].priority()) max = left;
        if(right < size && array[right].priority() > array[max].priority()) max = right;

        //Swap place if child greater than parent
        if(max != parent){
            swap(max, parent);
            place(max);
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
        return false;
    }

    @Override
    public boolean isFull() {
        return false;
    }
}
