package newBegin;

import java.util.EmptyStackException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * 用队列实现栈
 */
public class MyStack {

    private Queue<Integer> stackQueue ;
    private Queue<Integer> tmp ;

    /**
     * Initialize your data structure here.
     */
    public MyStack() {
        stackQueue = new LinkedList<>();
        tmp = new LinkedList<>();
    }

    /**
     * Push element x onto stack.
     */
    public void push(int x) {

        stackQueue.offer(x);
    }

    /**
     * Removes the element on top of the stack and returns that element.
     */
    public int pop() {

        if (stackQueue.isEmpty()) {
            throw new EmptyStackException();
        }
        while (stackQueue.size() > 1) {
            tmp.offer(stackQueue.poll());
        }
        int res = stackQueue.poll();
        Queue<Integer> i = stackQueue;
        stackQueue = tmp;
        tmp = i;
        return res;
    }

    /**
     * Get the top element.
     */
    public int top() {

        if (stackQueue.isEmpty()) {
            throw new EmptyStackException();
        }
        int res = 0;
        while (!stackQueue.isEmpty()) {
            res = stackQueue.peek();
            tmp.offer(stackQueue.poll());
        }
        Queue<Integer> i = stackQueue;
        stackQueue = tmp;
        tmp = i;
        return res;
    }

    /**
     * Returns whether the stack is empty.
     */
    public boolean empty() {
        return stackQueue.isEmpty();
    }

    public static void main(String[] args) {

        Stack<Integer> integers = new Stack<>();
        System.out.println(integers.peek());
    }
}
