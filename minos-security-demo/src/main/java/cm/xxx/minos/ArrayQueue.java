package cm.xxx.minos;

import lombok.extern.slf4j.Slf4j;

/**
 * Description: 数组队列
 * Author: lishangmin
 * Created: 2018-08-06 15:31
 */
@Slf4j
public class ArrayQueue<E> implements Queue<E> {

    private Array<E> array;

    public ArrayQueue(int capacity) {
        this.array = new Array<>(capacity);
    }

    public ArrayQueue() {
        this.array = new Array<>();
    }

    @Override
    public int getSize() {
        return array.getSize();
    }

    @Override
    public boolean isEmpty() {
        return array.isEmpty();
    }

    @Override
    public void enqueue(E e) {
        array.addLast(e);
    }

    @Override
    public E dequeue() {
        return array.removeFirst();
    }

    @Override
    public E getFront() {
        return array.get(0);
    }

    @Override
    public int getCapacity() {
        return array.getCapacity();
    }

    @Override
    public String toString(){

        StringBuilder res = new StringBuilder();
        res.append("Queue: ");
        res.append("front [");
        for(int i = 0 ; i < array.getSize() ; i ++){
            res.append(array.get(i));
            if(i != array.getSize() - 1)
                res.append(", ");
        }
        res.append("] tail");
        return res.toString();
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        ArrayQueue<Integer> queue = new ArrayQueue<>();
        for (int i = 0; i < 10000 * 3 ; i++) {
            queue.enqueue(i);
        }
        log.info("spend : {}",System.currentTimeMillis() - start);
        log.info("{}",queue);

        long start_2 = System.currentTimeMillis();
        queue.enqueue(11);
        log.info("spend : {}",System.currentTimeMillis() - start_2);
        log.info("{}",queue);


        long start_3 = System.currentTimeMillis();
        Integer e = queue.dequeue();
        log.info("spend : {}",System.currentTimeMillis() - start_3);
        log.info("{}",e);
        log.info("{}",queue);

        Integer front = queue.getFront();
        log.info("{}",front);
        log.info("{}",queue);
    }
}
