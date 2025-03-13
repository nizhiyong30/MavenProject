package leetcode.round1.linkedlist;


/**
 * https://leetcode-cn.com/problems/rotate-list/
 *
 * @author nizy
 * @date 2021/3/5 10:48 下午
 */
public class RotateRight {

    public ListNode rotateRight(ListNode head, int k) {
        ListNode dummyNode = new ListNode();
        dummyNode.next = head;
        ListNode fastNode = dummyNode.next;
        ListNode slowNode = dummyNode.next;
        ListNode indexNode = dummyNode.next;
        int length = 0;
        while (indexNode != null) {
            length++;
            indexNode = indexNode.next;
        }
        k = k % length;
        while (fastNode != null && k > 0) {
            fastNode = fastNode.next;
            length++;
            k--;
        }
        while (fastNode != null && fastNode.next != null) {
            fastNode = fastNode.next;
            slowNode = slowNode.next;
        }
        fastNode.next = dummyNode.next;
        dummyNode.next = slowNode.next;
        slowNode.next = null;
        return dummyNode.next;
    }
}
