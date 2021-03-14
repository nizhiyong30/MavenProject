package algorithm.linkedList;

import algorithm.structure.ListNode;

/**
 *
 * @author nizy
 * @date 2021/3/6 3:44 下午
 */
public class DeleteDuplicates {

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode preNode = head;
        ListNode curNode = head.next;
        while (curNode != null) {
            if (preNode.val == curNode.val) {
                curNode = curNode.next;
                continue;
            }
            if (preNode.next != curNode) {
                preNode.next = curNode;
            }
            preNode = curNode;
            curNode = curNode.next;
        }
        preNode.next = curNode;
        return head;
    }
}
