package leetcode.round1.linkedlist;


/**
 * @author nizy
 * @date 2021/11/29 5:36 下午
 */
public class MergeTwoLists {


        public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
            ListNode dummyNode = new ListNode(-1);
            ListNode p = dummyNode;
            while(list1 != null && list2 != null) {
                while(list1!= null && list2 != null && list1.val <= list2.val) {
                    p.next = list1;
                    list1 = list1.next;
                    p = p.next;
                }
                while(list2 != null && list1 != null && list2.val <= list1.val) {
                    p.next = list2;
                    list2 = list2.next;
                    p = p.next;
                }
            }
            while(list1!= null) {
                p.next = list1;
                list1 = list1.next;
                p = p.next;
            }
            while(list2 != null) {
                p.next = list2;
                list2 = list2.next;
                p = p.next;
            }
            return dummyNode.next;
        }
    }

    class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }
}

