package Exercise;

public class LeetCode82 {

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }

        ListNode sentinel = new ListNode(-1, head);
        ListNode p1 = sentinel;
        ListNode p2 = sentinel.next;
        ListNode p3 = sentinel.next.next;

        while (p2 != null && p3 != null) {
            if (p2.val == p3.val) {
                p3 = p3.next;
                while (p3 != null && p3.val == p2.val) {
                    p3 = p3.next;
                }
                p1.next = p3;
                p2 = p3;
                p3 = p3.next;
            } else {
                p1 = p1.next;
                p2 = p2.next;
                p3 = p3.next;
            }
        }

        return sentinel.next;
    }

    public static void main(String[] args) {
        ListNode listNode = new ListNode(1, new ListNode(1, null));

        new LeetCode82().deleteDuplicates(listNode);
    }

}
