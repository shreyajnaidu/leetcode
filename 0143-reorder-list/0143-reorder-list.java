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
    public void reorderList(ListNode head) {
        if(head==null || head.next==null){
    return;
}
        ListNode temp=head;
        int length=0;
        while(temp!=null){
            length++;
            temp=temp.next;
        }
        temp=head;
        ListNode temp1=head;
        int n=0;
        if(length%2==0){
            n=length/2;
        }else{
            n=((length/2)+1);
        }
        for(int i=0;i<n-1;i++){
            temp=temp.next;
        }
        ListNode temp2=temp.next;
        temp.next=null;
        ListNode prev=null;
        ListNode current=temp2;
        while(current!=null){
            ListNode next=current.next;
            current.next=prev;
            prev=current;
            current=next;
        }
        temp2=prev;
        while(temp1!=null && temp2!=null){
            ListNode next1=temp1.next;
            ListNode next2=temp2.next;
            temp1.next=temp2;
            temp2.next=next1;
            temp1=next1;
            temp2=next2;
        }
    }
}