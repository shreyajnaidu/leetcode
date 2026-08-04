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

        ListNode prev = null;
        ListNode current = l1;

        while (current != null) {
            ListNode next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        ListNode temp1 = prev;

        prev = null;
        current = l2;

        while (current != null) {
            ListNode next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        ListNode temp2 = prev;

        int carry = 0;
        ListNode result = new ListNode(0);
        ListNode temp = result;

        while (temp1 != null || temp2 != null || carry != 0) {

            int x = (temp1 != null) ? temp1.val : 0;
            int y = (temp2 != null) ? temp2.val : 0;

            int sum = x + y + carry;

            carry = sum / 10;
            sum = sum % 10;

            temp.next = new ListNode(sum);
            temp = temp.next;

            if (temp1 != null)
                temp1 = temp1.next;

            if (temp2 != null)
                temp2 = temp2.next;
        }
        prev = null;
        current = result.next;

        while (current != null) {
            ListNode next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }

        return prev;
    }
}