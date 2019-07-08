package algorithm.structure;

public class Node<T> {
    public T value;
    public Node next;

    public Node(T data) {
        this.value = data;
    }

    @Override
    public String toString() {
        return "Node{" +
                "value=" + value +
                '}';
    }
}
