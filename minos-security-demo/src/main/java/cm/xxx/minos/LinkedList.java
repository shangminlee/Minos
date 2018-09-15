package cm.xxx.minos;

/**
 * Description:
 * Author: lishangmin
 * Created: 2018-08-07 16:34
 */
public class LinkedList<E> implements Linked<E>{

    private class Node<N>{

        private N item;

        private Node<N> next;

        public Node(N item, Node<N> next) {
            this.item = item;
            this.next = next;
        }

        public Node(N item) {
            this(item,null);
        }

        public Node(){
            this(null,null);
        }

        @Override
        public String toString() {
            return item.toString();
        }
    }

    private Node dummyHead;

    private int size;

    public LinkedList() {
        dummyHead = new Node<E>();
        size = 0;
    }

    @Override
    public int geSize() {
        return size;
    }

    @Override
    public boolean contains(E e) {
        Node cur = dummyHead.next;
        while (cur != null){
            if(cur.item.equals(e)){
                return true;
            }
            cur = cur.next;
        }
        return false;
    }

    @Override
    public void add(int index, E e) {
        if(index < 0 || index > size){
            throw new IllegalArgumentException("index out of size");
        }
        Node prev = dummyHead;
        for (int i = 0; i < index ; i++) {
            prev = prev.next;
        }
        prev.next = new Node<E>(e,prev.next);
        size ++;
    }

    @Override
    public void addFirst(E e) {
        add(0,e);
    }

    @Override
    public void addLast(E e) {
        add(size,e);
    }

    @Override
    public E remove(int index) {
        if(index < 0 || index >= size){
            throw new IllegalArgumentException("index out of size");
        }
        Node prev = dummyHead;
        for (int i = 0; i < index ; i++) {
            prev = prev.next;
        }
        Node<E> ret = prev.next;
        prev.next = ret.next;
        size--;
        return ret.item;
    }

    @Override
    public E removeFirst() {
        return remove(0);
    }

    @Override
    public E removeLast() {
        return remove(size - 1);
    }

    @Override
    public void remove(E e) {
        Node<E> prev = dummyHead.next;
        while (prev != null){
            if(prev.next.item.equals(e)){
                break;
            }
            prev = prev.next;
        }
        if(prev.next != null){
            Node<E> delNode = prev.next;
            prev.next = delNode.next;
            delNode = null;
            size --;
        }
    }

    @Override
    public void set(int index, E e) {
        if(index < 0 || index >= size){
            throw new IllegalArgumentException("index out of size");
        }
        Node<E> cur = dummyHead.next;
        for (int i = 0; i < index ; i++) {
            cur = cur.next;
        }
        cur.item = e;
    }

    @Override
    public E get(int index) {
        if(index < 0 || index >= size){
            throw new IllegalArgumentException("index out of size");
        }
        Node<E> cur = dummyHead.next;
        for (int i = 0; i < index ; i++) {
            cur = cur.next;
        }
        return cur.item;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
//        Node<E> cur = dummyHead.next;
        sb.append("[");
//        while (cur != null){
//            sb.append(cur.item);
//            if(cur.next != null){
//                sb.append("->");
//            }
//            cur = cur.next;
//        }
        for (Node<E> cur = dummyHead.next; cur != null; cur = cur.next) {
            sb.append(cur.item);
            if(cur.next != null){
                sb.append("->");
            }
        }
        sb.append("]");
        return sb.toString();
    }

    public static void main(String[] args) {
        Linked<Integer> linked = new LinkedList<>();
        System.out.println(linked);

        for (int i = 0; i <= 8; i++) {
            linked.addFirst(i);
        }
        System.out.println(linked);

        for (int i = 8; i >= 0; i--) {
            linked.addLast(i);
        }
        System.out.println(linked);

        linked.remove(8);
        System.out.println(linked);
        linked.removeLast();
        System.out.println(linked);
        linked.set(8,10);
        System.out.println(linked);

        System.out.println(linked.contains(602));
    }
}
