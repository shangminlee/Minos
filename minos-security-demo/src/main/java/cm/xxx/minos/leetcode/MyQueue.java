package cm.xxx.minos.leetcode;

/**
 * Description: 232. 用栈实现队列
 * Author: lishangmin
 * Created: 2018-09-07 18:40
 */
public class MyQueue {

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
    public MyQueue() {
        this.head.next = this.tail;
        this.tail.prev = this.head;
        this.size = 0;
    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        Node temp = head.next , node  = new Node(x);
        head.next = node;
        node.next = temp;
        node.prev = head;
        node.next.prev = node;
        ++size;
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        if(empty()) return -1;
        int val = tail.prev.value;
        tail.prev.prev.next = tail;
        tail.prev = tail.prev.prev;
        --size;
        return val;
    }

    /** Get the front element. */
    public int peek() {
        return tail.prev.value;
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return size == 0;
    }

}
