package cm.xxx.minos.leetcode;

import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;

/**
 * Description: 460. LFU缓存
 * Author: lishangmin
 * Created: 2018-09-06 14:01
 */
@Slf4j
public class LFUCache {

    private class Node{

        int key;

        int value;

        int times;

        Node prev;

        Node next;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
            this.times = 0;
        }

        public Node(int key, int value, int times) {
            this.key = key;
            this.value = value;
            this.times = times;
        }

    }

    private HashMap<Integer,Node> map = new HashMap<>();

    private int capacity;

    private Node head = new Node(-1,-1);

    private Node tail = new Node(-1,-1);

    public LFUCache(int capacity) {
        this.head.next = this.tail;
        this.tail.prev = this.head;
        this.capacity = capacity;
    }

    public int get(int key) {
        if(!map.containsKey(key)) return -1;
        Node cur = map.get(key);
        ++cur.times;
        Node pointer = cur.prev;
        cur.prev.next = cur.next;
        cur.next.prev = cur.prev;
        move(pointer,cur);
        return cur.value;
    }

    public void put(int key, int value) {
        if(capacity == 0) return;
        if(get(key) != -1){
            map.get(key).value = value;
            return;
        }
        if(map.size() >= capacity){
            removeTail();
        }
        Node pointer = this.tail.prev , add = new Node(key,value);
        move(pointer,add);
        map.put(key,add);
    }

    private void move(Node pointer,Node node){
        while (pointer != null && pointer.times <= node.times && pointer != head){
            pointer = pointer.prev;
        }
        Node temp = pointer.next;
        pointer.next = node;
        node.prev = pointer;
        node.next = temp;
        node.next.prev = node;
    }

    private void removeTail(){
        map.remove(tail.prev.key);
        if(this.tail.prev == this.head){
            return;
        }
        this.tail.prev = tail.prev.prev;
        this.tail.prev.next = tail;
    }

    public static void main(String[] args) {
        LFUCache cache = new LFUCache(2);
        log.info(cache.get(2) + "");
        cache.put(2,6);
        log.info(cache.get(1) + "");
        cache.put(1,5);
        cache.put(1,2);

        log.info(cache.get(1) + "");
        log.info(cache.get(2) + "");

        System.out.println("");
        System.out.println("");

        LFUCache cache2 = new LFUCache(2);
        cache2.put(1,1);
        cache2.put(2,2);
        log.info(cache2.get(1) + "");
        cache2.put(3,3);
        log.info(cache2.get(2) + "");
        cache2.put(4,4);
        log.info(cache2.get(1) + "");
        log.info(cache2.get(3) + "");
        log.info(cache2.get(4) + "");
    }

}
