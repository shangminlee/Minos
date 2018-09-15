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
public class Solution69 {

    public ListNode oddEvenList(ListNode head) {
        ListNode odd = new ListNode(0);
        ListNode even = new ListNode(0);
        ListNode p1 = odd , p2 = even , pointer = head;
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
        p1.next = even.next;
        return odd.next;
    }

    public static void main(String[] args) {
        Solution69 solution = new Solution69();

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
