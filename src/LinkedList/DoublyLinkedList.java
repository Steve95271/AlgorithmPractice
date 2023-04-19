package LinkedList;

public class DoublyLinkedList <E>{
    private static class Node<E>{
        private E element;
        private Node<E> prev;
        private Node<E> next;

        public Node(E e, Node<E> p, Node<E> n){
            element = e;
            prev = p;
            next = n;
        }

        public E getElement(){
            return element;
        }

        public Node<E> getPrev(){
            return prev;
        }

        public Node<E> getNext(){
            return next;
        }

        public void setPrev(Node<E> p){
            prev = p;
        }

        public void setNext(Node<E> n){
            next = n;
        }
    }

    //instance variables of Doublelinkedlist
    private Node<E> header; //header sentinel
    private Node<E> trailer; //trailer sentinel
    private int size = 0; //size of element

    public DoublyLinkedList(){
        header = new Node<>(null, null,null);
        trailer = new Node<>(null, header, null);
        header.setNext(trailer);
    }

}
