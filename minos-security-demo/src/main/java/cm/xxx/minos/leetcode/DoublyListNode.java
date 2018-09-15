package cm.xxx.minos.leetcode;

/**
 * Description:
 * Author: lishangmin
 * Created: 2018-09-04 00:27
 */
public class DoublyListNode {
    int val;
    DoublyListNode next, prev;
    DoublyListNode(int x) {val = x;}

    public DoublyListNode(int val, DoublyListNode next, DoublyListNode prev) {
        this.val = val;
        this.next = next;
        this.prev = prev;
    }

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }

    public DoublyListNode getNext() {
        return next;
    }

    public void setNext(DoublyListNode next) {
        this.next = next;
    }

    public DoublyListNode getPrev() {
        return prev;
    }

    public void setPrev(DoublyListNode prev) {
        this.prev = prev;
    }
}
