package leetcode.round1.linkedlist;

/**
 * @author nizy
 * @date 2021/12/2 6:02 下午
 */
public class ReorderList {


    public void reorderList(ListNode head) {
        if(head == null || head.next == null) {
            return;
        }
        ListNode head1 = head;
        ListNode head2 = null;
        ListNode middle = getMiddle(head2);
        head2 = middle.next;
        head2 = reverse(head2);
        middle.next = null;
        while(head1 != null && head2 != null) {
            ListNode head11 = head1.next;
            ListNode head22 = head2.next;
            head1.next = head2;
            head2.next = head11;
            head1 = head11;
            head2 = head22;
        }
    }


    /**
     * 获取中点或者左中点位置
     * @param head
     * @return
     */
    public ListNode getMiddle(ListNode head) {
        ListNode slowNode = head;
        ListNode fastNode = head.next;
        while(fastNode != null && fastNode.next != null ) {
            slowNode = slowNode.next;
            fastNode = fastNode.next.next;
        }
        return slowNode;
    }

    public ListNode reverse(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode node = reverse(head.next);
        head.next.next = head;
        head.next = null;
        return node;
    }
}
