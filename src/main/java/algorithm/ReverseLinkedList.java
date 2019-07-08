package algorithm;

import algorithm.structure.LinkedNode;
import algorithm.structure.Node;

public class ReverseLinkedList {

    public static Node reverseLinkedListRecursively(Node node) {
        if (node == null || node.next == null) {
            return node;
        }
        Node next = node.next;
        Node newNode = reverseLinkedListRecursively(node.next);
        next.next = node;
        node.next = null;
        return newNode;
    }

    public static Node reverseLinkedListInRecursively(Node node) {
        Node preNode = null;
        Node nextNode = null;
        while (node != null) {
            nextNode = node.next;
            node.next = preNode;
            preNode = node;
            node = nextNode;
        }
        return preNode;
    }


    public static void main(String[] args) {
        LinkedNode linkedNode = new LinkedNode(new Node("a"));
        linkedNode.add(new Node("b"));
        linkedNode.add(new Node("c"));
        linkedNode.add(new Node("d"));
        linkedNode.add(new Node("e"));
        linkedNode.traverse();
        System.out.println("------------------");
        Node node = reverseLinkedListInRecursively(linkedNode.getHead());
        new LinkedNode(node).traverse();
    }
}
