package cm.xxx.minos.leetcode;


import com.alibaba.fastjson.JSON;

import java.util.Stack;

/**
 * 回文链表
 * 解题思路：
 *  1. 使用栈去解决
 *
 * Author: lishangmin
 * Created: 2018-08-23 10:16
 */
public class Solution71 {

    public boolean isPalindrome(ListNode head) {
        Stack<ListNode> stack = new Stack<>();
        ListNode pointer = head;
        while (pointer != null){
            stack.push(pointer);
            pointer = pointer.next;
        }
        while (head != null){
            if(head.val != stack.pop().val) {
                return false;
            }
            head = head.next;
        }
        return true;
    }

    public static void main(String[] args) {
        Solution71 solution = new Solution71();

        MyLinkedList myLinkedList = new MyLinkedList();
        myLinkedList.addAtTail(1);
//        myLinkedList.addAtTail(2);
//        myLinkedList.addAtTail(3);
//        myLinkedList.addAtTail(2);
//        myLinkedList.addAtTail(1);

//        solution.oddEvenList(myLinkedList.getDummyHead().next);

        System.out.println(JSON.toJSONString(solution.isPalindrome(myLinkedList.getDummyHead().next)));

    }

}
