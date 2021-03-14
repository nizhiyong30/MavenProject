package algorithm.linkedList;

import algorithm.structure.ListNode;

/**
 * @author nizy
 * @date 2021/3/7 11:11 上午
 */
public class HasCycle {

    public boolean hasCycle(ListNode head) {
        if (head == null) {
            return false;
        }
        ListNode fastIndex = head;
        ListNode slow =  head;
        while (fastIndex.next != null && fastIndex.next.next != null) {
            fastIndex = fastIndex.next.next;
            slow = slow.next;
            if (fastIndex == slow) {
                return true;
            }
        }
        return false;
    }
}
