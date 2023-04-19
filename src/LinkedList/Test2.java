package LinkedList;

public class Test2 {
    public static void main(String[] args) {
        DoublyLinkedList list = new DoublyLinkedList<>();

        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        list.addLast(4);
        list.addLast(5);

        list.printElement();
    }
}
