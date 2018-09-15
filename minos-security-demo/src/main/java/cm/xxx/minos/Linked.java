package cm.xxx.minos;

/**
 * Description:
 * Author: lishangmin
 * Created: 2018-08-07 17:11
 */
public interface Linked<E>  {

    int geSize();

    boolean contains(E e);

    void add(int index, E e);

    void addFirst(E e);

    void addLast(E e);

    E remove(int index);

    E removeFirst();

    E removeLast();

    void remove(E e);

    void set(int index,E e);

    E get(int index);

}
