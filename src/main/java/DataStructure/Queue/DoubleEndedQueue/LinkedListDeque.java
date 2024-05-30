package DataStructure.Queue.DoubleEndedQueue;

import DataStructure.Queue.Deque;

import java.util.Iterator;

public class LinkedListDeque<E> implements Deque<E>, Iterable<E> {

    static class Node<E> {
        Node<E> prev;
        E value;
        Node<E> next;

        public Node(Node<E> prev, E value, Node<E> next) {
            this.prev = prev;
            this.value = value;
            this.next = next;
        }
    }

    private int size = 0;
    private int capacity;
    Node<E> sentinel = new Node<>(null, null, null);


    public LinkedListDeque(int capacity) {
        this.capacity = capacity;
        sentinel.prev = sentinel;
        sentinel.next = sentinel;
    }

    @Override
    public boolean offerFirst(E e) {
        if (isFull()) return false;
        Node<E> a = sentinel;
        Node<E> b = sentinel.next;
        Node<E> newNode = new Node<>(a, e, b);
        a.next = newNode;
        b.prev = newNode;
        size++;
        return true;
    }

    // newNode sentinel
    @Override
    public boolean offerLast(E e) {
        if (isFull()) return false;
        Node<E> a = sentinel.prev;
        Node<E> b = sentinel;
        Node<E> newNode = new Node<>(a, e, b);
        a.next = newNode;
        b.prev = newNode;
        size++;
        return true;
    }

    @Override
    public E pollFirst() {
        if (isEmpty()) {
            return null;
        }
        Node<E> first = sentinel.next;
        E value = first.value;
        sentinel.next = first.next;
        size--;
        return value;
    }

    @Override
    public E pollLast() {
        if (isEmpty()) {
            return null;
        }
        Node<E> last = sentinel.prev;
        E value = last.value;
        sentinel.prev = last.prev;
        size--;
        return value;
    }

    @Override
    public E peekFirst() {
        return sentinel.next.value;
    }

    @Override
    public E peekLast() {
        return sentinel.prev.value;
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
            Node<E> pointer = sentinel.next;
            @Override
            public boolean hasNext() {
                return pointer != sentinel;
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
