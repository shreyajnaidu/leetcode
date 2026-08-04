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
    public ListNode rotateRight(ListNode head, int k) {
        if(head==null || head.next==null){
            return head;
        }
        ListNode first=head;
        ListNode temp=head;
        int length=0;
        ListNode dummy=new ListNode(0);
        dummy.next=head;
        while(temp!=null){
            temp=temp.next;
            length++;
        }
        int j=k%length;
        if(j==0){
            return head;
        }
        ListNode temp2=head;
        for(int i=0;i<length-j-1;i++){
            temp2=temp2.next;
        }
        ListNode curr=temp2.next;
        temp2.next=null;
        dummy.next=curr;
        while(curr.next!=null){
            curr=curr.next;
        }
        curr.next=first;
        return dummy.next;
    }
}