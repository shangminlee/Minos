package cm.xxx.minos.leetcode;

/**
 * Description: 设计循环双端队列
 * Author: lishangmin
 * Created: 2018-09-07 11:23
 */
public class MyCircularDeque1 {

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

    private int capacity;

    private int size;

    /** Initialize your data structure here. Set the size of the deque to be k. */
    public MyCircularDeque1(int k) {
        this.head.next = this.tail;
        this.tail.prev = this.head;
        this.capacity = k;
        this.size = 0;
    }

    /** Adds an item at the front of Deque. Return true if the operation is successful. */
    public boolean insertFront(int value) {
        if(isFull()) return false;
        Node node = new Node(value), temp = head.next;
        head.next = node;
        node.prev = head;
        node.next = temp;
        node.next.prev = node;
        ++size;
        return true;
    }

    /** Adds an item at the rear of Deque. Return true if the operation is successful. */
    public boolean insertLast(int value) {
        if(isFull()) return false;
        Node node = new Node(value), temp = tail.prev;
        tail.prev = node;
        node.next = tail;
        node.prev = temp;
        node.prev.next = node;
        ++size;
        return true;
    }

    /** Deletes an item from the front of Deque. Return true if the operation is successful. */
    public boolean deleteFront() {
        if(isEmpty()) return false;
        head.next = head.next.next;
        head.next.prev = head;
        --size;
        return true;
    }

    /** Deletes an item from the rear of Deque. Return true if the operation is successful. */
    public boolean deleteLast() {
        if(isEmpty()) return false;
        tail.prev = tail.prev.prev;
        tail.prev.next = tail;
        --size;
        return true;
    }

    /** Get the front item from the deque. */
    public int getFront() {
        return head.next.value;
    }

    /** Get the last item from the deque. */
    public int getRear() {
        return tail.prev.value;
    }

    /** Checks whether the circular deque is empty or not. */
    public boolean isEmpty() {
        return size == 0;
    }

    /** Checks whether the circular deque is full or not. */
    public boolean isFull() {
        return size >= capacity;
    }

    public static void main(String[] args) {
        MyCircularDeque1 deque = new MyCircularDeque1(3);
        System.out.println(deque.insertLast(1));
        System.out.println(deque.insertLast(2));
        System.out.println(deque.insertFront(3));
        System.out.println(deque.insertFront(4));
        System.out.println(deque.getRear());
        System.out.println(deque.isFull());
        System.out.println(deque.deleteLast());
        System.out.println(deque.insertFront(4));
        System.out.println(deque.getFront());

    }
}
