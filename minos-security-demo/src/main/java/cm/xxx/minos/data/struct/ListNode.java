package cm.xxx.minos.data.struct;

/**
 * Description:
 * Author: lishangmin
 * Created: 2018-08-12 19:05
 */
public class ListNode<E> {

    public E e;

    public ListNode<E> next;

    public ListNode(E[] arr) {
        if(arr == null){
            throw new IllegalArgumentException("arr is null");
        }
        ListNode<E> cur = this;
        cur.e = arr[0];
        for (int i = 1 ; i < arr.length; i++ ) {
            cur.next = new ListNode<>(arr[i]);
            cur = cur.next;
        }
    }

    public ListNode(E e) {
        this.e = e;
        this.next = null;
    }

    public ListNode(E e , ListNode<E> next){
        this.e = e;
        this.next = next;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        ListNode<E> cur = this;
        sb.append("front [");
        while (cur != null){
            sb.append(cur.e);
            if(cur.next != null){
                sb.append("->");
            }
            cur = cur.next;
        }
        sb.append("] tail");
        return sb.toString();
    }

    public static void main(String[] args) {
        Integer[] arr = {1,2,3,4,5};
        ListNode<Integer> listNode = new ListNode<>(arr);
        System.out.println(listNode);
    }
}
