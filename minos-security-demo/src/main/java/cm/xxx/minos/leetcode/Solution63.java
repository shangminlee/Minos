package cm.xxx.minos.leetcode;


/**
 * 反转链表
 * 解题思路：
 * 1. 如果入参为空或者单节点，直接返回 入参
 * 2. 双指针： n 永远指向头节点， cur 遍历指针，从链表的
 *    的第二个节点位置开始遍历
 * 3. 使用cur替代头节点， cur.next 指向原头节点
 *
 * Author: lishangmin
 * Created: 2018-08-23 10:16
 */
public class Solution63 {

    public ListNode reverseList(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode n = head, cur = head.next;
        n.next = null;
        while (cur != null){
            ListNode temp = cur.next;
            cur.next = n;
            n = cur;
            cur = temp;
        }
        return n;
    }

    public static void main(String[] args) {
        Solution63 solution = new Solution63();
    }

}
