package cm.xxx.minos.leetcode;


import com.alibaba.fastjson.JSON;

/**
 * 删除链表中的节点
 * 解题思路：
 *  1. 递归写法
 *
 * Author: lishangmin
 * Created: 2018-08-23 10:16
 */
public class Solution67 {

    public ListNode removeElements(ListNode head, int val) {
        if (head == null) return null;
        head.next = removeElements(head.next,val);
        return head.val == val ? head.next:head;
    }

    public static void main(String[] args) {
        Solution67 solution = new Solution67();

        MyLinkedList myLinkedList = new MyLinkedList();
        myLinkedList.addAtHead(2);
        myLinkedList.addAtHead(2);
        myLinkedList.addAtHead(3);
        myLinkedList.addAtHead(4);
        myLinkedList.addAtHead(2);
        myLinkedList.addAtHead(5);
        myLinkedList.addAtHead(6);

        System.out.println(JSON.toJSONString(solution.removeElements(myLinkedList.getDummyHead().next,2)));

    }

}
