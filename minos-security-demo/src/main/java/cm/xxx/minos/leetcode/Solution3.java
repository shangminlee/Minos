package cm.xxx.minos.leetcode;

/**
 * Description:
 * Author: lishangmin
 * Created: 2018-08-22 15:23
 */
public class Solution3 {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        ListNode p = l1 , q = l2 , cur = dummyHead;
        int factor = 0;
        while (p != null || q != null){
            int v1 = p != null ? p.val:0;
            int v2 = q != null ? q.val:0;
            int value = v1 + v2 + factor;
            factor = value / 10;
            cur.next = new ListNode(value%10);
            cur = cur.next;
            if(q != null) q = q.next;
            if(p != null) p = p.next;
        }
        if(factor > 0){
            cur.next = new ListNode(factor);
        }
        return dummyHead.next;
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

        String v1 = "5";
        String v2 = "5";

        ListNode n1 = solution2.toNode(v1);
        ListNode n2 = solution2.toNode(v2);

        System.out.println(Integer.MAX_VALUE);
        ListNode result = solution2.addTwoNumbers(n1,n2);

    }
}
