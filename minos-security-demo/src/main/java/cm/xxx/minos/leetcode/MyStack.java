package cm.xxx.minos.leetcode;

/**
 * Description: 225. 用队列实现栈
 * Author: lishangmin
 * Created: 2018-09-07 19:24
 */
public class MyStack {

    private class Node {
        int value;
        Node prev;
        Node next;
        public Node(int value) {
            this.value = value;
        }
    }

    private Node head = new Node(-1);
    private Node tail = new Node(-1);

    private int size;

    /** Initialize your data structure here. */
    public MyStack() {
        this.head.next = this.tail;
        this.tail.prev = this.head;
        this.size = 0;
    }

    /** Push element x onto stack. */
    public void push(int x) {
        Node temp = head.next , node  = new Node(x);
        head.next = node;
        node.next = temp;
        node.prev = head;
        node.next.prev = node;
        ++size;
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        if(empty()) return -1;
        int val = head.next.value;
        head.next = head.next.next;
        head.next.prev = head;
        --size;
        return val;
    }

    /** Get the top element. */
    public int top() {
        return head.next.value;
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return size <= 0;
    }
}
