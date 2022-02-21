package leetcode.round1.linkedlist;

/**
 * @author nizy
 * @date 2021/11/30 1:50 下午
 */
public class RemoveNthFromEnd {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = head;
        ListNode listNode = findFromEnd(head, n + 1);
        listNode.next = listNode.next.next;
        return dummyNode.next;
    }

    public ListNode findFromEnd(ListNode head, int k) {
        ListNode p1 = head;
        ListNode p2 = head;
        int i = 0;
        while (i < k && p1 != null) {
            p1 = p1.next;
            i++;
        }
        while(p1 != null) {
            p1 = p1.next;
            p2 = p2.next;
        }
        return p2;
    }
}

