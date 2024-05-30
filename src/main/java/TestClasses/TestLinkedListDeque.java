package TestClasses;

import DataStructure.Queue.DoubleEndedQueue.LinkedListDeque;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class TestLinkedListDeque {

    @Test
    public void test1(){
        LinkedListDeque<Integer> deque = new LinkedListDeque<>(5);
        deque.offerFirst(1);
        deque.offerFirst(2);
        deque.offerFirst(3);
        deque.offerFirst(4);
        deque.offerFirst(5);
        deque.offerFirst(6);
        deque.offerFirst(7);

        Assertions.assertIterableEquals(List.of(5,4,3,2,1), deque);
    }

    @Test
    public void test2() {
        LinkedListDeque<Integer> deque = new LinkedListDeque<>(5);

        deque.offerLast(1);
        deque.offerLast(2);
        deque.offerLast(3);
        deque.offerLast(4);
        deque.offerLast(5);
        deque.offerLast(6);

        for (Integer i : deque) {
            System.out.println(i);
        }

        System.out.println("Poll first: " + deque.pollFirst());
        System.out.println("Poll first: " + deque.pollFirst());
        System.out.println("Poll first: " + deque.pollFirst());
        System.out.println("===========");
        System.out.println("Poll last:" + deque.pollLast());
        System.out.println("Poll last:" + deque.pollLast());
        System.out.println("Poll last:" + deque.pollLast());
    }

}
