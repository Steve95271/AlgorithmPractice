package Exercise;

public class LeetCode206 {
  static class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }

    public static void main(String[] args) {
        ListNode listNode2 = new ListNode(1,
                new ListNode(2,
                        new ListNode(3,
                                new ListNode(4,
                                        new ListNode(5)))));

        ListNode listNode = reverseList(listNode2);

        while (listNode != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }


    }

    public static ListNode reverseList(ListNode head) {
        ListNode reverseList = null;

        if(head == null) return null;

        while (head != null) {
            ListNode node = new ListNode(head.val, reverseList);
            head = head.next;
            reverseList = node;
        }

        return reverseList;
    }
}
