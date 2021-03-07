package algorithm.linkedList;

import algorithm.structure.ListNode;

/**
 * https://leetcode-cn.com/problems/sort-list/
 *
 * @author nizy
 * @date 2021/3/7 8:22 下午
 */
public class SortList {

    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode fastNode = head;
        ListNode slowNode = head;
        ListNode preNode = null;
        while (fastNode != null && fastNode.next != null) {
            fastNode = fastNode.next.next;
            preNode = slowNode;
            slowNode = slowNode.next;
        }
        //次数需要将左边链表的最后一个节点的next置为Null,否则无法merge无法判断边界条件。
        preNode.next = null;
        ListNode node1 = sortList(head);
        ListNode node2 = sortList(slowNode);
        return merge(node1, node2);
    }

    public ListNode merge(ListNode node1, ListNode node2) {
        ListNode dummyNode = new ListNode();
        ListNode temp = dummyNode;
        while (node1 != null && node2 != null) {
            if ((int) node1.val < (int) node2.val) {
                temp.next = node1;
                node1 = node1.next;
            } else {
                temp.next = node2;
                node2 = node2.next;
            }
            temp = temp.next;
        }
        while (node1 != null) {
            temp.next = node1;
            temp = temp.next;
            node1 = node1.next;
        }
        while (node2 != null) {
            temp.next = node2;
            temp = temp.next;
            node2 = node2.next;
        }
        return dummyNode.next;
    }

    public static void main(String[] args) {
        ListNode listNode = new ListNode(4);
        listNode.setNext(2).setNext(1).setNext(3);
        SortList sortList = new SortList();
        System.out.println(sortList.sortList(listNode));

    }
}
