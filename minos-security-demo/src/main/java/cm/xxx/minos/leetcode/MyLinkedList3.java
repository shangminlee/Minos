package cm.xxx.minos.leetcode;

import com.alibaba.fastjson.JSON;

/**
 * Description: 双链表
 * Author: lishangmin
 * Created: 2018-08-31 14:58
 */
public class MyLinkedList3 {

    private DoublyListNode dummyHead;

    private int size = 0;

    /** Initialize your data structure here. */
    public MyLinkedList3() {
        this.dummyHead = new DoublyListNode(-1,null,null);
    }

    /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
    public int get(int index) {
        if(index >= size || index < 0) return -1;
        DoublyListNode cur = dummyHead.next;
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
        DoublyListNode front = this.dummyHead;
        for (int i = 0; i < index; i++) {
            front = front.next;
        }
        DoublyListNode node = new DoublyListNode(val);
        node.next = front.next;
        front.next = node;
        node.prev = front;
        size++;
    }

    /** Delete the index-th node in the linked list, if the index is valid. */
    public void deleteAtIndex(int index) {
        if(index >= size || index < 0 || dummyHead.next == null) return;
        DoublyListNode front = this.dummyHead;
        for (int i = 0; i < index; i++) {
            front = front.next;
        }
        front.next = front.next.next;
        if(front.next != null)front.next.prev = front;
        size--;
    }

    public DoublyListNode getDummyHead() {
        return dummyHead;
    }

    public void setDummyHead(DoublyListNode dummyHead) {
        this.dummyHead = dummyHead;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public static void main(String[] args) {
        MyLinkedList3 myLinkedList = new MyLinkedList3();

        System.out.println(myLinkedList.get(0));


        myLinkedList.addAtHead(1);
        myLinkedList.addAtHead(2);
        myLinkedList.addAtHead(3);

        myLinkedList.addAtTail(4);



        System.out.println(JSON.toJSONString(myLinkedList.dummyHead));

        myLinkedList.deleteAtIndex(myLinkedList.size - 1);
        System.out.println(JSON.toJSONString(myLinkedList.dummyHead));


    }
}