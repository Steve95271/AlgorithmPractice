package DataStructure.LinkedList;

public class DoublyLinkedList2 {
    public final Node sentinel = new Node(null, -1, null);
    public DoublyLinkedList2 () {
        sentinel.next = sentinel;
        sentinel.prev = sentinel;
    }

    //在环形链表的头部添加节点时，添加在sentinel.next的位置上
    public void addFirst(int value) {
        Node tempNext = sentinel.next;
        Node newNode = new Node(sentinel, value, tempNext);
        tempNext.prev = newNode;
        sentinel.next = newNode;
    }

    //sentinel.prev就是代表最后一个节点，在尾部添加节点，把哨兵的prev指针指向新节点
    public void addLast(int value) {
        Node SentinelPrev = sentinel.prev;
        Node newNode = new Node(SentinelPrev, value, sentinel);
        SentinelPrev.next = newNode;
        sentinel.prev = newNode;

    }


}
