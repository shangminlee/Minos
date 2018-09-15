package cm.xxx.minos.data.struct;

/**
 * Description:
 * Author: lishangmin
 * Created: 2018-08-12 19:04
 */
public class Recursion {

    public static ListNode removeElement(ListNode head,int val){
        if(head == null){
            return null;
        }
        head.next = removeElement(head.next,val);
        if(head.e.equals(val)){
            return head.next;
        }else{
            return head;
        }
    }

    public static ListNode print(ListNode head){

        if(head == null){
            return null;
        }
        System.out.println(head.e);
        head.next = print(head.next);
        return head;
    }

    public static void main(String[] args) {
        Integer[] arr = {21,2,4,8,4};
        ListNode<Integer> listNode = new ListNode<>(arr);
        System.out.println(listNode);

        listNode = removeElement(listNode,4);
        System.out.println(listNode);

        ListNode arrs = print(listNode);
        System.out.println(arrs);
    }
}
