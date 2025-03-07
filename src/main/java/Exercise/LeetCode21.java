package Exercise;

public class LeetCode21 {

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
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

    ListNode mergeTwoListsRecursion(ListNode list1, ListNode list2) {

        if (list1 == null) {
            return list2;
        } else if (list2 == null) {
            return list1;
        } else if (list1.val < list2.val) {
            list1.next = mergeTwoListsRecursion(list1.next, list2);
            return list1;
        } else {
            list2.next = mergeTwoListsRecursion(list1, list2.next);
            return list2;
        }

    }

}
