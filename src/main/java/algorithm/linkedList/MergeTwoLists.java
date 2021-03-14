package algorithm.linkedList;

import algorithm.structure.ListNode;

/**
 * https://leetcode-cn.com/problems/merge-two-sorted-lists/
 *
 * @author nizy
 * @date 2021/3/7 10:13 下午
 */
public class MergeTwoLists {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummyNode = new ListNode();
        ListNode tempNode = dummyNode;
        while (l1 != null && l2 != null) {
            if ((int) l1.val < (int) l2.val) {
                tempNode.next = l1;
                l1 = l1.next;
            } else {
                tempNode.next = l2;
                l2 = l2.next;
            }
            tempNode = tempNode.next;
        }
        while (l1 != null) {
            tempNode.next = l1;
            l1 = l1.next;
            tempNode = tempNode.next;
        }
        while (l2 != null) {
            tempNode.next = l2;
            l2 = l2.next;
            tempNode = tempNode.next;
        }
        return dummyNode.next;
    }
}
