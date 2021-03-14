package algorithm.structure;

/**
 * @author nizy
 * @date 2021/3/5 10:00 下午
 */
public class ListNode<T> {

    public T val;
    public ListNode next;
    public  ListNode() {}
    public ListNode(T val) { this.val = val; }
    public ListNode(T val, ListNode next) { this.val = val; this.next = next; }

    public ListNode setNext(ListNode next) {
        this.next = next;
        return next;
    }

    public ListNode setNext(T val) {
        this.next = new ListNode(val);
        return next;
    }
}
