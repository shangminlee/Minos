package cm.xxx.minos.leetcode;

/**
 * Description: 循环队列
 * Author: lishangmin
 * Created: 2018-09-07 10:19
 */
public class MyCircularQueue2 {

    private int[] queue;

    private int pointer;

    /** Initialize your data structure here. Set the size of the queue to be k. */
    public MyCircularQueue2(int k) {
        this.queue = new int[k];
        this.pointer = -1;
    }

    /** Insert an element into the circular queue. Return true if the operation is successful. */
    public boolean enQueue(int value) {
        if(isFull())return false;
        queue[++pointer] = value;
        return true;
    }

    /** Delete an element from the circular queue. Return true if the operation is successful. */
    public boolean deQueue() {
        if(isEmpty())return false;
        for (int i = 0; i < pointer ; i++) {
            queue[i] = queue[i + 1];
        }
        pointer--;
        return true;
    }

    /** Get the front item from the queue. */
    public int Front() {
        if(isEmpty()) return -1;
        return queue[0];
    }

    /** Get the last item from the queue. */
    public int Rear() {
        if(isEmpty()) return -1;
        return queue[pointer];
    }

    /** Checks whether the circular queue is empty or not. */
    public boolean isEmpty() {
        return pointer == -1;
    }

    /** Checks whether the circular queue is full or not. */
    public boolean isFull() {
        return pointer == queue.length - 1;
    }

    public static void main(String[] args) {
        MyCircularQueue2 queue = new MyCircularQueue2(0);
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
