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
    public ListNode oddEvenList(ListNode head) {
        ListNode dummy1=new ListNode(0);
        ListNode dummy2=new ListNode(0);
        ListNode prev1=dummy1;
        ListNode prev2=dummy2;
        ListNode temp=head;
        int count=0;
        while(temp!=null){
            ListNode next=temp.next;
            if(count%2==0){
                prev1.next=temp;
                prev1=temp;
            }else{
                prev2.next=temp;
                prev2=temp;
            }
            temp=next;
            count++;
        }
        prev2.next=null;
        prev1.next=dummy2.next;
        return dummy1.next;
    }
}