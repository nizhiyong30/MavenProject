package algorithm.linkedList;

import algorithm.structure.ListNode;

/**
 * https://leetcode-cn.com/problems/swap-nodes-in-pairs/
 *
 * @author nizy
 * @date 2021/3/5 10:31 下午
 */
public class SwapPairs {

    public ListNode swapPairs(ListNode head) {
        if (head.next == null) {
            return head;
        }
        ListNode curNode = head;
        ListNode nextNode = head.next;

        curNode.next = nextNode.next;
        nextNode.next = curNode;

        head = nextNode;
        ListNode preNode = curNode;
        curNode = curNode.next;

        while (curNode != null && curNode.next != null) {
            nextNode = curNode.next;
            curNode.next = nextNode.next;
            nextNode.next = curNode;
            preNode.next = nextNode;
            preNode = curNode;
            curNode = curNode.next;
        }
        return head;
    }

    public ListNode swapPairs1(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode next = head.next;
        head.next = swapPairs1(next.next);
        next.next = head;
        return next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.setNext(2).setNext(3).setNext(4);
        SwapPairs swapPairs = new SwapPairs();
        swapPairs.swapPairs(head);
    }
}
