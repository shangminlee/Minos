package cm.xxx.minos;

import java.util.Random;

/**
 * Description:
 * Author: lishangmin
 * Created: 2018-08-06 23:31
 */
public class TestQueue {

    public static void main(String[] args) {
        int count = 500000;
        ArrayQueue<Integer> arrayQueue = new ArrayQueue<>();
        test(arrayQueue,count);
        LoopQueue<Integer> loopQueue = new LoopQueue<>();
        test(loopQueue,count);
        LinkedQueue<Integer> linkedQueue = new LinkedQueue<>();
        test(linkedQueue,count);
        ListQueue<Integer> listQueue = new ListQueue<>();
        test(listQueue,count);

    }

    public static void test(Queue<Integer> queue,int count){
        long start = System.nanoTime();
        Random random = new Random();
        for (int i = 0; i < count; i++) {
            queue.enqueue(random.nextInt(Integer.MAX_VALUE));
        }
        for (int i = 0; i < count; i++) {
            queue.dequeue();
        }
        long end  = System.nanoTime();
        System.out.println("Spend : " + (end - start)/1000000000.0);
    }
}
