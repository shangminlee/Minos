package cm.xxx.minos.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Description: 最小栈
 * Author: lishangmin
 * Created: 2018-09-04 14:19
 */
public class MinStack {

    private List<Integer> array;

    /** initialize your data structure here. */
    public MinStack() {
        array = new ArrayList<>();
    }

    public void push(int x) {
        array.add(x);
    }

    public void pop() {
        if(array.isEmpty()) return;
        array.remove(array.size() - 1);
    }

    public int top() {
        if(array.isEmpty()) return -1;
        return array.get(array.size() - 1);
    }

    public int getMin() {
        if (array.isEmpty()) return -1;
        int min = array.get(0);
        for (int i = 1; i < array.size() ; i++) {
            if(min > array.get(i)){
                min = array.get(i);
            }
        }
        return min;
    }
}
