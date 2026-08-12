/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int length1=0;
        int length2=0;
        ListNode temp1=headA;
        ListNode temp2=headB;
        while(temp1!=null){
            length1++;
            temp1=temp1.next;
        }
        while(temp2!=null){
            length2++;
            temp2=temp2.next;
        }
        int diff=Math.abs(length1-length2);
        ListNode temp;
        if(length1>length2){
            temp=headA;
            for(int i=0;i<diff;i++){
            temp=temp.next;
            headA=temp;
            }
        }else{
            temp=headB;
            for(int i=0;i<diff;i++){
            temp=temp.next;
            headB=temp;
            }
        }
        while (headA != headB) {
        headA = headA.next;
        headB = headB.next;
    }

    return headA;
    }
}