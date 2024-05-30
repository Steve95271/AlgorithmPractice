package DataStructure.StackAndQueue.LinkedListQueue;

public class TestLinkedListQueue {
    public static void main(String[] args) {
        /*LinkedListQueue listQueue = new LinkedListQueue<>();
        listQueue.addElement(1);
        listQueue.addElement(4);
        listQueue.addElement(3);
        listQueue.addElement(5);
        listQueue.addElement(2);

        //listQueue.printElement();

        System.out.println(listQueue.peek());*/

        LinkedListQueue queue = new LinkedListQueue<>(3);
        System.out.println(queue.addElement(1));
        System.out.println(queue.addElement(2));
        System.out.println(queue.addElement(3));
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.addElement(4));
        System.out.println(queue.addElement(5));

        queue.printElement();
    }
}
