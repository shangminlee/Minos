package cm.xxx.minos.leetcode;

import com.alibaba.fastjson.JSON;

/**
 * Description:
 * Author: lishangmin
 * Created: 2018-08-22 15:23
 */
public class Solution4 {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
       int size1 = getSize(l1);
       int size2 = getSize(l2);
       int factor = 0;
       ListNode dummyHead = new ListNode(0);
       dummyHead.next = size1 >= size2 ? l1 : l2;
       ListNode p = l1 , q = l2 , cur = dummyHead;
       while (p != null && q != null){
           int value = p.val + q.val + factor;
           factor = value / 10;
           cur.next.val = value % 10;
           cur = cur.next;
           q = q.next;
           p = p.next;
       }
       if (factor > 0){
           if(cur.next == null){
               cur.next = new ListNode(factor);
           }else {
               while (cur.next!= null && cur.next.val == 9){
                   cur.next.val = 0;
                   cur = cur.next;
               }
               if (cur.next == null){
                   cur.next = new ListNode(factor);
               }else {
                   cur.next.val = cur.next.val + factor;
               }
           }
       }
       return dummyHead.next;
    }

    public int getSize(ListNode listNode){
        if(listNode == null){
            return 0;
        }
        return getSize(listNode.next) + 1;
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
        Solution4 solution4 = new Solution4();
//        String v1 = "243";
//        String v2 = "564";

//        String v1 = "5";
//        String v2 = "5";

//        String v1 = "9999999993";
//        String v2 = "7";

        String v1 = "89";
        String v2 = "1";

        ListNode n1 = solution4.toNode(v1);
        ListNode n2 = solution4.toNode(v2);

        System.out.println(Integer.MAX_VALUE);
        ListNode result = solution4.addTwoNumbers(n1,n2);
        System.out.println(JSON.toJSONString(result));
    }
}
