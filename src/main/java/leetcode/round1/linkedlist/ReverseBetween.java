package leetcode.round1.linkedlist;

import algorithm.structure.ListNode;

/**
 * @author nizy
 * @date 2021/11/30 2:31 下午
 */
public class ReverseBetween {
    private ListNode successorNode = null;
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = head;
        ListNode preNode = dummyNode;
        while(left > 1) {
            preNode = preNode.next;
            left--;
        }
        preNode.next = reverse(preNode.next, right - left);
        return dummyNode.next;
    }

    public ListNode reverse(ListNode head, int length) {
        if (length == 0) {
            successorNode = head.next;
            return head;
        }
        ListNode node = reverse(head.next, length - 1);
        head.next.next = head;
        head.next = successorNode;
        return node;
    }

    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        node.setNext(2).setNext(3).setNext(4).setNext(5);
        algorithm.linkedList.ReverseBetween reverseBetween = new algorithm.linkedList.ReverseBetween();
        reverseBetween.reverseBetween(node, 2, 4);
    }

}
