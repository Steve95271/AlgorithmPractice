package Exercise;

/**
 * 删除链表的倒数第 N 个结点
 * <p></p>
 * 给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
 * <p></p>
 * 输入：head = [1,2,3,4,5], n = 2
 * 输出：[1,2,3,5]
 * 示例 2：
 * <p>
 * 输入：head = [1], n = 1
 * 输出：[]
 * 示例 3：
 * <p>
 * 输入：head = [1,2], n = 1
 * 输出：[1]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 链表中结点的数目为 sz
 * 1 <= sz <= 30
 * 0 <= Node.val <= 100
 * 1 <= n <= sz
 */
public class LeetCode19 {

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode sentinel = new ListNode(-1, head);
        recursion(sentinel, n);
        return sentinel.next;
    }

    //递归方法
    /*
        思路：
        返回一个数字表示下一个节点是倒数第几个节点
        例如：
        节点 a -> b -> c -> d -> e
            5    4    3    2    1
        假如，要删除的节点C是倒数第三个节点，节点b的next需要重新指向到节点d。
        由于链表的特性，节点的删除是通知指针重新指向其它节点，
        知道自己是第几个节点是无法把自己删除的，
        此时则需要知道一个节点的下一个节点是倒数第几个节点，
        这样当需要删除的节点是倒数第3个节点c时，节点b的next重新指向到节点d就相当于在链表中删除了节点c。
     */
    private static int recursion(ListNode pointer, int n) {
        if (pointer == null) return 0;
        //nth是下一个倒数节点
        int nth = recursion(pointer.next, n);
        System.out.println(pointer.val + " " + nth);
        if (nth == n) {
            //pointer = 3, pointer.next = 4, pointer.next.next = 5
            pointer.next = pointer.next.next;
        }
        return nth + 1;
    }

    /*
        方法二：快慢指针
     */
    public static ListNode removeNthFromEnd2(ListNode head, int n) {
        ListNode sentinel = new ListNode(-1, head);
        ListNode pointer1 = sentinel;
        ListNode pointer2 = sentinel;
        for (int i = 0; i < n + 1; i++) {
            //pointer2 先移动到n + 1的位置
            pointer2 = pointer2.next;
        }
        //两个指针同时平移，当pointer2到底了，pointer1指向的位置就是要删除的节点的上一个节点
        while (pointer2 != null) {
            pointer2 = pointer2.next;
            pointer1 = pointer1.next;
        }
        //把需要删除的节点从链表的指针中移除
        pointer1.next = pointer1.next.next;
        return sentinel.next;
    }

    public static void main(String[] args) {
        ListNode listNode = new ListNode(
                1, new ListNode(
                2, new ListNode(
                6, new ListNode(
                3, new ListNode(
                4, new ListNode(
                5, new ListNode(
                6, null)))))));

        recursion(listNode, 5);
    }
}
