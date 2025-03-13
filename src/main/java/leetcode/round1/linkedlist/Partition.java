package leetcode.round1.linkedlist;

/**
 * @author nizy
 * @date 2021/12/3 2:27 下午
 */
public class Partition {

    public ListNode partition(ListNode head, int x) {
        ListNode smallDummyNode = new ListNode();
        ListNode largeDummyNode = new ListNode();
        ListNode smallHead = smallDummyNode;
        ListNode largeHead = largeDummyNode;
        smallDummyNode.next = smallHead;
        largeDummyNode.next = largeHead;

        while(head != null) {
            if (head.val >= x) {
                largeHead.next = head;
                largeHead = largeHead.next;
            } else {
                smallHead.next = head;
                smallHead = smallHead.next;
            }
            head.next = head.next;
        }
        largeHead.next = null;
        smallHead.next = largeDummyNode.next;
        return smallDummyNode.next;
    }
}
