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
    public ListNode reverseEvenLengthGroups(ListNode head) {
    int i=1;
    if (head == null || head.next == null) {
            return head;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev=dummy;
    while(prev!=null){
        int count=0;
        ListNode temp=prev;
        while(count<i && temp.next!=null){
            temp=temp.next;
            count++;
        }
        i++;
        if((count)%2==0){
            ListNode end=temp.next;
            ListNode curr=prev.next;
            ListNode before=end;
            ListNode oldStart=curr;

            while(curr!=end){
                ListNode next=curr.next;
                curr.next=before;
                before=curr;
                curr=next;
            }
            prev.next=before;
            prev=oldStart;
        }else{
            for(int j=0;j<count;j++){
                prev=prev.next;
            }
        }
    }
    return dummy.next;
    }
}