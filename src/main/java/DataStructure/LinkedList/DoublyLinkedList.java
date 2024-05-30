package DataStructure.LinkedList;

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

    /**
     * Constructs a new empty list
     */
    public DoublyLinkedList(){
        header = new Node<>(null, null,null);
        trailer = new Node<>(null, header, null);
        header.setNext(trailer);
    }

    /**
     * Returns THe number of elements in the linked list
     */
    public int getSize(){
        return size;
    }

    /**
     * Check whether the linked list is empty
     */
    public boolean isEmpty(){
        return size == 0;
    }

    /**
     *
     * @return the first element of the list
     */
    public E first(){
        if(isEmpty()) return null;
        return header.getNext().getElement();
    }

    /**
     *
     * @return the last element of the list
     */
    public E last(){
        if (isEmpty()){
            return null;
        }else {
            return trailer.getPrev().getElement();
        }
    }

    //Update method

    /**
     * Add element to the front
     * @param e is element that want to add
     */
    public void addFirst(E e){
        addBetween(e, header, header.getNext());
    }

    /**
     * Add element at the end
     * @param e
     */
    public void addLast(E e){
        addBetween(e, trailer.getPrev(), trailer);
    }

    /**
     * Remove and returns the FIRST element of the list
     * @return
     */
    public E removeFirst(){
        if (isEmpty()) return null;
        return remove(header.getNext());
    }

    /**
     * Removes and returns the LAST element of the list
     * @return
     */
    public E removeLast(){
        if(isEmpty()) return null;
        return remove(trailer.getPrev());
    }



    //Private update methods
    /**
     * Adds elements e to the linked list in between the given nodes.
     * @param e
     * @param predecessor
     * @param successor
     */
    private void addBetween(E e, Node<E> predecessor, Node<E> successor) {
        //Create and link a new node
        Node<E> newNode = new Node<>(e, predecessor, successor);
        predecessor.setNext(newNode);
        successor.setPrev(newNode);
        size++;
    }

    /**
     * Revome the given node from the list and return its element
     * @param node
     * @return
     */
    private E remove(Node<E> node){
        Node<E> predecessor = node.getPrev();
        Node<E> successor = node.getNext();
        predecessor.setNext(successor);
        successor.setPrev(predecessor);
        size--;
        return node.getElement();
    }

    /**
     * Print element
     */
    public void printElement(){
        Node pointer = header.next;

        while(pointer != null){
            System.out.println(pointer.getElement());
            pointer = pointer.getNext();
        }
    }



}
