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
    public ListNode partition(ListNode head, int x) {
        ListNode dummy1=new ListNode(0);
        ListNode dummy2=new ListNode(0);
        dummy1.next=head;
        ListNode prev1=dummy1;
        ListNode temp=head;
        ListNode prev2=dummy2;
        while(temp!=null && temp!=dummy2){
            ListNode next=temp.next;
            if(temp.val<x){
                prev1.next=temp;
                prev1=temp;
            }else{
                prev2.next=temp;
                prev2=temp;
            }
            temp=next;
        }
        prev2.next=null;
        prev1.next=dummy2.next;
        return dummy1.next;
    }
}