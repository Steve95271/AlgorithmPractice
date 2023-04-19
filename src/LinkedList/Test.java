package LinkedList;

public class Test {
    public static void main(String[] args) {
        SinglyLinkedList list = new SinglyLinkedList();

        list.addFirst(1);
        list.addFirst(2);
        list.addFirst(3);
        list.addFirst(4);
        list.addFirst(5);
        list.addFirst(6);


/*        list.print();

        list.print2(value-> {
            System.out.println(value);
        });*/

        for (Integer value : list){
            System.out.println(value);
        }
    }
}
