package cm.xxx.minos.leetcode;


/**
 * 反转链表
 * 解题思路：基于上一中写法优化
 *
 * Author: lishangmin
 * Created: 2018-08-23 10:16
 */
public class Solution64 {

    public ListNode reverseList(ListNode head) {
        ListNode n = null, cur = head;
        while (cur != null){
            ListNode temp = cur.next;
            cur.next = n;
            n = cur;
            cur = temp;
        }
        return n;
    }

    public static void main(String[] args) {
        Solution64 solution = new Solution64();
    }

}
