package algorithm.linkedList;

import algorithm.structure.ListNode;

/**
 * https://leetcode-cn.com/problems/add-two-numbers/
 *
 * @author nizy
 * @date 2021/3/5 9:58 下午
 */
public class AddTwoNumbers {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) {
            return null;
        }
        return add(l1, l2, 0);

    }

//    public ListNode add(ListNode l1, ListNode l2, int carry) {
//        if (l1 == null && l2 == null && carry == 0) {
//            return null;
//        }
//        int val1 = l1 == null ? 0 : l1.val;
//        int val2 = l2 == null ? 0 : l2.val;
//        int curVal = (val1 + val2 + carry) % 10;
//        carry = (val1 + val2 + carry) / 10;
//        ListNode node = new ListNode(curVal);
//        node.next = add(l1 == null ?  null : l1.next, l2 == null ? null : l2.next, val);
//        return node;
//
//    }

    public ListNode add(ListNode l1, ListNode l2, int carry) {
        if (l1 == null && l2 == null) {
            return carry == 0 ? null : new ListNode(carry);
        }
        int v1 = l1 == null ? 0 : (int) l1.val;
        int v2 = l2 == null ? 0 : (int) l2.val;
        int val = v1 + v2 + carry;
        carry = val / 10;
        val = val % 10;
        ListNode listNode = new ListNode(val);
        listNode.next = add(l1 == null ? null : l1.next, l2 == null ? null : l2.next, carry);
        return listNode;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        l1.setNext(4).setNext(3);
        ListNode l2 = new ListNode(5);
        l2.setNext(6).setNext(4);
        System.out.println();
        AddTwoNumbers addTwoNumbers = new AddTwoNumbers();
        addTwoNumbers.addTwoNumbers(l1, l2);

    }

}
