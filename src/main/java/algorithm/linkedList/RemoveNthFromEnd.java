package algorithm.linkedList;

import algorithm.structure.ListNode;

/**
 * https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list/
 * @author nizy
 * @date 2021/3/6 2:36 下午
 */
public class RemoveNthFromEnd {

    /**
     * 需要dummy节点
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) {
            return null;
        }
        ListNode node = new ListNode(0);
        node.next = head;
        ListNode index = head;
        ListNode cur = node;
        while (n > 0) {
            index = index.next;
            n--;
        }

        while (index != null) {
            cur = cur.next;
            index = index.next;
        }
        if (cur == null) {
            return null;
        }
        cur.next = cur.next.next;
        return node.next;
    }
}
