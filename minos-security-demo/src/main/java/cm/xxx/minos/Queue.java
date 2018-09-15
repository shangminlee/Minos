package cm.xxx.minos;

/**
 * Description: 队列
 * Author: lishangmin
 * Created: 2018-08-06 15:26
 */
public interface Queue<E> {

    // 队列长度
    int getSize();

    // 队列是否为空
    boolean isEmpty();

    // 入列
    void enqueue(E e);

    // 出列
    E dequeue();

    // 获取首个
    E getFront();

    // 队列容量
    int getCapacity();
}
