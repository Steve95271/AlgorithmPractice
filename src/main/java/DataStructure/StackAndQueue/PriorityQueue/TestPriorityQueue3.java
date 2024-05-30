package DataStructure.StackAndQueue.PriorityQueue;

public class TestPriorityQueue3 {
    public static void main(String[] args) {
        PriorityQueue3<Entry> pq3 = new PriorityQueue3<>(10);

        System.out.println(pq3.addElement(new Entry("Task1", 6)));
        System.out.println(pq3.addElement(new Entry("Task2", 1)));
        System.out.println(pq3.addElement(new Entry("Task3", 4)));
        System.out.println(pq3.addElement(new Entry("Task4", 3)));
        System.out.println(pq3.addElement(new Entry("Task5", 5)));
        System.out.println(pq3.addElement(new Entry("Task6", 2)));

        System.out.println(pq3.poll());
        System.out.println(pq3.poll());
        System.out.println(pq3.poll());
        System.out.println(pq3.poll());
        System.out.println(pq3.poll());
        System.out.println(pq3.poll());
    }
}
