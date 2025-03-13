package algorithm.linkedList;

import java.util.PriorityQueue;

/**
 * @author nizy
 * @date 2021/12/12 3:19 下午
 */
public class MergeKLists {

    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> priorityQueue = new PriorityQueue<>(lists.length, (ListNode node1, ListNode node2) -> {
            return node1.val - node2.val;
        });
        ListNode dummyNode = new ListNode(-1);
        ListNode p = dummyNode;
        for (int i = 0; i < lists.length; i++) {
            if(lists[i] != null) {
                priorityQueue.offer(lists[i]);
            }
        }
        while(!priorityQueue.isEmpty()) {
            ListNode node = priorityQueue.poll();
            p.next = node;
            if (node.next != null) {
                priorityQueue.offer(node.next);
            }
            p = p.next;
        }
        return dummyNode.next;
    }
}
