/**
 * 来自Bilibili的算法视频课
 */
package StackAndQueue.LinkedListQueue;

public class LinkedListQueue<E> {

    private static class Node<E>{
        private E value;
        private Node<E> next;




        public Node(E value, Node nextNode){
            this.value = value;
            this.next = nextNode;
        }

        public Node(){}
    }

    //Circle link list
    private Node<E> head = new Node<>(null, null);
    //Tail point to the head
    private Node<E> tail = head;

    private int size;
    private int capacity = Integer.MAX_VALUE;

    //Constructor. When created, make tail.nextNode point to the head
    public LinkedListQueue(int capacity){
        tail.next = head;
        this.capacity = capacity;
    }

    public LinkedListQueue(){
        tail.next = head;
    }

    public boolean addElement(E value){
        if (isFull()){
            return false;
        }

        Node newNode = new Node<>(value, head);
        tail.next = newNode;
        tail = newNode;
        size++;

        return true;
    }

    public void printElement(){
        Node<E> pointer = head.next;

        System.out.print("[");
        while(pointer != head){
            System.out.print(pointer.value);
            pointer = pointer.next;
            if (pointer != head){
                System.out.print(", ");
            }
        }
        System.out.print("]");
    }

    public boolean isEmpty(){
        return head == tail;
    }

    /**
     * Get the first element and don't remove it
     * @return The first element
     */
    public E peek(){
        if (isEmpty()){
            return null;
        }

        return head.next.value;
    }

    /**
     * Get the first element and remove it
     * @return The first element
     */
    public E poll(){
        if (isEmpty()) return null;

        Node<E> first = head.next;
        head.next = first.next;
        if (first == tail){
            tail = head;
        }
        size--;
        return first.value;
    }

    public boolean isFull(){
        if (size == capacity) return true;

        return false;
    }
}
