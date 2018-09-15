package cm.xxx.minos;

/**
 * Description: 动态数组
 * Author: lishangmin
 * Created: 2018-08-01 09:20
 */
public class Array<E> {

    private E[] data;

    private int size;

    public Array() {
        this.data = (E[]) new Object[10];
        this.size = 0;
    }

    public Array(int capacity) {
        this.data = (E[]) new Object[capacity];
        this.size = 0;
    }

    public int getSize(){
        return size;
    }

    public int getCapacity(){
        return data.length;
    }

    public boolean contains(int e){
        for (int i = 0 ; i < size ; i++) {
            E anArr = data[i];
            System.out.println(anArr);
            if (anArr.equals(e)) {
                return true;
            }
        }
        return false;
    }

    public int indexOf(int e){
        for (int i = 0 ; i < data.length; i++) {
            if (data[i].equals(e)) {
                return i;
            }
        }
        throw new IllegalArgumentException("not found");
    }

    public E get(int index){
        if(index < 0 || index >= size){
            throw new IllegalArgumentException("out of index");
        }
        return data[index];
    }

    public void add(int index,E e){

        if(index < 0 || index > size){
            throw new IllegalArgumentException("out of index");
        }
        if(size == data.length){
            resize(size * 2);
        }
        for (int i = size - 1 ; i >= index ; i--){
            data[i+1] = data[i];
        }
        data[index] = e;
        size++;
    }

    public E remove(int index){
        if(index < 0 || index >= size){
            throw new IllegalArgumentException("out of index");
        }
        E e = data[index];
        for (int i = index + 1 ; i < size ; i++){
            data[i - 1] = data[i];
        }
        size--;
        data[size] = null;
        if(size == data.length/4 && data.length/2 != 0){
            resize(data.length/2);
        }
        return e;
    }

    public E removeFirst(){
        return remove(0);
    }

    public E removeLast(){
        return remove(size - 1);
    }

    public void addFirst(E e){
        add(0,e);
    }

    public void addLast(E e){
        add(size,e);
    }

    public boolean isEmpty(){
        return size == 0;
    }

    @Override
    public String toString() {
        if (data == null)
            return "null";
        int iMax = size - 1;
        if (iMax == -1)
            return "[]";

        StringBuilder b = new StringBuilder();
        b.append("capacity:").append(getCapacity()).append(",");
        b.append("size:").append(getSize()).append(",");
        b.append('[');
        for (int i = 0; ; i++) {
            b.append(data[i]);
            if (i == iMax)
                return b.append(']').toString();
            b.append(", ");
        }
    }

    public void resize(int newCapacity){
        E[] newArr = (E[]) new Object[newCapacity];
        for (int i = 0 ; i < size ; i++) {
            newArr[i] = data[i];
        }
        data = newArr;
    }

    public static void main(String[] args) throws Exception{
        Array<Integer> array = new Array<>();

        System.out.println(array.toString());

        array.addLast(1);
        array.addLast(2);
        array.addLast(3);
        array.addLast(4);
        array.addLast(5);

        System.out.println(array.toString());

        array.addFirst(8);

        System.out.println(array.toString());

        System.out.println(array.getSize());
        System.out.println(array.contains(4));
        System.out.println(array.contains(9));

        array.remove(0);
        System.out.println(array.toString());

        array.remove(2);
        System.out.println(array.toString());

        array.add(2,3);
        System.out.println(array.toString());

        Array<Integer> reverse = new Array<>();
        for(int i = 0 ; i < 10 ; i++){
            reverse.addFirst(i);
        }
        System.out.println(reverse.toString());
        reverse.add(5,100);

        System.out.println(reverse.toString());
        for(int i = 0 ; i < 10 ; i++) {
            reverse.remove(0);
        }
        System.out.println(reverse.toString());

    }
}
