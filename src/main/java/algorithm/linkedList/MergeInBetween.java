package algorithm.linkedList;

import algorithm.structure.ListNode;

/**
 * @author nizy
 * @date 2021/3/7 12:08 下午
 */
public class MergeInBetween {

    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        ListNode dummyNode = new ListNode();
        dummyNode.next = list1;
        ListNode pre = dummyNode;
        ListNode curNode = list1;
        ListNode curNode2 = list2;
        for (int i = 0; i < a; i++) {
            pre = pre.next;
            curNode = curNode.next;
            a--;
        }
        for (int i = 0; i < b - a; i++) {
            curNode = curNode.next;
        }
        while (curNode2.next != null) {
            curNode2 = curNode2.next;
        }
        pre.next = list2;
        curNode2.next = curNode.next;
        curNode.next = null;
        return dummyNode.next;
    }

    public static void main(String[] args) {
        MergeInBetween mergeInBetween = new MergeInBetween();
        ListNode list1 = new ListNode(0);
        list1.setNext(1).setNext(2).setNext(3).setNext(4).setNext(5);
        ListNode list2 = new ListNode(1000000);
        list2.setNext(1000001).setNext(1000002);
        mergeInBetween.mergeInBetween(list1, 3, 4, list2);
    }

}
