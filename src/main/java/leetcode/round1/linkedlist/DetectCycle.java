package leetcode.round1.linkedlist;

/**
 * @author nizy
 * @date 2021/11/30 6:44 下午
 */
public class DetectCycle {

    public ListNode detectCycle(ListNode head) {
        ListNode slowNode = head;
        ListNode fastNode = head;
        while(fastNode != null && fastNode.next != null) {
            slowNode = slowNode.next;
            fastNode = fastNode.next.next;
            if (fastNode == slowNode) {
                break;
            }
        }
        if (fastNode == null || fastNode.next == null) {
            return null;
        }
        slowNode = head;
        while(slowNode != fastNode) {
            slowNode = slowNode.next;
            fastNode = fastNode.next;
        }
        return slowNode;
    }

    public boolean hasCycle(ListNode slowNode, ListNode fastNode) {
        while(fastNode != null && fastNode.next != null) {
            slowNode = slowNode.next;
            fastNode = fastNode.next.next;
            if (fastNode == slowNode) {
                return true;
            }
        }
        return false;
    }
}
