package Exercise;

import org.junit.jupiter.api.Test;

/**
 * 给你一个单链表的头节点 head ，请你判断该链表是否为'回文链表'如果是，返回 true ；否则，返回 false 。
 *
 * 输入：head = [1,2,2,1]
 * 输出：true
 *
 * 输入：head = [1,2]
 * 输出：false
 */
public class LeetCode234_PalindromeLinkedList {

    public boolean isPalindrome(ListNode head) {
        //先用快慢指针的方法找到中间节点
        ListNode middleNode = middleNode(head);
        //反转后半段链表
        middleNode = reverseList(middleNode);
        //比较前半段和反转的后半段的值是否一致
        while (middleNode != null) {
            if (head.val != middleNode.val) {
                return false;
            }

            //更新值
            middleNode = middleNode.next;
            head = head.next;
        }
        return true;
    }


    private ListNode middleNode (ListNode head) {
        ListNode slowPointer = head;
        ListNode quickPointer = head;

        //快指针会先遍历到末尾，因此用快指针来做结束循环的条件
        //当循环结束，慢指针指向的节点就是中间节点
        while (quickPointer != null && quickPointer.next != null) {
            slowPointer = slowPointer.next;
            quickPointer = quickPointer.next.next;
        }

        return slowPointer;
    }

    private ListNode reverseList (ListNode head) {
        ListNode reverseList = null;

        if(head == null) return null;

        while (head != null) {
            ListNode node = new ListNode(head.val, reverseList);
            head = head.next;
            reverseList = node;
        }

        return reverseList;
    }

    /**
     * 性能更好的快慢指针解法。
     * 这个方法在使用快慢指针找中间点的过程中顺便把前半段的原始链表反转。
     * 比起上面的解法，这个方法能省去了反转链表时的遍历。提升了一半的性能
     * 时间复杂度：O(log n)
     * @param head
     * @return
     */
    public boolean isPalindrome2(ListNode head) {

        ListNode quickPointer = head;
        ListNode slowPointer = head;
        ListNode reversedListNode = null;
        ListNode originListNode = head;

        //在使用快慢指针找中间点的过程中顺便把前半段的原始链表反转
        while (quickPointer != null && quickPointer.next != null) {
            //移动快慢指针
            slowPointer = slowPointer.next;
            quickPointer = quickPointer.next.next;

            //反转前半段链表
            ListNode tempNode = new ListNode(originListNode.val, reversedListNode);
            originListNode = originListNode.next;
            reversedListNode = tempNode;

        }

        //判断原始链表的节点是否为奇数
        //如果是奇数，让慢指针更新到下一个节点
        //原因：当链表节点为奇数个时，反转的前半段会比慢指针指向的后半段少了一个节点
        //这样即使是回文链表也一样会返回false，所以需要从中间的后面一个节点开始比较
        if (quickPointer != null) { //快指针指向空，意味着是奇数个节点
            slowPointer = slowPointer.next;
        }

        while (reversedListNode != null) {
            //对反转后的前半段链表和后半段进行比较，看看值是否一致
            if (reversedListNode.val != slowPointer.val) {
                return false;
            }

            //更新到下一个节点
            reversedListNode = reversedListNode.next;
            slowPointer = slowPointer.next;
        }

        return true;


    }

    @Test
    void test() {
        ListNode listNode1 = ListNode.addAll(1, 2, 3, 2, 1);
        ListNode listNode2 = ListNode.addAll(1, 2, 3, 4, 5, 6);

        System.out.println(isPalindrome(listNode1));
        System.out.println(isPalindrome(listNode2));

    }

}
