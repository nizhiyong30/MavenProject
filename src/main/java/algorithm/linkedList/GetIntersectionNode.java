package algorithm.linkedList;

/**
 * @author nizy
 * 第160题相交链表：https://leetcode-cn.com/problems/intersection-of-two-linked-lists/
 * @date 2021/11/30 7:11 下午
 */
public class GetIntersectionNode {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode p1 = headA;
        ListNode p2 = headB;
        while(p1 != p2) {
            if(p1 == null){
                p1 = headB;
            } else {
                p1 = p1.next;
            }
            if (p2 == null) {
                p2 = headA;
            } else {
                p2 = p2.next;
            }
        }
        return p1;
    }
  }

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
    }
}
