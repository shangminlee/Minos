package cm.xxx.minos;

import lombok.extern.slf4j.Slf4j;

/**
 * Description:
 * Author: lishangmin
 * Created: 2018-08-10 14:33
 */
@Slf4j
public class LinkedQueue<E> implements Queue<E> {

    private class Node<E> {
        private E e;

        private Node<E> next;

        public Node(E e, Node<E> next) {
            this.e = e;
            this.next = next;
        }

        private Node(E e){
            this.e = e;
            this.next = null;
        }

        public Node() {
            this.e = null;
            this.next = null;
        }

    }

    private Node<E> front;

    private Node<E> tail;

    private int size;

    public LinkedQueue() {
        this.front = new Node<>();
        this.tail = front;
        size=0;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void enqueue(E e) {
        Node<E> node = new Node<>(e);
        if(front.next == null){
            front.next = node;
        }
        tail.next = node;
        tail = tail.next;
        size++;
    }

    @Override
    public E dequeue() {
        if(isEmpty()){
            throw new RuntimeException("queue is empty");
        }
        E e = front.next.e;
        front.next = front.next.next;
        size--;
        return e;
    }

    @Override
    public E getFront() {
        if(isEmpty()){
            throw new RuntimeException("queue is empty");
        }
        return front.next.e;
    }

    @Override
    public int getCapacity() {
        return -1;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Node<E> cur = front.next;
        sb.append("front [");
        while (cur != null){
            sb.append(cur.e);
            if(cur.next != null){
                sb.append("->");
            }
            cur = cur.next;
        }
        sb.append("] tail");
        return sb.toString();
    }

    public static void main(String[] args) {
        LinkedQueue<Integer> queue = new LinkedQueue<>();
        for (int i = 0; i < 1; i++) {
            queue.enqueue(i);
        }
        log.info("{}",queue);
        for (int i = 0; i < 1; i++) {
            queue.dequeue();
        }
        log.info("{}",queue);
        queue.enqueue(1);
        queue.dequeue();
    }
}
