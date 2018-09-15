package cm.xxx.minos;

/**
 * Description:
 * Author: lishangmin
 * Created: 2018-08-07 10:20
 */
public class CycleQueue<E> implements Queue<E>{

    private E[] data;

    private int head,tail;

    public CycleQueue(int capacity) {
        data = (E[]) new Object[capacity + 1];
        head = 0;
        tail = 0;
    }

    public CycleQueue() {
        data = (E[]) new Object[11];
        head = 0;
        tail = 0;
    }

    @Override
    public int getSize() {
        if(head == (tail + 1) % data.length){
            return data.length - 1;
        }
        if(head > tail){
            return data.length + (tail - head);
        }
        if(head < tail){
            return tail - head;
        }
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return head == tail;
    }

    @Override
    public void enqueue(E e) {
        if(head == (tail + 1) % data.length){
            resize(getCapacity() * 2);
        }
        data[tail] = e;
        tail = (tail + 1)%data.length;
    }

    @Override
    public E dequeue() {
        if(isEmpty()){
            throw new RuntimeException("queue is null");
        }
        E e = data[head];
        data[head] = null;
        head = (head + 1)%data.length;
        if(getSize() == getCapacity()/4 && getCapacity()/2 != 0){
            resize(getCapacity()/2);
        }
        return e;
    }

    @Override
    public E getFront() {
        return data[head];
    }

    @Override
    public int getCapacity() {
        return data.length - 1;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Capacity:").append(getCapacity()).append(" ");
        sb.append("Size:").append(getSize()).append(" ");
        sb.append("Head:").append(head).append(" ");
        sb.append("Tail:").append(tail).append(" ");
        sb.append("length:").append(data.length).append("\n");
        sb.append("[");
        for (int i = head; i != tail ; i = (i + 1)%data.length) {
            sb.append(data[i]);
            if((i + 1) % data.length != tail){
                sb.append(",");
            }
        }
        sb.append("]");
        sb.append("\n");
        sb.append("[");
        for (int i = 0; i < data.length ; i++) {
            if(i == head){
                sb.append(">");
            }
            sb.append(data[i] == null ? "-":data[i]);
            if(i == tail){
                sb.append("<");
            }
            if(i < data.length - 1){
                sb.append(",");
            }
        }
        sb.append("]\n");
        return sb.toString();
    }

    private void resize(int newCapacity){
        E[] newData = (E[]) new Object[newCapacity + 1];
        int size = getSize();
        for (int i = 0 ; i < size ; i++){
            newData[i] = data[(i+head)%data.length];
        }
        data = newData;
        head = 0;
        tail = size;
    }

    public static void main(String[] args) {
        CycleQueue<Integer> cycleQueue = new CycleQueue<>();
        System.out.println(cycleQueue);
        cycleQueue.enqueue(10);
        System.out.println(cycleQueue);
        for (int i = 0 ; i < 9 ; i++){
            cycleQueue.enqueue(i);
        }
        System.out.println(cycleQueue);

        for (int i = 0 ; i < 5 ; i++){
            cycleQueue.dequeue();
        }
        System.out.println(cycleQueue);

        for (int i = 0; i < 11 ; i++) {
            cycleQueue.enqueue(i + 10);
        }
        System.out.println(cycleQueue);

        for (int i = 0; i < 10 ; i++) {
            cycleQueue.dequeue();
        }
        System.out.println(cycleQueue);

        for (int i = 0; i < 8 ; i++) {
            cycleQueue.enqueue(i);
        }
        System.out.println(cycleQueue);

        for (int i = 0; i < 9 ; i++) {
            cycleQueue.dequeue();
        }
        System.out.println(cycleQueue);
    }
}
