package cm.xxx.minos;

/**
 * Description:
 * Author: lishangmin
 * Created: 2018-08-10 13:59
 */
public class ArrayStack<E> implements Stack<E> {

    private Array<E> stack;

    private int size;

    public ArrayStack() {
        this.stack = new Array<E>();
        this.size = 0;
    }

    @Override
    public void push(E e) {
        stack.addLast(e);
        size++;
    }

    @Override
    public E pop() {
        if(isEmpty()){
            throw new RuntimeException("stack is empty");
        }
        E e = stack.removeFirst();
        size--;
        return e;
    }

    @Override
    public E peek() {
        if(isEmpty()){
            throw new RuntimeException("stack is empty");
        }
        return stack.get(0);
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public String toString() {
        return "ArrayStack{" +
                "stack=" + stack +
                ", size=" + size +
                '}';
    }
}
