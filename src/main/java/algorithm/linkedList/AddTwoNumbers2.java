package algorithm.linkedList;


import java.util.Stack;;

/**
 * @author nizy
 * @date 2021/12/1 10:25 下午
 */
public class AddTwoNumbers2 {
    Stack<Integer> stack1 = new Stack<>();
    Stack<Integer> stack2 = new Stack<>();
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        while(l1 != null && l2 != null) {
            stack1.push(l1.val);
            stack2.push(l2.val);
            l1 = l1.next;
            l2 = l2.next;
        }
        while(l1 != null) {
            stack1.push(l1.val);
            l1 = l1.next;
        }
        while(l2 != null) {
            stack2.push(l2.val);
            l2 = l2.next;
        }
        int carry = 0;
        ListNode indexNode = null;

        while(!stack1.isEmpty() || !stack2.isEmpty() || carry != 0) {
            int val1 = stack1.isEmpty() ? 0 : stack1.pop();
            int val2 = stack2.isEmpty() ? 0 : stack2.pop();
            int curValue = (val1 + val2 + carry) % 10;
            carry = (val1 + val2 + carry) / 10;
            ListNode curryNode = new ListNode(curValue);
            curryNode.next = indexNode;
            indexNode = curryNode;
        }
        return indexNode;
    }


    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(7);
        AddTwoNumbers2 add = new AddTwoNumbers2();
;    }
}
