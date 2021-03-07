package algorithm.linkedList;

import algorithm.structure.ListNode;

/**
 * @author nizy
 * @date 2021/3/6 10:55 下午
 */
public class ReverseBetween {

    private ListNode successorNode = null;
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dummyNode = new ListNode();
        dummyNode.next = head;
        ListNode preNode = dummyNode;
        int length = right - left;
        while (left > 1) {
            preNode = preNode.next;
            left--;
        }
       preNode.next = reverse(preNode.next, length);
        return dummyNode.next;
    }

    public ListNode reverse(ListNode node, int length) {
        if(length == 0) {
            successorNode = node.next;
            return node;
        }
        ListNode head = reverse(node.next, length - 1);
        node.next.next = node;
        node.next = successorNode;
        return head;
    }


    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        node.setNext(2).setNext(3).setNext(4).setNext(5);
        ReverseBetween reverseBetween = new ReverseBetween();
        reverseBetween.reverseBetween(node, 2, 4);
    }

}
