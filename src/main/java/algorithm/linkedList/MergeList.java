package algorithm.linkedList;

/**
 * @author nizy
 * @date 2021/12/3 5:11 下午
 * 链表排序：https://leetcode-cn.com/problems/sort-list/solution/sort-list-gui-bing-pai-xu-lian-biao-by-jyd/
 */
public class MergeList {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode middleNode = getMiddleNode(head);
        ListNode rightHead = middleNode.next;
        // 这步很关键
        middleNode.next = null;
        ListNode left = sortList(head);
        ListNode right = sortList(rightHead);
        return merge(left, right);
    }

    public ListNode getMiddleNode(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode fastNode = head;
        ListNode slowNode = head.next;
        while(fastNode != null && fastNode.next != null) {
            fastNode = fastNode.next.next;
            slowNode = slowNode.next;
        }
        return slowNode;
    }

    public ListNode merge(ListNode left, ListNode right) {
        ListNode dummyNode = new ListNode(-1);
        ListNode headNode = dummyNode;
        while(left != null && right != null) {
            if (left.val <= right.val) {
                headNode.next = left;
                left = left.next;
            } else {
                headNode.next = right;
                right = right.next;
            }
            headNode = headNode.next;
        }
        headNode.next = left == null ? right : left;
        return dummyNode.next;
    }
}
