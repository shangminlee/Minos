package cm.xxx.minos;

import lombok.extern.slf4j.Slf4j;

/**
 * Description: 链表栈
 * Author: lishangmin
 * Created: 2018-08-10 13:42
 */
@Slf4j
public class LinkedStack<E> implements Stack<E>{

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

    private Node<E> head;

    private int size;

    public LinkedStack() {
        head = new Node<>();
        size = 0;
    }

    @Override
    public void push(E e) {
        if(isEmpty()){
            head.next = new Node<>(e);
        }else{
            head.next = new Node<>(e,head.next);
        }
        size++;
    }

    @Override
    public E pop() {
        if(isEmpty()){
            throw new RuntimeException("stack is empty");
        }
        Node<E> delNode = head.next;
        E e = delNode.e;
        head.next = delNode.next;
        size--;
        return e;
    }

    @Override
    public E peek() {
        if(isEmpty()){
            throw new RuntimeException("stack is empty");
        }
        return head.next.e;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return head.next == null;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Node<E> cur = head.next;
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
        LinkedStack<Integer> linkedStack = new LinkedStack<>();
        for (int i = 0; i < 10 ; i++) {
            linkedStack.push(i);
        }
        log.info("{}",linkedStack);
        log.info("peek:{}",linkedStack.peek());
        log.info("{}",linkedStack);
        log.info("pop:{}",linkedStack.pop());
        log.info("{}",linkedStack);
        log.info("pop:{}",linkedStack.pop());
        log.info("{}",linkedStack);
    }

}
