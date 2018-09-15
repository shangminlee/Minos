package cm.xxx.minos.leetcode;


/**
 * 反转链表
 * 解题思路：递归写法
 *
 * Author: lishangmin
 * Created: 2018-08-23 10:16
 */
public class Solution65 {

    public ListNode reverseList(ListNode head) {
        if(head==null || head.next==null){
            return head;
        }
        ListNode node = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return node;
    }

    public static void main(String[] args) {
        Solution65 solution = new Solution65();
    }

}
