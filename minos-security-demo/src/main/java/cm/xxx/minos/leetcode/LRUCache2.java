package cm.xxx.minos.leetcode;

import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;

/**
 * Description: LRU (最近最少使用) 缓存机制。
 * Author: lishangmin
 * Created: 2018-09-05 17:50
 */
@Slf4j
public class LRUCache2 {

    private class Node {
        int key;

        int value;

        Node prev;

        Node next;

        public Node(int key, int value, Node prev, Node next) {
            this.key = key;
            this.value = value;
            this.prev = prev;
            this.next = next;
        }

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private HashMap<Integer,Node> map = new HashMap<>();

    private Node head = new Node(-1,-1);

    private Node tail = new Node(-1,-1);

    private int capacity;

    public LRUCache2(int capacity) {
        this.head.next = this.tail;
        this.tail.prev = this.head;
        this.capacity = capacity;
     }

    public int get(int key) {
        if(!map.containsKey(key)){
            return -1;
        }
        Node node = map.get(key);
        node.prev.next = node.next;
        node.next.prev = node.prev;
        moveToHead(node);
        return node.value;
    }

    public void put(int key, int value) {
        if(this.get(key) != -1){
            map.get(key).value = value;
        }else {
            if(map.size() >= capacity){
                removeTail();
            }
            Node node = new Node(key, value);
            map.put(key, node);
            moveToHead(node);
        }
    }

    private void moveToHead(Node node){
        Node temp = this.head.next;
        this.head.next = node;
        node.next = temp;
        node.prev = this.head;
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
        LRUCache2 cache = new LRUCache2(2);
        log.info(cache.get(2) + "");
        cache.put(2,6);
        log.info(cache.get(1) + "");
        cache.put(1,5);
        cache.put(1,2);

        log.info(cache.get(1) + "");
        log.info(cache.get(2) + "");

        System.out.println("");
        System.out.println("");

        LRUCache2 cache2 = new LRUCache2(2);
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
