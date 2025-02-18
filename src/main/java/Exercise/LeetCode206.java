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
        List originalList = new List(head);
        List reveredList = new List(null);

        while (true) {
            ListNode first = originalList.removeFirst();
            if (first == null) {
                break;
            }
            reveredList.addFirst(first);
        }

        return reveredList.head;
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
        if (node.next == null) {
            return node;
        }

        ListNode lastNode = reverseListRecursion(node.next);
        // reverse node
        node.next.next = node;
        // set current node's next pointer to null
        // Avoid circular list
        node.next = null;
        return lastNode;
    }

    public static void main(String[] args) {
        ListNode list = new ListNode(1,
                new ListNode(2,
                        new ListNode(3,
                                new ListNode(4,
                                        new ListNode(5)))));

        reverseListRecursion(list);
    }
}
