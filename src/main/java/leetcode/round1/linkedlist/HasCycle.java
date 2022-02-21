package leetcode.round1.linkedlist;

/**
 * @author nizy
 * @date 2021/11/30 6:40 下午
 */
public class HasCycle {

    public boolean hasCycle(ListNode head) {
        ListNode slowNode = head;
        ListNode fastNode = head;
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
