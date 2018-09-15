package cm.xxx.minos.leetcode;

/**
 * Description: 循环队列
 * Author: lishangmin
 * Created: 2018-09-07 10:19
 */
public class MyCircularQueue1 {

    private int[] queue;

    private int head;

    private int tail;

    private int size;

    /** Initialize your data structure here. Set the size of the queue to be k. */
    public MyCircularQueue1(int k) {
        this.queue = new int[k];
        this.head = 0;
        this.tail = -1;
        this.size = 0;
    }

    /** Insert an element into the circular queue. Return true if the operation is successful. */
    public boolean enQueue(int value) {
        if(isFull()) return false;
        tail = (tail + 1) % queue.length;
        queue[tail] = value;
        ++size;
        return true;
    }

    /** Delete an element from the circular queue. Return true if the operation is successful. */
    public boolean deQueue() {
        if(isEmpty()) return false;
        head = (head + 1) % queue.length;
        --size;
        return true;
    }

    /** Get the front item from the queue. */
    public int Front() {
        if(isEmpty()) return -1;
        return queue[head];
    }

    /** Get the last item from the queue. */
    public int Rear() {
        if(isEmpty()) return -1;
        return queue[tail];
    }

    /** Checks whether the circular queue is empty or not. */
    public boolean isEmpty() {
        return size == 0;
    }

    /** Checks whether the circular queue is full or not. */
    public boolean isFull() {
        return size >= queue.length;
    }

    public static void main(String[] args) {
        MyCircularQueue1 queue = new MyCircularQueue1(0);
        System.out.println(queue.enQueue(1));
        System.out.println(queue.enQueue(2));
        System.out.println(queue.enQueue(3));
        System.out.println(queue.enQueue(4));
        System.out.println(queue.Rear());
        System.out.println(queue.isFull());
        System.out.println(queue.deQueue());
        System.out.println(queue.enQueue(4));
        System.out.println(queue.Rear());



    }
}
