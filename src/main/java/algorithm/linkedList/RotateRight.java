package algorithm.linkedList;

import algorithm.structure.ListNode;

/**
 * https://leetcode-cn.com/problems/rotate-list/
 * @author nizy
 * @date 2021/3/5 10:48 下午
 */
public class RotateRight {

    public ListNode rotateRight(ListNode head, int k) {
        if (head == null) {
            return null;
        }
        ListNode dummyNode = new ListNode(0);
        dummyNode.next = head;
        ListNode leftIndex = head;
        ListNode rightIndex  = head;
        ListNode index  = head;
        int len = 0;
        while (index != null) {
            len ++;
            index = index.next;
        }
        k = k % len;
        if (k == 0) {
            return dummyNode.next;
        }
        while (k > 0) {
            rightIndex = rightIndex.next;
            k--;
        }
        while (rightIndex.next != null) {
            rightIndex = rightIndex.next;
            leftIndex = leftIndex.next;
        }
        rightIndex.next = dummyNode.next;
        dummyNode.next = leftIndex.next;
        leftIndex.next = null;
        return dummyNode.next;
    }
}
