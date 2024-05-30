package Exercise;

/**
 * 203. 移除链表元素
 * 给你一个链表的头节点 head 和一个整数 val ，请你删除链表中所有满足 Node.val == val 的节点，并返回 新的头节点 。
 */
public class LeetCode203 {
    public static void main(String[] args) {
        ListNode listNode = new ListNode(1, new ListNode(2,new ListNode(6, new ListNode(3, new ListNode(4, new ListNode(5, new ListNode(6)))))));

        removeElements2(listNode, 6);

        while (listNode != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }

    public static ListNode removeElements(ListNode head, int val) {
        ListNode sentinel = new ListNode(-1, head);
        ListNode pointer1 = sentinel;
        ListNode pointer2 = head;
        while (pointer2 != null) {
            if (pointer2.val == val) {
                pointer1.next = pointer2.next;
                pointer2 = pointer2.next;
            } else {
                pointer1 = pointer1.next;
                pointer2 = pointer2.next;
            }
        }

        return sentinel.next;
    }

    public static ListNode removeElements2(ListNode head, int val) {
        if (head == null) {
            return null;
        }

        if (head.val == val) {
            return removeElements2(head.next, val);
        } else {
            head.next = removeElements2(head.next, val);
            return head;
        }
    }

}
