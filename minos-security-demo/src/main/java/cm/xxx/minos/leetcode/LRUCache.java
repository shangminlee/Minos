package cm.xxx.minos.leetcode;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

/**
 * Description: LRU (最近最少使用) 缓存机制。
 * Author: lishangmin
 * Created: 2018-09-05 17:50
 */
@Slf4j
public class LRUCache {

    private List<Pair> list;

    private int capacity;

    private class Pair{
        int key;
        int value;

        public Pair(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    public LRUCache(int capacity) {
        this.list = new ArrayList<>();
        this.capacity = capacity;
    }

    public int get(int key) {
        for (int i = 0; i < this.list.size(); i++) {
            if(key == this.list.get(i).key) {
                Pair pair = this.list.get(i);
                this.put(key,pair.value);
                return pair.value;
            }
        }
        return -1;
    }

    public void put(int key, int value) {
        for (int i = 0; i < this.list.size(); i++) {
            if(key == this.list.get(i).key) {
                list.remove(i);
                break;
            }
        }
        if(list.size() >= capacity){
            list.remove(list.size() - 1);
        }
        Pair pair = new Pair(key,value);
        list.add(0,pair);
    }

    public static void main(String[] args) {
        LRUCache cache = new LRUCache(2);
        log.info(cache.get(2) + "");
        cache.put(2,6);
        log.info(cache.get(1) + "");
        cache.put(1,5);
        cache.put(1,2);

        log.info(cache.get(1) + "");
        log.info(cache.get(2) + "");

    }
}
