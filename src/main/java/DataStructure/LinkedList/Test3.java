package DataStructure.LinkedList;

public class Test3 {
    public static void main(String[] args) {
        SinglyLinkedList linkedList = new SinglyLinkedList();

        linkedList.addLast(1);
        linkedList.addLast(2);
        linkedList.addLast(3);
        linkedList.addLast(4);
        linkedList.addLast(5);

        for (Integer value : linkedList) {
            System.out.println(value);
        }

        System.out.println("====添加多个元素到尾部");
        linkedList.addLast(6,7,8,9);

        for (Integer value : linkedList) {
            System.out.println(value);
        }
    }
}
