package cm.xxx.minos.leetcode;

/**
 * Description: 设计循环双端队列
 * Author: lishangmin
 * Created: 2018-09-07 11:23
 */
public class MyCircularDeque {

    private int[] queue;

    private int head;

    private int tail;

    private int size;

    /** Initialize your data structure here. Set the size of the deque to be k. */
    public MyCircularDeque(int k) {
        this.queue = new int[k];
        this.head = -1;
        this.tail = -1;
        this.size = 0;
    }

    /** Adds an item at the front of Deque. Return true if the operation is successful. */
    public boolean insertFront(int value) {
        if(isFull()) return false;
        if(head == -1) {
            queue[++head] = value;
        }else{
            head = (head - 1 + queue.length) % queue.length;
            queue[head] = value;
        }
        if(tail == -1) tail = head;
        ++size;
        return true;
    }

    /** Adds an item at the rear of Deque. Return true if the operation is successful. */
    public boolean insertLast(int value) {
        if(isFull()) return false;
        if(tail == -1){
            queue[++tail] = value;
        }else{
            tail = (tail + 1) % queue.length;
            queue[tail] = value;
        }
        if(head == -1) head = tail;
        ++size;
        return true;
    }

    /** Deletes an item from the front of Deque. Return true if the operation is successful. */
    public boolean deleteFront() {
        if(isEmpty()) return false;
        head = (head + 1) % queue.length;
        --size;
        return true;
    }

    /** Deletes an item from the rear of Deque. Return true if the operation is successful. */
    public boolean deleteLast() {
        if(isEmpty()) return false;
        tail = (tail - 1 + queue.length) % queue.length;
        --size;
        return true;
    }

    /** Get the front item from the deque. */
    public int getFront() {
        if(isEmpty()) return -1;
        return queue[head];
    }

    /** Get the last item from the deque. */
    public int getRear() {
        if(isEmpty()) return -1;
        return queue[tail];
    }

    /** Checks whether the circular deque is empty or not. */
    public boolean isEmpty() {
        return size == 0;
    }

    /** Checks whether the circular deque is full or not. */
    public boolean isFull() {
        return size == queue.length;
    }

    public static void main(String[] args) {
        MyCircularDeque deque = new MyCircularDeque(0);
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
