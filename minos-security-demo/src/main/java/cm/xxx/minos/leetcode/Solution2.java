package cm.xxx.minos.leetcode;

import com.alibaba.fastjson.JSON;

/**
 * Description: 两数之和
 * Author: lishangmin
 * Created: 2018-08-22 11:24
 */
public class Solution2 {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        return add(null,l1,l2,0);
    }

    private ListNode add(ListNode result,ListNode l1, ListNode l2,int factor){
        int v1 = l1 != null ? l1.val:0;
        int v2 = l2 != null ? l2.val:0;
        int value = v1 + v2 + factor;
        factor = value / 10;
        result =  (l1 != null || l2 != null) ? new ListNode(value % 10):result;
        if(result != null) {
            l1 = l1!= null? l1.next: null;
            l2 = l2!= null? l2.next: null;
            if(l1 == null && l2 == null && factor > 0){
                result.next = new ListNode(factor);
            }else{
                result.next = add(result.next,l1,l2,factor);
            }
        }
        return result;
    }


    public ListNode toNode(String value){
        if (value == null || value.length() < 0){
            throw new IllegalArgumentException("error argument");
        }
        char[] chars = value.toCharArray();
        ListNode cur = null;
        for (int i = chars.length -1 ; i >= 0 ; i--) {
            cur = add(cur, Integer.valueOf(String.valueOf(chars[i])));
        }
        return cur;
    }

    public ListNode add(ListNode listNode,int value){
        if(listNode == null){
            return new ListNode(value);
        }
        listNode.next = add(listNode.next,value);
        return listNode;
    }

    public static void main(String[] args) {
        Solution2 solution2 = new Solution2();
//        String v1 = "243";
//        String v2 = "564";
//
//        String v1 = "5";
//        String v2 = "5";

//        String v1 = "9999999993";
//        String v2 = "7";

//        String v1 = "89";
//        String v2 = "1";

        String v1 = "89";
        String v2 = "1";

        ListNode n1 = solution2.toNode(v1);
        ListNode n2 = solution2.toNode(v2);

        System.out.println(Integer.MAX_VALUE);
        ListNode result = solution2.addTwoNumbers(n1,n2);
        System.out.println(JSON.toJSONString(result));
    }
}
