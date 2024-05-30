package DataStructure.StackAndQueue.PriorityQueue;

public class TestPriorityQueue1 {
    public static void main(String[] args) {
        PriorityQueue1<Entry> pq = new PriorityQueue1<>(5);

        pq.addElement(new Entry("Task1", 5));
        pq.addElement(new Entry("Task2", 3));
        pq.addElement(new Entry("Task3", 6));
        pq.addElement(new Entry("Task4", 2));
        pq.addElement(new Entry("Task5", 3));
        pq.addElement(new Entry("Task6", 1));

        System.out.println(pq.poll());
        System.out.println(pq.poll());
        System.out.println(pq.poll());
        System.out.println(pq.poll());
        System.out.println(pq.poll());
        System.out.println(pq.poll());
    }
}
