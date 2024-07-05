package Exercise;

public class Test {
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
