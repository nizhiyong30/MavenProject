package algorithm.linkedList;

import algorithm.structure.Node;

/**
 * @author kelai 2020-06-07 10:24
 */
public class LinkedListWithLoop {

    public static Node meetingNode(Node head) {
        if (head == null) {
            return head;
        }
        Node slowNode = head.next;
        if (slowNode == null) {
            return null;
        }
        Node fastNode = head.next;
        if (fastNode == null) {
            return null;
        }
        while (fastNode != null && slowNode != null) {
            if (fastNode == slowNode) {
                return fastNode;
            }
            slowNode = slowNode.next;
            if (slowNode == null) {
                return null;
            }
            fastNode = fastNode.next;
            if (fastNode == null || fastNode.next == null) {
                return null;
            }
            fastNode = fastNode.next;
        }
        return null;
    }

    public static Node getEntryNodeOfLoop(Node head) {
        if (head == null || head.next == null) {
            return null;
        }
        Node loopNode = meetingNode(head);
        if (loopNode == null) {
            return null;
        }
        Node tmpNode = loopNode;
        loopNode = loopNode.next;
        int count = 1;
        while(tmpNode != loopNode) {
            count++;
            loopNode = loopNode.next;
        }
        Node node1 = head;
        Node node2 = head;
        while(count > 0) {
            count--;
            node1 = node1.next;
        }

        while(node1 != node2) {
            node1 = node1.next;
            node2 = node2.next;
        }
        return node1;

    }

}
