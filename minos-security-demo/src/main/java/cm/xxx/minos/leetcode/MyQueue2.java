package cm.xxx.minos.leetcode;


import java.util.Stack;

/**
 * Description: 232. 用栈实现队列
 * Author: lishangmin
 * Created: 2018-09-07 18:40
 */
public class MyQueue2 {

    private Stack<Integer> pushStack,popStack;

    /** Initialize your data structure here. */
    public MyQueue2() {
        this.pushStack = new Stack<>();
        this.popStack  = new Stack<>();
    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        this.pushStack.push(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        if(empty()) return -1;
        if(popStack.isEmpty()) {
            while (!pushStack.isEmpty()) {
                popStack.push(pushStack.pop());
            }
        }
        return popStack.pop();
    }

    /** Get the front element. */
    public int peek() {
        if(empty()) return -1;
        if(popStack.isEmpty()) {
            while (!pushStack.isEmpty()) {
                popStack.push(pushStack.pop());
            }
        }
        return popStack.peek();
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return pushStack.isEmpty() && popStack.isEmpty();
    }

}
