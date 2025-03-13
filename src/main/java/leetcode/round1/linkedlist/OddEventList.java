package leetcode.round1.linkedlist;

/**
 * @author nizy
 * @date 2021/12/3 2:43 下午
 */
public class OddEventList {

    public ListNode oddEvenList(ListNode head) {
        ListNode evenDummyNode = new ListNode();
        ListNode oddDummyNode = new ListNode();
        ListNode evenHead = evenDummyNode;
        ListNode oddHead = oddDummyNode;
        int count = 0;
        while (head != null) {
            count++;
            if(count % 2 == 0) {
                evenHead.next = head;
                evenHead = evenHead.next;
            } else {
                oddHead.next = head;
                oddHead = oddHead.next;
            }
            head = head.next;
        }
        evenHead.next = null;
        oddHead.next = evenDummyNode.next;
        return oddDummyNode.next;
    }
}
