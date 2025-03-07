package Exercise;

import java.util.PriorityQueue;

public class LeetCode23_MinHeap {

    private static class Priority implements Comparable<Priority> {
        int val;
        ListNode node;

        public Priority (int val, ListNode node) {
            this.val = val;
            this.node = node;
        }

        public int compareTo(Priority priority2) {
            return this.val - priority2.val;
        }
    }

    PriorityQueue<Priority> queue = new PriorityQueue<Priority>();

    public ListNode mergeKLists(ListNode[] lists) {
        for (ListNode list : lists) {
            if (list != null) {
                queue.offer(new Priority(list.val, list));
            }
        }

        ListNode sentinel = new ListNode(-1, null);
        ListNode pointer = sentinel;

        while (!queue.isEmpty()) {
            Priority min = queue.poll();
            pointer.next = min.node;
            pointer = pointer.next;
            if (min.node.next != null) {
                queue.offer(new Priority(min.node.next.val, min.node.next));
            }
        }

        return sentinel.next;
    }
}
