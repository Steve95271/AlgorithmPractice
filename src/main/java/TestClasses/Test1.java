package TestClasses;

import DataStructure.Queue.ArrayQueue.ArrayQueue3;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class Test1 {
        @Test
        public void test() {
            ArrayQueue3<Integer> arrayQueue = new ArrayQueue3<>(5);

            System.out.println(arrayQueue.offer(1));
            System.out.println(arrayQueue.offer(2));
            System.out.println(arrayQueue.offer(3));
            System.out.println(arrayQueue.offer(4));
            System.out.println(arrayQueue.offer(5));
            System.out.println(arrayQueue.offer(6));
            System.out.println(arrayQueue.offer(7));

            Assertions.assertIterableEquals(List.of(1, 2, 3, 4, 5), arrayQueue);

            System.out.println("----------------");

            for (Integer value : arrayQueue) {
                System.out.println(value);
            }

            System.out.println("-----------------");

            System.out.println(arrayQueue.poll());
            System.out.println(arrayQueue.poll());
            System.out.println(arrayQueue.poll());

            System.out.println("-----------------");

            for (Integer value : arrayQueue) {
                System.out.println(value);
            }
        }
}
