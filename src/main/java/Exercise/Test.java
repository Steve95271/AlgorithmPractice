package Exercise;

public class Test {
    public static void main(String[] args) {
        A02_AddTwoNumbers addTwoNumbers = new A02_AddTwoNumbers();

        ListNode l1 = new ListNode(2,
                new ListNode(4,
                        new ListNode(3, null)));

        ListNode l2 = new ListNode(5,
                new ListNode(6,
                        new ListNode(4, null)));


        addTwoNumbers.addTwoNumbers(l1, l2);
    }
}

class Test2 {
    public static void main(String[] args) {
        ListNode head = new ListNode(-1, null);
        ListNode tail = new ListNode();

        for (int i = 0; i < 10; i++) {
            ListNode newNode = new ListNode(i, null);

            if (head.val == -1) {
                head = newNode;
            } else {
                tail.next = newNode;
            }

            tail = newNode;

        }
    }
}
