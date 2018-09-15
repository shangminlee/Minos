package cm.xxx.minos.leetcode;


/**
 * 环形链表
 * Author: lishangmin
 * Created: 2018-08-23 10:16
 */
public class Solution58 {

    public ListNode detectCycle(ListNode head) {
        if(head == null || head.next == null) return null;
        ListNode slow = head , fast = head;
        boolean isCycle = false;
        while (fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast) {
                System.out.println("slow : " + slow.val);
                System.out.println("fast : " + fast.val);
                isCycle = true;
                break;
            }
        }
        if(!isCycle) return null;

        fast = head;
        while (slow != fast){
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }

    public static void main(String[] args) {
        Solution58 solution = new Solution58();
        MyLinkedList2 myLinkedList2 = new MyLinkedList2();
        myLinkedList2.addAtHead(1);
        myLinkedList2.addAtHead(2);
        myLinkedList2.addAtHead(3);
        myLinkedList2.addAtHead(4);
        myLinkedList2.addAtHead(5);
        myLinkedList2.addAtHead(6);
        myLinkedList2.addAtHead(7);

        System.out.println(solution.detectCycle(myLinkedList2.getHead().next.next).val);

        MyLinkedList myLinkedList = new MyLinkedList();
        myLinkedList.addAtHead(1);
        myLinkedList.addAtHead(2);
        myLinkedList.addAtHead(3);
        myLinkedList.addAtHead(4);

        System.out.println(solution.detectCycle(myLinkedList.getDummyHead()));
    }

}
