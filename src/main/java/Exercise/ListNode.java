package Exercise;

public class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public static ListNode addAll(int first, int ...values) {
        ListNode head = new ListNode(first, null);
        ListNode temp = head;

        for (int value : values) {
            temp.next = new ListNode(value, null);
            temp = temp.next;
        }

        return head;
    }

    public void addLast(ListNode node) {
        if (node != null) {
            System.out.println("节点为空，添加失败");
        }
    }
}
