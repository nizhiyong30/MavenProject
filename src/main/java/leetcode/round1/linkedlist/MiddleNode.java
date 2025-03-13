package leetcode.round1.linkedlist;

/**
 * @author nizy
 * @date 2021/11/30 2:08 下午
 */
public class MiddleNode {
    public ListNode middleNode(ListNode head) {
        ListNode fastNode = head;
        ListNode slowNode = head;
        while(fastNode != null && fastNode.next != null) {
            fastNode = fastNode.next.next;
            slowNode = slowNode.next;
        }
        return slowNode;
    }
}
