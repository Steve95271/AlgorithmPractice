package DataStructure.Stack;

import java.util.Iterator;

public class LinkedListStack<E> implements Stack<E>, Iterable<E>{

    static class Node<E> {
        E value;
        Node<E> next;

        public Node() {
        }

        public Node(E value, Node<E> next) {
            this.value = value;
            this.next = next;
        }
    }

    private final int capacity;
    private int size = 0;

    //head is not store value.
    //head.next is the first value.
    private final Node<E> head = new Node<>(null, null);

    public LinkedListStack(int capacity) {
        this.capacity = capacity;
    }

    @Override
    public boolean push(E value) {
        if (isFull()) {
            return false;
        }
        head.next = new Node<>(value, head.next);
        size++;
        return true;
    }

    @Override
    public E pop() {
        if (isEmpty()) {
            return null;
        }
        Node<E> first = head.next;
        head.next = first.next;
        size--;
        return first.value;
    }

    @Override
    public E peek() {
        if (isEmpty()) {
            return null;
        }
        return head.next.value;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean isFull() {
        return size == capacity;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            Node<E> pointer = head.next;
            @Override
            public boolean hasNext() {
                return pointer != null;
            }

            @Override
            public E next() {
                E value = pointer.value;
                pointer = pointer.next;
                return value;
            }
        };
    }
}
