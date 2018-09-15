package cm.xxx.minos.leetcode;


/**
 * 删除链表的倒数第N个节点
 *
 * 解题思路：（优化写法-增加一个虚拟空结点）
 * 1. 双指针法；
 * 2. 初始化 x 指针指向头结点，y 指针指向 第 n 结点
 * 3. 如果 y 指针 结尾 为 Null 或者 head，到达链表尾部
 * Author: lishangmin
 * Created: 2018-08-23 10:16
 */
public class Solution61 {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head == null) return null;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode x = dummy , y = dummy;
        while (n-- > 0 && y != null){
            y = y.next;
        }
        while (y != null){
            x = x.next;
            y = y.next;
        }
        x.next = x.next.next;
        return dummy.next;
    }

    public static void main(String[] args) {
        Solution61 solution = new Solution61();
    }

}
