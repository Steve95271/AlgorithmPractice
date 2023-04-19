package LinkedList;

import java.util.Iterator;
import java.util.function.Consumer;

public class SinglyLinkedList implements Iterable<Integer> {//迭代器增强循环
    private Node head = null;

    public SinglyLinkedList(){

    }

    public void addFirst(int value){
        head = new Node(value, head);
    }

    

    public void print(){
        Node pointer = head;

        while(pointer != null){
            System.out.println(pointer.value);
            pointer = pointer.next;
        }
    }

    public void print2(Consumer<Integer> consumer){
        Node pointer = head;

        while(pointer != null){
            consumer.accept(pointer.value);
            pointer = pointer.next;
        }
    }

    public Iterator<Integer> iterator(){
        return new Iterator<Integer>() {

            Node pointer = head;

            @Override
            //If has next element, return true
            public boolean hasNext() {
                return pointer != null;
            }

            @Override
            //Return current value and point to next value
            public Integer next() {
                int tempValue = pointer.value;
                pointer = pointer.next;
                return tempValue;
            }
        };
    }
}
