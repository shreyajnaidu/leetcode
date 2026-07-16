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
    public ListNode reverse(ListNode head) {
        ListNode temp = head;
        ListNode before = null;
        while (temp != null) {
            ListNode after = temp.next;
            temp.next = before;
            before = temp;
            temp = after;
        }
        return before;
    }
    public int getDecimalValue(ListNode head) {
        head = reverse(head);
        ListNode temp = head;
        int power = 0;
        int total_count = 0;
        while (temp != null) {
            total_count += temp.val * (1 << power);
            power++;
            temp = temp.next;
        }
        return total_count;
    }
}