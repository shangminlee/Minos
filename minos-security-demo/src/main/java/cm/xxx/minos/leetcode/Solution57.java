package cm.xxx.minos.leetcode;


/**
 * 环形链表
 * Author: lishangmin
 * Created: 2018-08-23 10:16
 */
public class Solution57 {

    public boolean hasCycle(ListNode head) {
        if(head == null) return false;
        ListNode y = head;
        while (y.next != null){
            y = y.next;
            if(y == head) return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Solution57 solution = new Solution57();
        MyLinkedList2 myLinkedList2 = new MyLinkedList2();
        myLinkedList2.addAtHead(1);
        myLinkedList2.addAtHead(2);
        myLinkedList2.addAtHead(3);
        myLinkedList2.addAtHead(4);

        System.out.println(solution.hasCycle(myLinkedList2.getHead()));

        MyLinkedList myLinkedList = new MyLinkedList();
        myLinkedList.addAtHead(1);
        myLinkedList.addAtHead(2);
        myLinkedList.addAtHead(3);
        myLinkedList.addAtHead(4);

        System.out.println(solution.hasCycle(myLinkedList.getDummyHead()));
    }

}
