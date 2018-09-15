package cm.xxx.minos;

/**
 * Description: 栈
 * Author: lishangmin
 * Created: 2018-08-03 10:51
 */
public interface Stack<E> {

    void push(E e);

    E pop();

    E peek();

    int getSize();

    boolean isEmpty();

}
