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
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        ListNode temp1=list1;
        ListNode temp2=list2;
        for(int i=0;i<a-1;i++){
            temp1=temp1.next;
        }
        ListNode temp3=temp1;
        for(int i=a-1;i<b;i++){
            temp1=temp1.next;
        }
        ListNode temp4=temp1.next;
        ListNode temp5=list2;
        while(temp5.next!=null){
            temp5=temp5.next;
        }
        temp3.next=null;
        temp3.next=temp2;
        temp1.next=null;
        temp5.next=temp4;
        return list1;
    }
}