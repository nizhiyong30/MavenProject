package algorithm.structure;

public class LinkedNode {
    private Node head;

    public LinkedNode(Node head) {
        this.head = head;
    }

    public void add(Node node) {
        Node indexNode = head;
        while(indexNode.next != null) {
            indexNode = indexNode.next;
        }
        indexNode.next = node;
    }

    public void traverse() {
        Node node = head;
        while(node != null) {
            System.out.println(node);
            node = node.next;
        }
    }

    public Node getHead() {
        return head;
    }

    public void setHead(Node head) {
        this.head = head;
    }
}
