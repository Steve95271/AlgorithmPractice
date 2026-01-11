package Exercise;

public class LeetCode206 {

    private static class List{
        ListNode head;

        public List(ListNode head) {
            this.head = head;
        }

        public void addFirst(ListNode first) {
            first.next = head;
            head = first;
        }

        public ListNode removeFirst() {
            ListNode first = head;
            if (first != null) {
                head = first.next;
            }
            return first;
        }
    }

    public static ListNode reverseListSolutionOne(ListNode head) {
        ListNode reverseList = null;

        if (head == null) return null;

        while (head != null) {
            ListNode node = new ListNode(head.val, reverseList);
            head = head.next;
            reverseList = node;
        }

        return reverseList;
    }

    public static ListNode reverseListSolutionTwo(ListNode head) {
        ListNode revert = null;

        while (head != null) {
            revert = new ListNode(head.val, revert);
            head = head.next;
        }

        return revert;
    }

    public static ListNode reverseListSolutionThree(ListNode head) {

        ListNode temp = head.next;
        ListNode reversedList = head;

        while (temp != null) {
            // 将原链表的节点的next指针指向后一个节点
            head.next = temp.next;
            // temp 节点链入头部
            temp.next = reversedList;
            // 修改reversedList的指针
            reversedList = temp;
            // 更新temp指针
            temp = head.next;
        }

        return reversedList;
    }

    public static ListNode reverseListRecursion(ListNode node) {
        if (node == null || node.next == null) {
            // return last node
            return node;
        }

        ListNode last = reverseListRecursion(node.next);
        // revert the next node
        node.next.next = node;
        // set current node.next to null avoid circular pointer
        node.next = null;

        return last;
    }

    public static void main(String[] args) {
        ListNode list = new ListNode(1,
                new ListNode(2,
                        new ListNode(3,
                                new ListNode(4,
                                        new ListNode(5)))));

//        reverseListSolutionTwo(list);
        ListNode listNode = reverseListRecursion(list);
        System.out.println(listNode.val);
    }
}
