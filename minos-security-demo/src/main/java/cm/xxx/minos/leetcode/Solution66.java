package cm.xxx.minos.leetcode;


import com.alibaba.fastjson.JSON;

/**
 * 删除链表中的节点
 * 解题思路：
 *  1. 遍历节点，查找删除
 *
 * Author: lishangmin
 * Created: 2018-08-23 10:16
 */
public class Solution66 {

    public ListNode removeElements(ListNode head, int val) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pointer = dummy;
        while (pointer.next != null){
            if(pointer.next.val == val){
                pointer.next = pointer.next.next;
            }else {
                pointer = pointer.next;
            }
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        Solution66 solution = new Solution66();

        MyLinkedList myLinkedList = new MyLinkedList();
        myLinkedList.addAtHead(2);
//        myLinkedList.addAtHead(2);
//        myLinkedList.addAtHead(3);
//        myLinkedList.addAtHead(4);
//        myLinkedList.addAtHead(2);
//        myLinkedList.addAtHead(5);
        myLinkedList.addAtHead(6);

        System.out.println(JSON.toJSONString(solution.removeElements(myLinkedList.getDummyHead().next,2)));

    }

}
