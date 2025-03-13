package algorithm.linkedList;

import algorithm.structure.ListNode;

/**
 * https://leetcode-cn.com/problems/fan-zhuan-lian-biao-lcof/
 * @author nizy
 * @date 2021/3/6 4:29 下午
 */
public class ReverseList {
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode node = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return node;
    }
}
