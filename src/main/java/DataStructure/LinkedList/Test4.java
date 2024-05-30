package DataStructure.LinkedList;

public class Test4 {
    public static void main(String[] args) {
        DoublyLinkedList2 linkedlist = new DoublyLinkedList2();

        linkedlist.addFirst(5);
        linkedlist.addFirst(4);
        linkedlist.addFirst(3);
        linkedlist.addFirst(2);
        linkedlist.addFirst(1);

        Node pointer = linkedlist.sentinel;

        while (pointer.next != linkedlist.sentinel) {
            pointer = pointer.next;
            System.out.println(pointer.value);
        }

        System.out.println("====================");

        linkedlist.addLast(6);
        linkedlist.addLast(7);
        linkedlist.addLast(8);
        linkedlist.addLast(9);
        linkedlist.addLast(10);

        while (pointer.next != linkedlist.sentinel) {
            pointer = pointer.next;
            System.out.println(pointer.value);
        }

    }
}
