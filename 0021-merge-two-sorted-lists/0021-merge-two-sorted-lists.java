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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy=new ListNode(0);
        ListNode prev=dummy;
        dummy.next=null;
        ListNode temp1=list1;
        ListNode temp2=list2;
        while(temp1!=null && temp2!=null){
            if(temp1.val<=temp2.val){
                prev.next=temp1;
                prev=temp1;
                temp1=temp1.next;
            }else{
                prev.next=temp2;
                prev=temp2;
                temp2=temp2.next;
            }
        }
        if(temp1!=null){
           prev.next=temp1; 
        }else if(temp2!=null){
            prev.next=temp2;
        }
        return dummy.next;
    }
}