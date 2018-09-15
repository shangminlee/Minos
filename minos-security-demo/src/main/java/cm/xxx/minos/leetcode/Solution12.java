package cm.xxx.minos.leetcode;


import com.alibaba.fastjson.JSON;

/**
 * Author: lishangmin
 * Created: 2018-08-23 10:16
 */
public class Solution12 {


    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null){
            return l2;
        }
        if(l2 == null){
            return l1;
        }
        ListNode head;
        if(l1.val < l2.val){
            head = l1;
            head.next = mergeTwoLists(l1.next,l2);
        }else {
            head = l2;
            head.next = mergeTwoLists(l1,l2.next);
        }
        return head;
    }
    public static void main(String[] args) {
        Solution2 solution2 = new Solution2();
        String v1 = "2";
        String v2 = "3";

        ListNode n1 = solution2.toNode(v1);
        ListNode n2 = solution2.toNode(v2);

        System.out.println(Integer.MAX_VALUE);


        Solution12 solution = new Solution12();
        ListNode result = solution.mergeTwoLists(n1,n2);
        System.out.println(JSON.toJSONString(result));

    }

}
