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
public class Solution68 {

    public ListNode oddEvenList(ListNode head) {
        if (head == null) return head;
        ListNode odd = head , even = head.next , evenHead = even;
        while (odd.next != null && even.next != null){
            odd.next = even.next;
            odd = odd.next;
            even.next = odd.next;
            even = even.next;
        }
        odd.next = evenHead;
        return head;
    }

    public static void main(String[] args) {
        Solution68 solution = new Solution68();

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
