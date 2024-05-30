package TestClasses;

import DataStructure.Queue.Entry;
import DataStructure.Queue.PriorityQueue.NoOrderArrayPriorityQueue;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestPriorityQueue1 extends Assertions {

    @Test
    public void test1() {
        NoOrderArrayPriorityQueue<Entry> pq = new NoOrderArrayPriorityQueue<>(5);



        pq.offer(new Entry("Task1", 3));
        pq.offer(new Entry("Task2", 1));
        pq.offer(new Entry("Task3", 4));
        pq.offer(new Entry("Task4", 2));
        pq.offer(new Entry("Task5", 5));

        System.out.println(pq.poll());
        System.out.println(pq.poll());
        System.out.println(pq.poll());
        System.out.println(pq.poll());
        System.out.println(pq.poll());
    }

}
