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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode temp1=l1;
        ListNode temp2=l2;
        int sum=0;
        int carry=0;
        ListNode dummy=new ListNode(0);
        ListNode prev=dummy;
        while(temp1!=null && temp2!=null){
            sum=temp1.val+temp2.val+carry;
            if(sum>9){
                carry=sum/10;
                sum=sum%10;
            }else{
                carry=0;
            }
            ListNode temp=new ListNode(sum);
            prev.next=temp;
            prev=temp;
            temp1=temp1.next;
            temp2=temp2.next;
        }
        if(temp1!=null){
            while(temp1!=null){
            sum=temp1.val+carry;
            if(sum>9){
                carry=sum/10;
                sum=sum%10;
            }else{
                carry=0;
            }
            ListNode temp=new ListNode(sum);
            prev.next=temp;
            prev=temp;
            temp1=temp1.next;
            }
        }else if(temp2!=null){
            while(temp2!=null){
            sum=temp2.val+carry;
            if(sum>9){
                carry=sum/10;
                sum=sum%10;
            }else{
                carry=0;
            }
            ListNode temp=new ListNode(sum);
            prev.next=temp;
            prev=temp;
            temp2=temp2.next;
            }
        }
        if(carry!=0){
            ListNode temp=new ListNode(carry);
            prev.next=temp;
        }
        return dummy.next;
    }
}