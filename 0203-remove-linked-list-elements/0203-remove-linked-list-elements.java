/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode removeElements(ListNode head, int val) {
        if(head==null){
            return null;
        }
        ListNode temp=head;
        if(temp.next==null){
            if(head.val==val){
                return null;
            }else{
                return head;
            }
        }
        while(temp.next!=null){
            ListNode temp2=temp.next;
            if(head.val==val){
                temp=head.next;
                head.next=null;
                head=temp;
            }else if(temp2.val==val){
                temp.next=temp2.next;
                temp2.next=null;
            }else{
                temp=temp.next;
            }
        }
        if(head.val==val){
            return null;
        }
        return head;
    }
}