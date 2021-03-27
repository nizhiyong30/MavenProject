package algorithm.linkedList;

import algorithm.structure.ListNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/reorder-list/
 * @author nizy
 * @date 2021/3/15 12:35 下午
 */
public class ReorderList {

    public void reorderList(ListNode head) {
        List<ListNode> nodes = new ArrayList<>();
        ListNode indexNode = head;
        while (indexNode != null) {
            nodes.add(indexNode);
            indexNode = indexNode.next;
        }
        int start = 0;
        int end = nodes.size() - 1;
        ListNode dummyNode = new ListNode();
        ListNode preNode = dummyNode;
        while (start < end) {
            preNode.next = nodes.get(start);
            preNode = preNode.next;
            preNode.next = nodes.get(end);
            preNode = preNode.next;
            preNode.next = null;
            start++;
            end--;
        }
        if (start == end) {
            preNode.next = nodes.get(start);
            preNode.next.next = null;
        }
        head =  dummyNode.next;
    }

    public static void main(String[] args) {
        System.out.println("hello");
    }
}
