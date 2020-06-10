package algorithm.linkedList;

import algorithm.structure.Node;

/**
 * @author kelai 2020-06-07 10:42
 */
public class MergeLinkedList {

    public static Node<Integer> merge(Node<Integer> node1, Node<Integer> node2) {
        if (node1 == null) {
            return node2;
        } else if(node2 == null) {
            return node1;
        }
        Node mergeNode = null;
        if (node1.value <= node2.value) {
            mergeNode = node1;
        } else {
            mergeNode = node2;
        }
        Node head = mergeNode;
        while (node1 != null && node2 != null) {
            while(node1 != null && node1.value <= node2.value) {
                mergeNode.next = node1.next;
                node1 = node1.next;
            }
            while(node1 != null && node2.value <= node1.value) {
                mergeNode.next = node2;
                node2 = node2.next;
            }
        }
        while(node1 != null) {
            mergeNode.next = node1;
        }
        while(node2 != null) {
            mergeNode.next = node2;
        }
        return head;
    }

    public static Node mergeRecursive(Node<Integer> node1, Node<Integer> node2) {
        if (node1 == null) {
            return node2;
        } else if(node2 == null) {
            return node1;
        }
        Node mergeLinkedListNode = null;
        if (node1.value <= node2.value) {
            mergeLinkedListNode = node1;
            mergeLinkedListNode.next = mergeRecursive(node1.next, node2);
        } else {
            mergeLinkedListNode = node2;
            mergeLinkedListNode.next = mergeRecursive(node2.next, node2);
        }
        return mergeLinkedListNode;
    }
}
