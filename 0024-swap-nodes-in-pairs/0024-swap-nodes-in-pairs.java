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
    public ListNode swapPairs(ListNode head) {
        if(head==null||head.next==null){
            return head;
        }
        ListNode dummy=new ListNode(0);
        dummy.next=head;
        ListNode before=dummy;
        ListNode prev=null;
        ListNode curr=null;
        while(before.next!=null && before.next.next!=null){
            prev=before.next;
            curr=prev.next;
            prev.next=curr.next;
            curr.next=prev;
            before.next=curr;
            before=prev;
        }
        return dummy.next;
    }
} 