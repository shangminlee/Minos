package cm.xxx.minos.leetcode;

import com.alibaba.fastjson.JSON;

/**
 * Description:
 * Author: lishangmin
 * Created: 2018-08-31 14:58
 */
public class MyLinkedList {

    private ListNode dummyHead;

    private int size = 0;

    /** Initialize your data structure here. */
    public MyLinkedList() {
        this.dummyHead = new ListNode(-1,null);
    }

    /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
    public int get(int index) {
        if(index >= size || index < 0) return -1;
        ListNode cur = dummyHead.next;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        return cur.val;
    }

    /** Add a ListNode of value val before the first element of the linked list. After the insertion, the new ListNode will be the first node of the linked list. */
    public void addAtHead(int val) {
        this.addAtIndex(0,val);
    }

    /** Append a node of value val to the last element of the linked list. */
    public void addAtTail(int val) {
        this.addAtIndex(this.size,val);
    }

    /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
    public void addAtIndex(int index, int val) {
        if(index > size || index < 0) return;
        ListNode front = this.dummyHead;
        for (int i = 0; i < index; i++) {
            front = front.next;
        }
        front.next = new ListNode(val,front.next);
        size++;
    }

    /** Delete the index-th node in the linked list, if the index is valid. */
    public void deleteAtIndex(int index) {
        if(index >= size || index < 0) return;
        ListNode front = this.dummyHead;
        for (int i = 0; i < index; i++) {
            front = front.next;
        }
        front.next = front.next.next;
        size--;
    }

    public ListNode getDummyHead() {
        return dummyHead;
    }

    public void setDummyHead(ListNode dummyHead) {
        this.dummyHead = dummyHead;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public static void main(String[] args) {
        MyLinkedList myLinkedList = new MyLinkedList();

        System.out.println(myLinkedList.get(0));


        myLinkedList.addAtHead(1);
        myLinkedList.addAtHead(2);
        myLinkedList.addAtHead(3);

        myLinkedList.addAtTail(1);
        myLinkedList.addAtTail(2);
        myLinkedList.addAtTail(3);


        System.out.println(JSON.toJSONString(myLinkedList));

        myLinkedList.deleteAtIndex(myLinkedList.size);
        System.out.println(JSON.toJSONString(myLinkedList));
        myLinkedList.addAtIndex(4,4);
        System.out.println(JSON.toJSONString(myLinkedList));

        System.out.println(myLinkedList.get(myLinkedList.size -1 ));


    }
}