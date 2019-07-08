package algorithm;

import java.util.Stack;

public class StackToQueue<E> {

    private Stack<E> inStack = new Stack<>();

    private Stack<E> outStack = new Stack<>();

    public E poll() {
        if (!outStack.isEmpty()) {
            return outStack.pop();
        } else if (!inStack.isEmpty()) {
            while (!inStack.isEmpty()) {
                outStack.push(inStack.pop());
            }
            return outStack.pop();
        } else {
            return null;
        }
    }

    public E peek() {
        if (!outStack.isEmpty()) {
            return outStack.peek();
        } else if (!inStack.isEmpty()) {
            while (!inStack.isEmpty()) {
                outStack.push(inStack.pop());
            }
            return outStack.peek();
        } else {
            return null;
        }
    }

    public void traverse() {
        while(!outStack.isEmpty()) {
            System.out.println(outStack.pop());
        }
        while(!inStack.isEmpty()) {
            outStack.push(inStack.pop());
        }
        while(!outStack.isEmpty()) {
            System.out.println(outStack.pop());
        }
    }

    public E push(E item) {
        return inStack.push(item);
    }

    public static void main(String[] args) {
        StackToQueue<String> queue = new StackToQueue<>();
        queue.push("a");
        queue.push("b");
        queue.push("c");
        queue.poll();
        queue.push("a");
        queue.traverse();
    }
}
