package cm.xxx.minos.leetcode;


import com.alibaba.fastjson.JSON;

/**
 * 奇偶链表
 * 解题思路：
 *  1. 双指针;
 *
 * Author: lishangmin
 * Created: 2018-08-23 10:16
 */
public class Solution70 {

    public ListNode oddEvenList(ListNode head) {
        if(head == null || head.next == null || head.next.next == null) return head;
        ListNode p1 = head , even = head.next, p2 = even , pointer = p2.next;
        int i = 1;
        while (pointer != null){
            if(i++ % 2 == 1){
                p1.next = pointer;
                p1 = p1.next;
            }else{
                p2.next = pointer;
                p2 = p2.next;
            }
            pointer = pointer.next;
        }
        p2.next = null;
        p1.next = even;
        return head;
    }

    public static void main(String[] args) {
        Solution70 solution = new Solution70();

        MyLinkedList myLinkedList = new MyLinkedList();
        myLinkedList.addAtTail(1);
        myLinkedList.addAtTail(2);
        myLinkedList.addAtTail(3);
        myLinkedList.addAtTail(4);
        myLinkedList.addAtTail(5);

//        solution.oddEvenList(myLinkedList.getDummyHead().next);

        System.out.println(JSON.toJSONString(solution.oddEvenList(myLinkedList.getDummyHead().next)));

    }

}
