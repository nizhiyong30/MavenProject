package algorithm.linkedList;

import algorithm.structure.ListNode;

/**
 * https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list-ii/
 *
 * @author nizy
 * @date 2021/3/6 3:53 下午
 */
public class DeleteDuplicates2 {

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode dummyNode = new ListNode((int) head.val - 1);
        dummyNode.next = head;
        ListNode preNode = dummyNode;
        ListNode curNode = head;
        ListNode nextNode = head.next;
        while (nextNode != null) {
            if (nextNode.val == curNode.val) {
                nextNode = nextNode.next;
                continue;
            }
            if (curNode.next != nextNode) {
                preNode.next = nextNode;
            } else {
                preNode = curNode;
            }
            curNode = nextNode;
            nextNode = curNode.next;
        }
        if (curNode.next != null) {
            preNode.next = nextNode;
        }
        return head;
    }

    public static void main(String[] args) {
        DeleteDuplicates2 deleteDuplicates2 = new DeleteDuplicates2();
        ListNode root = new ListNode(1);
        root.setNext(2).setNext(3).setNext(3).setNext(4).setNext(4).setNext(5);
        System.out.println(deleteDuplicates2.deleteDuplicates(root));
    }
}
