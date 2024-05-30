package DataStructure.StackAndQueue.PriorityQueue;

public class TestPriorityQueue2 {
    public static void main(String[] args) {
        PriorityQueue2<Entry> pq2 = new PriorityQueue2<>(5);

        System.out.println(pq2.addElement(new Entry("T1", 5)));
        System.out.println(pq2.addElement(new Entry("T2", 1)));
        System.out.println(pq2.addElement(new Entry("T3", 3)));
        System.out.println(pq2.addElement(new Entry("T4", 4)));
        System.out.println(pq2.addElement(new Entry("T5", 2)));

        System.out.println(pq2.poll());
        System.out.println(pq2.poll());
        System.out.println(pq2.poll());
        System.out.println(pq2.poll());
        System.out.println(pq2.poll());
    }
}
