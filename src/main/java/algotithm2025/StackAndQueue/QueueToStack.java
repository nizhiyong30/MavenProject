package algotithm2025.StackAndQueue;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author kelai 2025-03-07 18:32
 */
public class QueueToStack {

    private Queue<Integer> queue1 = new LinkedList<Integer>();
    private Queue<Integer> queue2 = new LinkedList<Integer>();


    public QueueToStack() {

    }

    public void push(int x) {
        queue2.offer(x);
        while(!queue1.isEmpty()) {
            queue2.offer(queue1.poll());
        }

        Queue<Integer> tmpQueue = new LinkedList<Integer>();
        queue1 = queue2;
        queue2 = tmpQueue;

    }

    public int pop() {
        return queue1.poll();
    }

    public int top() {
        return queue1.peek();

    }

    public boolean empty() {
        return queue1.isEmpty();
    }
}
