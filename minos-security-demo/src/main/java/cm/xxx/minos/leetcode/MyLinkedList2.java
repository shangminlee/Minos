package cm.xxx.minos.leetcode;

import com.alibaba.fastjson.JSON;

/**
 * Description:
 * Author: lishangmin
 * Created: 2018-08-31 14:58
 */
public class MyLinkedList2 {

    private ListNode head;

    public ListNode getHead() {
        return head;
    }

    public void setHead(ListNode head) {
        this.head = head;
    }

    public MyLinkedList2() {
        this.head = new ListNode();
        this.head.next = this.head;
    }

    public void addAtHead(int val) {
        ListNode node = new ListNode(val,this.head.next);
        this.head.next = node;
    }

    public void addAtTail(int val) {
        ListNode cur = this.head;
        while (cur.next != head){
            cur = cur.next;
        }
        ListNode node = new ListNode(val,cur.next);
        cur.next = node;
    }


    public static void main(String[] args) {
        MyLinkedList2 myLinkedList = new MyLinkedList2();
        myLinkedList.addAtHead(1);
        myLinkedList.addAtHead(2);
        System.out.println(JSON.toJSONString(myLinkedList));
    }
}