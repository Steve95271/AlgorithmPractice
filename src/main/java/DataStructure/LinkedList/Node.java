package DataStructure.LinkedList;

public class Node {
    int value;

    Node next;
    Node prev;

    public Node(int value, Node next){
        this.value = value;

        this.next = next;
    }

    public Node (Node prev, int value, Node next) {
        this.prev = prev;
        this.value = value;
        this.next = next;
    }


}
