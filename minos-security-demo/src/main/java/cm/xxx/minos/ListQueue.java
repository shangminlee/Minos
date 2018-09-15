package cm.xxx.minos;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Description:
 * Author: lishangmin
 * Created: 2018-08-10 16:30
 */
public class ListQueue<E> implements Queue<E> {

    private List<E> queue;

    public ListQueue() {
        this.queue = new ArrayList<E>();
    }

    @Override
    public int getSize() {
        return queue.size();
    }

    @Override
    public boolean isEmpty() {
        return queue.isEmpty();
    }

    @Override
    public void enqueue(E e) {
        queue.add(e);
    }

    @Override
    public E dequeue() {
        E e = queue.get(0);
        queue.remove(0);
        return e;
    }

    @Override
    public E getFront() {
        return queue.get(0);
    }

    @Override
    public int getCapacity() {
        return -1;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Iterator<E> iterator = queue.iterator();
        sb.append("front [");
        while (iterator.hasNext()){
            sb.append(iterator.next());
            if(iterator.hasNext()){
                sb.append(" <- ");
            }
        }
        sb.append("] tail");
        return sb.toString();
    }

    public static void main(String[] args) {
        ListQueue<Integer> listQueue = new ListQueue<>();
        for (int i = 0; i < 10 ; i++) {
            listQueue.enqueue(i);
        }
        System.out.println(listQueue);
    }
}
