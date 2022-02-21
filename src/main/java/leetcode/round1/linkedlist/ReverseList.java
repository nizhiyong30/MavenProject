package leetcode.round1.linkedlist;

/**
 * @author nizy
 * @date 2021/11/30 2:17 下午
 */
public class ReverseList {
    public ListNode reverseList(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }
        ListNode node = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return node;
    }
}
