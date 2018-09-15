package cm.xxx.minos;

/**
 * Description:
 * Author: lishangmin
 * Created: 2018-08-06 15:56
 */
public class LoopQueue<E> implements Queue<E> {

    private E[] data;

    private int front, tail;

    private int size;

    public LoopQueue(int capacity) {
        this.data = (E[]) new Object[capacity + 1];
        this.front = 0;
        this.tail = 0;
        this.size = 0;
    }

    public LoopQueue() {
        this(10);
    }

    @Override
    public int getCapacity(){
        return data.length - 1;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return front == tail;
    }

    @Override
    public void enqueue(E e) {
        if((tail + 1 ) % data.length == front){
            resize(getCapacity() * 2);
        }
        data[tail] = e;
        tail = (tail+1) % data.length;
        size++;
    }

    @Override
    public E dequeue() {
        if (isEmpty()){
            throw new RuntimeException("queue is empty");
        }
        E e = data[front];
        data[front] = null;
        front = (front + 1) % data.length;
        size--;
        if(getCapacity()/4 == size && getCapacity()/2 != 0){
            resize(getCapacity()/2);
        }
        return e;
    }

    @Override
    public E getFront() {
        return data[front];
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append(String.format("Queue: size = %d , capacity = %d\n", size, getCapacity()));
        res.append("front [");
        for(int i = front ; i != tail ; i = (i + 1) % data.length){
            res.append(data[i]);
            if((i + 1) % data.length != tail)
                res.append(", ");
        }
        res.append("] tail");
        return res.toString();
    }

    private void resize(int newCapacity){
        E[] newData = (E[]) new Object[newCapacity + 1];
        for (int i = 0; i < size ; i++) {
            newData[i] = data[(front+i)%data.length];
        }
        front = 0;
        tail = size;
        data = newData;
    }

    public static void main(String[] args) {
        LoopQueue<Integer> queue = new LoopQueue<>();
        for(int i = 0 ; i < 10 ; i ++){
            queue.enqueue(i);
            System.out.println(queue);

            if(i % 3 == 2){
                queue.dequeue();
                System.out.println(queue);
            }
        }
    }
}
