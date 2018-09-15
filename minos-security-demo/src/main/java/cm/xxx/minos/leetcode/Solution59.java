package cm.xxx.minos.leetcode;


/**
 * 相交链表
 * 解题思路：
 * 1. 相交链表只会存在如下情况（链表相交，只会在链表尾部相交，或者完全相等）：
 *    情况1：
 *    A1 -> B1 ->
 *                  C -> D -> E
 *          B2 ->
 *    情况2：
 *    A1 -> B1 ->
 *                  C -> D -> E
 *    A2 -> B2 ->
 *    情况3：
 *    A -> B -> C -> D -> -> E
 *    A -> B -> C -> D -> -> E
 *    情况4：
 *          B1 ->
 *                  C -> D -> E
 *    A2 -> B2 ->
 * 2. 所以如果在链表最后节点相等才会存在相交
 * 3. 如果链表的长度不相等，放弃较长左边的节点，使两链表长度相等
 * 4. 同时遍历两个链表
 * Author: lishangmin
 * Created: 2018-08-23 10:16
 */
public class Solution59 {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null) return null;
        int headALength = 0 , headBLength = 0;
        ListNode p = headA , q = headB;
        while (p.next != null || q.next != null) {
            if(p == q) return p;
            if(p.next != null) {
                p = p.next;
                headALength++;
            }
            if(q.next != null){
                q = q.next;
                headBLength++;
            }
        }
        if(p != q) return null;
        p = headA;
        q = headB;
        while (headALength > headBLength){
            p = p.next;
            headALength--;
        }
        while (headALength < headBLength){
            q = q.next;
            headBLength--;
        }
        while (p != q){
            p = p.next;
            q = q.next;
        }
        return p;
    }

    public static void main(String[] args) {
        Solution59 solution = new Solution59();
    }

}
