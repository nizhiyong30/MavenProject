package algorithm.linkedList;

import algorithm.structure.ListNode;

import java.util.Queue;

/**
 * https://leetcode-cn.com/problems/linked-list-cycle-ii/
 * 首先找到环中的一个节点，通过该节点，计算环的长度length。
 * 然后分配一个fast指针和slow指针，slow指针先往前移动length步。
 * 然后slow指针和fast指针一起移动，直至两个指针相遇，便是环的入口。
 * 假设fast指针移动length步后，再移动k步到环的入口，此时fast指针再移动n步，便又到了环的入口。
 * slow指针往前移动n步也到了环的入口，此时两个指针刚好相遇。
 * @author nizy
 * @date 2021/3/7 11:50 上午
 */
public class DetectCycle {


    public ListNode detectCycle(ListNode head) {
        ListNode cycleNode = getCycleNode(head);
        if (cycleNode == null) {
            return null;
        }
        int cycleLenght = 1;
        ListNode moveNode = cycleNode.next;
        while (moveNode != cycleNode) {
            moveNode = moveNode.next;
            cycleLenght++;
        }
        ListNode fastIndex = head;
        ListNode slowIndex = head;
        for (int i = 0; i < cycleLenght; i++) {
            fastIndex = fastIndex.next;
        }
        while (fastIndex != slowIndex) {
            fastIndex = fastIndex.next;
            slowIndex =slowIndex.next;
        }
        return fastIndex;
    }

    public ListNode getCycleNode(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode fastIndex = head;
        ListNode slow = head;
        while (fastIndex.next != null && fastIndex.next.next != null) {
            fastIndex = fastIndex.next.next;
            slow = slow.next;
            if (fastIndex == slow) {
                return fastIndex;
            }
        }
        return null;
    }
}
