package cm.xxx.minos.leetcode;

import lombok.extern.slf4j.Slf4j;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Description: LRU (最近最少使用) 缓存机制。
 * Author: lishangmin
 * Created: 2018-09-05 17:50
 */
@Slf4j
public class LRUCache3 extends LinkedHashMap<Integer,Integer>{

    private int capacity;

    public LRUCache3(int capacity) {
        super(capacity,1,true);
        this.capacity=capacity;
    }

    public int get(int key) {
        Integer res=super.get(key);
        if(res==null) return -1;
        return res;

    }

    public void put(int key, int value) {
        super.put(key,value);
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
        return this.size() > capacity;
    }


    public static void main(String[] args) {
        LRUCache3 cache = new LRUCache3(2);
        log.info(cache.get(2) + "");
        cache.put(2,6);
        log.info(cache.get(1) + "");
        cache.put(1,5);
        cache.put(1,2);

        log.info(cache.get(1) + "");
        log.info(cache.get(2) + "");

        System.out.println("");
        System.out.println("");

        LRUCache3 cache2 = new LRUCache3(2);
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
