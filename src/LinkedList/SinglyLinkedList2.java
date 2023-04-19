package LinkedList;

public class SinglyLinkedList2<E> {
    // nested Node class
    private static class Node<E>{
        //Reference to the element stored at this node
        private E element;
        //Reference to the subsequent node in the list
        private Node<E> next;

        //Add node
        public Node(E e, Node<E> n){
            element = e;
            next = n;
        }

        //Return element
        public E getElement(){
            return element;
        }

        //Return next node
        public Node<E> getNext(){
            return next;
        }

        //Set next node
        public void setNext(Node<E> next){
            this.next = next;
        }
    }


    //Instance variable of the SinglyLinkedList
    private Node<E> head;
    private Node<E> tail;
    private int size = 0;

    //Empty constructor
    public SinglyLinkedList2(){}

    //Access methods
    public int geiSize(){
        return size;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public E getFirst(){  //Return the first element
        if(isEmpty()){
            return null;
        }else {
            return head.getElement();
        }
    }

    public E getLast(){  //Return the last element
        if(isEmpty()){
            return null;
        }else {
            return tail.getElement();
        }
    }

    //Update methods
    public void addFirst(E e){  //adds element e to the front of the list
        head = new Node<>(e, head);  //create and link a new node
        if(size == 0){
            tail = head;
        }
        size++;
    }

    public void addLast(E e){  //add element e to the end of the list
        Node<E> newNode = new Node<>(e, null);  //create and link a new node
        if(isEmpty()){
            head = newNode;
        }else {
            tail.setNext(newNode);  //new node after existing tail
        }
        tail = newNode; //new Node become tail
        size++;
    }

    public E removeFirst(){ //Removes and return the first element
        if(isEmpty()){
            return null;
        }
        E headElement = head.getElement();
        head = head.getNext(); // will become null if list has only one node
        size--;
        if (size == 0);{
            tail = null;
        }
        return headElement;
    }

    public void printElement(){
        Node pointer = head;

        while(pointer != null){
            System.out.println(pointer.element);
            pointer = pointer.next;
        }
    }
}
