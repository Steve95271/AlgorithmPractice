package DataStructure.StackAndQueue;

public class SinglyLinkedList<E> {
    //nested Node class
    private static class Node<E> {
        private E element;
        private Node<E> next;
        public Node(E e, Node<E> n) {
            element = e;
            next = n;
        }

        public E getElement() {return element;}

        public Node<E> getNext() {return next;}

        public void setNext(Node<E> n){
            next = n;
        }
    }

    private Node<E> head = null;
    private Node<E> tail = null;
    private int size = 0;

    public SinglyLinkedList() {};

    //Access methods
    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public E first() {
        if (isEmpty()) return null;

        return head.getElement();
    }

    public E last(){
        if (isEmpty()) return null;

        return tail.getElement();
    }

    //update methods
    public void addFirst(E e) {
        head = new Node<>(e, head);
        if (size == 0) tail = head;

        size++;
    }

    public void addLast(E e) {
        Node<E> newElement = new Node<>(e, null);
        if (isEmpty()){
            head = newElement;
        }else {
            tail.setNext(newElement);
        }

        tail = newElement;

        size++;
    }

    public E removeFirst() {
        if(isEmpty()) {return null;}

        E answer = head.getElement();

        head = head.getNext();

        size--;

        if (size == 0) {
            tail = null;
        }

        return answer;
    }
}
