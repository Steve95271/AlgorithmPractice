package DataStructure.LinkedList;

import java.util.Iterator;
import java.util.function.Consumer;

public class SinglyLinkedList implements Iterable<Integer> {//迭代器增强循环

    private Node head = null;
    private Node tail = null;

    public SinglyLinkedList(){}

    public void addFirst(int value){
        head = new Node(value, head);
    }

    public void addLast(int value) {
        if (head == null) {
            addFirst(value);
        } else {
            Node last = findLast();
            last.next = new Node(value, null);
        }
    }

    /**
     * 往链表尾部添加多个元素
     * @param first 在尾部添加的第一个元素
     * @param rest 在尾部添加的最后一个元素
     */
    public void addLast(int first, int...rest) {
        Node sublist = new Node(first, null);
        Node curr = sublist;

        for (int value : rest) {
            curr.next = new Node(value, null);
            curr = curr.next;
        }

        Node last = findLast();
        if (last == null) {
            head = sublist;
        } else {
            last.next = sublist;
        }
    }

    private Node findLast() {
        if (head == null) return null;

        Node pointer = head;

        while (pointer.next != null) {
            pointer = pointer.next;
        }

        return pointer;
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
