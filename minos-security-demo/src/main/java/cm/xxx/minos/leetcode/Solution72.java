package cm.xxx.minos.leetcode;


/**
 * 回文链表
 * 解题思路：
 *  1. 使用栈去解决
 *
 * Author: lishangmin
 * Created: 2018-08-23 10:16
 */
public class Solution72 {

    private class Node {
        public int val;
        public Node prev;
        public Node next;
        public Node child;

        public Node() {}

        public Node(int _val,Node _prev,Node _next,Node _child) {
            val = _val;
            prev = _prev;
            next = _next;
            child = _child;
        }
    }

    public Node flatten(Node head) {
        if(head == null) return null;
        if(head.child == null){
            head.next = flatten(head.next);
        }else {
            Node n = flatten(head.next);
            Node c = head.child;
            head.child = null;
            c = flatten(c);
            c.prev = head;
            Node p = c;
            while (c != null && c.next != null){
                c = c.next;
            }
            c.next = n;
            if(n != null) n.prev = c;
        }
        return head;
    }

    public Node nextOrder(Node next){
        return null;
    }

    public Node childOrder(Node child){
        return null;
    }

    public static void main(String[] args) {

    }

}
