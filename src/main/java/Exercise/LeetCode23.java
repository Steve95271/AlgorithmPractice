package Exercise;

public class LeetCode23 {

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) {
            return null;
        }

        return split(lists, 0, lists.length - 1);
    }

    private ListNode split(ListNode[] lists, int left, int right) {
        //当切分到剩下剩下一个链表的时候，结束递归返回
        if (left == right) {
            //此时left和right都一样，因此数组的索引放哪一个都无所谓
            return lists[left];
        }

        //右移运算，相当于处以二，效率更高
        int mid = left + right >>> 1;

        ListNode leftListNode = split(lists, left, mid);
        ListNode rightListNode = split(lists, mid + 1, right);

        //合并
        return mergeTwoLists(leftListNode, rightListNode);
    }

    private ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode sentinel = new ListNode(-1, null);
        ListNode p = sentinel;

        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                p.next = new ListNode(list1.val, null);
                list1 = list1.next;
            } else {
                p.next = new ListNode(list2.val, null);
                list2 = list2.next;
            }
            p = p.next;
        }

        if (list1 != null) {
            p.next = list1;
        }

        if (list2 != null) {
            p.next = list2;
        }

        return sentinel.next;

    }

}
